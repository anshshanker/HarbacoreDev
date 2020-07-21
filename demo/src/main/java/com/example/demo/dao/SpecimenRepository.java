package com.example.demo.dao;

import com.example.demo.dto.SpecimenDto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SpecimenRepository {
    boolean save(SpecimenDto specimenDTO)throws Exception;
    Optional<SpecimenDto> findById(String id)throws Exception;
    boolean existsById(String id)throws Exception;
}
