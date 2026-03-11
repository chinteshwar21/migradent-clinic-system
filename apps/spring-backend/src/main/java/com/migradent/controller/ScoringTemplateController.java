package com.migradent.controller;

import com.migradent.dto.ScoringTemplateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/scoring-templates")
@RequiredArgsConstructor
public class ScoringTemplateController {

    // Mock storage for MVP
    private final List<ScoringTemplateDto> templates = new ArrayList<>();

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ScoringTemplateDto> create(@Valid @RequestBody ScoringTemplateDto dto) {
        dto.setId(java.util.UUID.randomUUID().toString());
        templates.add(dto);
        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<ScoringTemplateDto>> list() {
        return ResponseEntity.ok(templates);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<ScoringTemplateDto> getById(@PathVariable String id) {
        return templates.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ScoringTemplateDto> update(
            @PathVariable String id,
            @Valid @RequestBody ScoringTemplateDto dto) {
        return templates.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .map(existing -> {
                    dto.setId(id);
                    int index = templates.indexOf(existing);
                    templates.set(index, dto);
                    return ResponseEntity.ok(dto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        templates.removeIf(t -> t.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}
