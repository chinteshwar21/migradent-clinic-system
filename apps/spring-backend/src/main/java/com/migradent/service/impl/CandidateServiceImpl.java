package com.migradent.service.impl;

import com.migradent.dto.CandidateDto;
import com.migradent.model.Candidate;
import com.migradent.repository.CandidateRepository;
import com.migradent.service.CandidateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository repository;

    @Override
    @Transactional
    public CandidateDto create(CandidateDto dto) {
        log.info("Creating candidate: {}", dto.getFirstName());
        Candidate entity = toEntity(dto);
        Candidate saved = repository.save(entity);
        log.info("Candidate created with id: {}", saved.getId());
        return toDto(saved);
    }

    @Override
    @Transactional
    public CandidateDto update(String id, CandidateDto dto) {
        log.info("Updating candidate: {}", id);
        Candidate existing = repository.findById(id)
                .orElseThrow(() -> {
                    log.error("Candidate not found with id: {}", id);
                    return new IllegalArgumentException("Candidate not found with id: " + id);
                });
        existing.setFirstName(dto.getFirstName());
        existing.setLastName(dto.getLastName());
        existing.setDob(dto.getDob());
        existing.setContactEmail(dto.getContactEmail());
        existing.setContactPhone(dto.getContactPhone());
        existing.setStatus(dto.getStatus());
        Candidate saved = repository.save(existing);
        log.info("Candidate updated: {}", id);
        return toDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public CandidateDto findById(String id) {
        log.info("Fetching candidate: {}", id);
        return repository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> {
                    log.error("Candidate not found with id: {}", id);
                    return new IllegalArgumentException("Candidate not found with id: " + id);
                });
    }

    @Override
    @Transactional(readOnly = true)
    public List<CandidateDto> findAll() {
        log.info("Fetching all candidates");
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(String id) {
        log.info("Deleting candidate: {}", id);
        if (!repository.existsById(id)) {
            log.error("Candidate not found with id: {}", id);
            throw new IllegalArgumentException("Candidate not found with id: " + id);
        }
        repository.deleteById(id);
        log.info("Candidate deleted: {}", id);
    }

    private CandidateDto toDto(Candidate c) {
        CandidateDto dto = new CandidateDto();
        dto.setId(c.getId());
        dto.setFirstName(c.getFirstName());
        dto.setLastName(c.getLastName());
        dto.setDob(c.getDob());
        dto.setContactEmail(c.getContactEmail());
        dto.setContactPhone(c.getContactPhone());
        dto.setStatus(c.getStatus());
        return dto;
    }

    private Candidate toEntity(CandidateDto dto) {
        Candidate c = new Candidate();
        c.setFirstName(dto.getFirstName());
        c.setLastName(dto.getLastName());
        c.setDob(dto.getDob());
        c.setContactEmail(dto.getContactEmail());
        c.setContactPhone(dto.getContactPhone());
        c.setStatus(dto.getStatus());
        return c;
    }
}