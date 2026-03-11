package com.migradent.service;

import com.migradent.dto.CandidateDto;

import java.util.List;

public interface CandidateService {
    CandidateDto create(CandidateDto dto);
    CandidateDto update(String id, CandidateDto dto);
    CandidateDto findById(String id);
    List<CandidateDto> findAll();
    void delete(String id);
}
