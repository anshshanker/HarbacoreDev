package com.example.demo.dao;

import com.example.demo.dto.SpecimenDto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

public interface SpecimenRepository {

    public boolean save(SpecimenDto specimenDto)
            throws Exception; // function prototype for saving a post data
    SpecimenDto findById(String id)throws Exception;
    boolean existsById(String id)throws Exception;
}
