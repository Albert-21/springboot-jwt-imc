package com.grokonez.jwtauthentication.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.grokonez.jwtauthentication.exception.ResourceNotFoundException;
import com.grokonez.jwtauthentication.model.Pesos;
import com.grokonez.jwtauthentication.repository.PesosRepository;


@RestController
@RequestMapping("/calculator")
@CrossOrigin(origins = "*")
public class PesosController {
    @Autowired
    private PesosRepository pesosRepository;

    @GetMapping("/pesos")
    public List<Pesos> getAllPesos() {
        return pesosRepository.findAll();
    }

    @GetMapping("/pesos/{id}")
    public ResponseEntity<Pesos> getPesosById(@PathVariable(value = "id") Long PesosId)
        throws ResourceNotFoundException {
        Pesos pesos = pesosRepository.findById(PesosId)
          .orElseThrow(() -> new ResourceNotFoundException("Pesos not found for this id :: " + PesosId));
        return ResponseEntity.ok().body(pesos);
    }
    
    @PostMapping("/pesos")
    public Pesos createPesos(@Valid @RequestBody Pesos pesos) {
        return pesosRepository.save(pesos);
    }

    @GetMapping("/pesos/{username}")
    public ResponseEntity<Pesos> getPesosByUsername(@PathVariable(value = "username") String username)
        throws ResourceNotFoundException {
        Pesos pesos = (Pesos) pesosRepository.findByUsername(username);
        //.orElseThrow(() -> new ResourceNotFoundException("Pesos not found for this username :: " + username));
        return ResponseEntity.ok().body(pesos);
    }

    @PutMapping("/pesos/{id}")
    public ResponseEntity<Pesos> updatePesos(@PathVariable(value = "id") Long pesosId,
         @Valid @RequestBody Pesos pesosDetails) throws ResourceNotFoundException {
        Pesos pesos = pesosRepository.findById(pesosId)
        .orElseThrow(() -> new ResourceNotFoundException("Pesos not found for this id :: " + pesosId));

        pesos.setId(pesosDetails.getId());
        pesos.setImc(pesosDetails.getImc());
        pesos.setEstado(pesosDetails.getEstado());
        pesos.setPeso_min(pesosDetails.getPeso_min());
        pesos.setEstado(pesosDetails.getPeso_max());
        final Pesos updatedPesos = pesosRepository.save(pesos);
        return ResponseEntity.ok(updatedPesos);
    }

    @DeleteMapping("/pesos/{id}")
    public Map<String, Boolean> deletePesos(@PathVariable(value = "id") Long pesosId)
         throws ResourceNotFoundException {
        Pesos pesos = pesosRepository.findById(pesosId)
       .orElseThrow(() -> new ResourceNotFoundException("Pesos not found for this id :: " + pesosId));

        pesosRepository.delete(pesos);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}