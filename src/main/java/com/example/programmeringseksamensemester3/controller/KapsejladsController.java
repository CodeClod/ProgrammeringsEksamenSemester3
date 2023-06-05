package com.example.programmeringseksamensemester3.controller;

import com.example.programmeringseksamensemester3.model.Kapsejlads;
import com.example.programmeringseksamensemester3.repository.KapsejladsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class KapsejladsController {

    @Autowired
    KapsejladsRepository kapsejladsRepository;

    @GetMapping("/kapsejladsInOrder")
    private List<Kapsejlads> returnAllKapsejladsInOrder() {
        return kapsejladsRepository.findAllByOrderByKapsejladsId();
    }
}
