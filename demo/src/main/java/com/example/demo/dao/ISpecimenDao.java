package com.example.demo.dao;

import com.example.demo.dto.SpecimenDto;

public interface ISpecimenDao {
    boolean save(SpecimenDto specimenDTO)throws Exception;
    SpecimenDto findById(String id)throws Exception;
    boolean existsById(String id)throws Exception;
}
