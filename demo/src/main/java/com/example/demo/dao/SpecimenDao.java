package com.example.demo.dao;

import com.example.demo.dto.SpecimenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpecimenDao implements ISpecimenDao {

    @Autowired
    SpecimenRepository specimenRepository;
    @Override
    public boolean save(SpecimenDto specimenDTO) throws Exception {
        specimenRepository.save(specimenDTO);
        return false;
    }


    @Override
    public Optional<SpecimenDto> findById(String id)throws Exception{
        return specimenRepository.findById(id);
    }

    @Override
    public boolean existsById(String id) throws Exception {
        return specimenRepository.existsById(id);
    }
}
