package com.example.programmeringseksamensemester3.controller;

import com.example.programmeringseksamensemester3.model.Kapsejlads;
import com.example.programmeringseksamensemester3.model.KapsejladsDeltager;
import com.example.programmeringseksamensemester3.repository.KapsejladsRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class KapsejladsController {

    @Autowired
    KapsejladsRepository kapsejladsRepository;

    @GetMapping("/kapsejladsInOrder")
    private List<Kapsejlads> returnAllKapsejladsInAscOrder() {
        return kapsejladsRepository.findAllByOrderByKapsejladsDatoAsc();
    }
}
