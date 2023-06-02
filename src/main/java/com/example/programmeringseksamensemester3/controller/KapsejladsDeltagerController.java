package com.example.programmeringseksamensemester3.controller;

import com.example.programmeringseksamensemester3.model.Kapsejlads;
import com.example.programmeringseksamensemester3.model.KapsejladsDeltager;
import com.example.programmeringseksamensemester3.repository.KapsejladsDeltagerRepository;
import com.example.programmeringseksamensemester3.repository.KapsejladsRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/kapsejladsdeltager")
public class KapsejladsDeltagerController {

    @Autowired
    KapsejladsDeltagerRepository kapsejladsDeltagerRepository;

    @Autowired
    KapsejladsRepository  kapsejladsRepository;

    @GetMapping("/getAllByKapsejlads")
    public ResponseEntity<List<KapsejladsDeltager>> getAllKapsejladsDeltagere(@RequestBody Kapsejlads kapsejlads) {
        List<KapsejladsDeltager> deltagerList = kapsejladsDeltagerRepository.getKapsejladsDeltagerByKapsejlads(kapsejlads);
        return new ResponseEntity<>(deltagerList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<KapsejladsDeltager> createKapsejladsDeltager(@RequestBody KapsejladsDeltager kapsejladsDeltager) {
        KapsejladsDeltager createdDeltager = kapsejladsDeltagerRepository.save(kapsejladsDeltager);
        return new ResponseEntity<>(createdDeltager, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KapsejladsDeltager> getKapsejladsDeltagerById(@PathVariable int id) {
        Optional<KapsejladsDeltager> deltagerOptional = kapsejladsDeltagerRepository.findById(id);
        if (deltagerOptional.isPresent()) {
            return new ResponseEntity<>(deltagerOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Not useful at all since there will be duplicate-ish db entities, Kapsejlads-Deltager is a form of pseudo-tertiary entity relationship that holds
    @GetMapping
    public ResponseEntity<List<KapsejladsDeltager>> getAllKapsejladsDeltagere() {
        List<KapsejladsDeltager> deltagerList = kapsejladsDeltagerRepository.findAll();
        return new ResponseEntity<>(deltagerList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<KapsejladsDeltager> updateKapsejladsDeltager(
            @PathVariable int id, @RequestBody KapsejladsDeltager kapsejladsDeltager) {
        Optional<KapsejladsDeltager> deltagerOptional = kapsejladsDeltagerRepository.findById(id);
        if (deltagerOptional.isPresent()) {
            KapsejladsDeltager existingDeltager = deltagerOptional.get();
            existingDeltager.setPoints(kapsejladsDeltager.getPoints());
            // Set other properties as needed

            KapsejladsDeltager updatedDeltager = kapsejladsDeltagerRepository.save(existingDeltager);
            return new ResponseEntity<>(updatedDeltager, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKapsejladsDeltager(@PathVariable int id) {
        Optional<KapsejladsDeltager> deltagerOptional = kapsejladsDeltagerRepository.findById(id);
        if (deltagerOptional.isPresent()) {
            kapsejladsDeltagerRepository.delete(deltagerOptional.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
