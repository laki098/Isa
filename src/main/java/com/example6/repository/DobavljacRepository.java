package com.example6.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example6.model.Dobavljac;


@Repository
public interface DobavljacRepository extends CrudRepository<Dobavljac, Long> {

}
