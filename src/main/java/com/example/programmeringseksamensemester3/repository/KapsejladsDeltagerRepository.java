package com.example.programmeringseksamensemester3.repository;

import com.example.programmeringseksamensemester3.model.KapsejladsDeltager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface KapsejladsDeltagerRepository extends JpaRepository<KapsejladsDeltager, Integer> {

    // Make optional if there's time
    List<KapsejladsDeltager> findKapsejladsDeltagersByKapsejlads_KapsejladsId(int kapsejladsId);




}
