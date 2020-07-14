package com.example.demo.service;

import com.example.demo.dto.SpecimenDto;

import java.util.Optional;

public interface ISpecimenService {
    boolean save(SpecimenDto specimenDTO)throws Exception;

    Optional<SpecimenDto> findById(String id)throws Exception;

    boolean existsById(String id)throws Exception;

}
