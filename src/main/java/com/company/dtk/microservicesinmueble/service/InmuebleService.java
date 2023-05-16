package com.company.dtk.microservicesinmueble.service;

import com.company.dtk.microservicesinmueble.model.Inmueble;

import java.util.List;

public interface InmuebleService {
    Inmueble saveInmueble(Inmueble inmueble);

    void deleteInmueble(Long id);

    List<Inmueble> findAllInmueble();
}
