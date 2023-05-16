package com.company.dtk.microservicesinmueble.service;

import com.company.dtk.microservicesinmueble.model.Inmueble;
import com.company.dtk.microservicesinmueble.repository.InmuebleRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InmuebleServiceImpl implements InmuebleService {


    private InmuebleRepository inmuebleRepository;

    public InmuebleServiceImpl(InmuebleRepository inmuebleRepository) {
        this.inmuebleRepository = inmuebleRepository;
    }

    @Override
    public Inmueble saveInmueble(Inmueble inmueble) {
        inmueble.setDate(LocalDateTime.now());
        return inmuebleRepository.save(inmueble);
    }

    @Override
    public void deleteInmueble(Long id) {
        inmuebleRepository.deleteById(id);
    }

    @Override
    public List<Inmueble> findAllInmueble() {
        return inmuebleRepository.findAll();
    }
}
