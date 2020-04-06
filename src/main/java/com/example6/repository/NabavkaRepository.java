package com.example6.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example6.model.Nabavka;

@Repository
public interface NabavkaRepository extends CrudRepository<Nabavka, Long> {

}
