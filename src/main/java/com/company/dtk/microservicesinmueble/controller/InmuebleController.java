package com.company.dtk.microservicesinmueble.controller;

import com.company.dtk.microservicesinmueble.model.Inmueble;
import com.company.dtk.microservicesinmueble.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/innmueble")
public class InmuebleController {

    @Autowired
    private InmuebleService inmuebleService;

    @GetMapping
    public ResponseEntity<?> getAllInmueble() {
        return ResponseEntity.ok(inmuebleService.findAllInmueble());
    }

    @PostMapping
    public ResponseEntity<?> createInmueble(@RequestBody Inmueble inmueble) {
        return new ResponseEntity<>(
                inmuebleService.createInmueble(inmueble),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteInmueble(@PathVariable Long id) {
        inmuebleService.deleteInmueble(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
