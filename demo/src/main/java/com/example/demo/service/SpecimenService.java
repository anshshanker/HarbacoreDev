package com.example.demo.service;

import com.example.demo.dao.ISpecimenDao;
import com.example.demo.dto.SpecimenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SpecimenService implements ISpecimenService{

    @Autowired
    ISpecimenDao specimenDAO;

    @Override
    public boolean save(SpecimenDto specimenDTO) throws Exception {
        specimenDAO.save(specimenDTO);
        return false;
    }

    @Override
    public SpecimenDto findById(String id)throws Exception{
        return specimenDAO.findById(id);
    }

    @Override
    public boolean existsById(String id) throws Exception {
        return specimenDAO.existsById(id);
    }

}
