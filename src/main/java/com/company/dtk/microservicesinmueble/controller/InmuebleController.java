package com.company.dtk.microservicesinmueble.controller;

import com.company.dtk.microservicesinmueble.model.Inmueble;
import com.company.dtk.microservicesinmueble.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inmueble")
public class InmuebleController {

    @Autowired
    private InmuebleService inmuebleService;
    @GetMapping

    public ResponseEntity<?> getAllInmueble() throws InterruptedException {
        return ResponseEntity.ok(inmuebleService.findAllInmueble());
    }

    @PostMapping
    public ResponseEntity<?> createInmueble(@RequestBody Inmueble inmueble) throws InterruptedException {
        return new ResponseEntity<>(
                inmuebleService.createInmueble(inmueble),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteInmueble(@PathVariable Long id) throws InterruptedException {
        inmuebleService.deleteInmueble(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
