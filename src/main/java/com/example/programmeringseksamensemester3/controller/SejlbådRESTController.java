package com.example.programmeringseksamensemester3.controller;

import com.example.programmeringseksamensemester3.model.Sejlbåd;
import com.example.programmeringseksamensemester3.repository.SejlbådRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@Table(name = "sejlbåde")
public class SejlbådRESTController {

    @Autowired
    SejlbådRepository sejlbådRepository;


    // Creates an sejlbåd
    @PostMapping ("/createSejlbåd")
    public ResponseEntity<Sejlbåd> saveSejlbåd(@RequestBody Sejlbåd sejlbåd) {
        sejlbådRepository.save(sejlbåd);

        return new ResponseEntity<>(sejlbåd, HttpStatus.CREATED);
    }

    // Returns a list of sejlbåd
    @GetMapping("/sejlbåde")
    public List<Sejlbåd> getSejlbåde() {
        return sejlbådRepository.findAll();
    }

    // updates existing s
    @PutMapping("/sejlbåd/{id}")
    public ResponseEntity<Sejlbåd> updateSejlbåd(@PathVariable int id, @RequestBody Sejlbåd sejlbåd) {
        Optional<Sejlbåd> optBoat = sejlbådRepository.findById(id);
        if (optBoat.isPresent()) {
            sejlbådRepository.save(sejlbåd);
            return new ResponseEntity<>(sejlbåd,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/sejlbåd/{id}")
    public ResponseEntity<Sejlbåd> deleteSejlbåd(@PathVariable("id") Integer id) {
        sejlbådRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
