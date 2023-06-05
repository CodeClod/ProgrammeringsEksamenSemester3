package com.example.programmeringseksamensemester3.controller;

import com.example.programmeringseksamensemester3.model.Kapsejlads;
import com.example.programmeringseksamensemester3.model.KapsejladsDeltager;
import com.example.programmeringseksamensemester3.model.Sejlbåd;
import com.example.programmeringseksamensemester3.repository.KapsejladsDeltagerRepository;
import com.example.programmeringseksamensemester3.repository.KapsejladsRepository;
import com.example.programmeringseksamensemester3.repository.SejlbådRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/kapsejladsdeltager")
public class KapsejladsDeltagerController {

    @Autowired
    KapsejladsDeltagerRepository kapsejladsDeltagerRepository;

    @Autowired
    KapsejladsRepository  kapsejladsRepository;

    @Autowired
    SejlbådRepository sejlbådRepository;

    @PostMapping("/create")
    public ResponseEntity<KapsejladsDeltager> createKapsejladsDeltager(@RequestBody Map<String, String> request) {
        Integer kapsejladsId = Integer.valueOf(request.get("kapsejlads"));
        Integer sejlbådId = Integer.valueOf(request.get("sejlbåd"));
        int points = Integer.parseInt(request.get("points"));
        int placering = Integer.parseInt(request.get("placering"));

        Kapsejlads kapsejlads = kapsejladsRepository.findById(kapsejladsId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Kapsejlads ID: " + kapsejladsId));
        Sejlbåd sejlbåd = sejlbådRepository.findById(sejlbådId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Sejlbåd ID: " + sejlbådId));

        KapsejladsDeltager kapsejladsDeltager = new KapsejladsDeltager();
        kapsejladsDeltager.setKapsejlads(kapsejlads);
        kapsejladsDeltager.setSejlbåd(sejlbåd);
        kapsejladsDeltager.setPoints(points);
        kapsejladsDeltager.setPlacering(placering);

        System.out.println(kapsejladsDeltager.getSejlbåd());
        System.out.println(kapsejladsDeltager.getKapsejladsDeltagerId());
        KapsejladsDeltager createdKapsejladsDeltager = kapsejladsDeltagerRepository.save(kapsejladsDeltager);

        System.out.println(createdKapsejladsDeltager.getKapsejlads());
        System.out.println(createdKapsejladsDeltager.getKapsejladsDeltagerId());

        return new ResponseEntity<>(createdKapsejladsDeltager, HttpStatus.CREATED);
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

    @GetMapping("/getAllByKapsejladsId/{kapsejladsId}")
    public ResponseEntity<List<KapsejladsDeltager>> getAllKapsejladsDeltagereByKapsejladsId(@PathVariable int kapsejladsId) {
        List<KapsejladsDeltager> deltagerList = kapsejladsDeltagerRepository.findKapsejladsDeltagersByKapsejlads_KapsejladsId(kapsejladsId);
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
