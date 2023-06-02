package com.example.programmeringseksamensemester3.repository;

import com.example.programmeringseksamensemester3.model.Kapsejlads;
import com.example.programmeringseksamensemester3.model.KapsejladsDeltager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface KapsejladsDeltagerRepository extends JpaRepository<KapsejladsDeltager, Integer> {

    // Make optional if there's time
    List<KapsejladsDeltager> getKapsejladsDeltagerByKapsejlads(Kapsejlads kapsejlads);


}
