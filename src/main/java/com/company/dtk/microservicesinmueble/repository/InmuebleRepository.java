package com.company.dtk.microservicesinmueble.repository;

import com.company.dtk.microservicesinmueble.model.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {

}