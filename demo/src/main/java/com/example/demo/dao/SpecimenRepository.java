package com.example.demo.dao;

import com.example.demo.dto.SpecimenDto;
import org.springframework.data.repository.CrudRepository;

public interface SpecimenRepository extends CrudRepository<SpecimenDto,String> {

}
