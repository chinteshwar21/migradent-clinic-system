package com.migradent.controller;

import com.migradent.dto.AppointmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    // Mock storage for MVP
    private final List<AppointmentDto> appointments = new ArrayList<>();

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<AppointmentDto> create(@Valid @RequestBody AppointmentDto dto) {
        dto.setId(java.util.UUID.randomUUID().toString());
        appointments.add(dto);
        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<AppointmentDto>> list() {
        return ResponseEntity.ok(appointments);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<AppointmentDto> getById(@PathVariable String id) {
        return appointments.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<AppointmentDto> update(
            @PathVariable String id,
            @Valid @RequestBody AppointmentDto dto) {
        return appointments.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .map(existing -> {
                    dto.setId(id);
                    int index = appointments.indexOf(existing);
                    appointments.set(index, dto);
                    return ResponseEntity.ok(dto);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        appointments.removeIf(a -> a.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}
