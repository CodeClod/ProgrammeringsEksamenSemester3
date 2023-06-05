package com.example.programmeringseksamensemester3.repository;

import com.example.programmeringseksamensemester3.model.Kapsejlads;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KapsejladsRepository extends JpaRepository<Kapsejlads, Integer> {

    List<Kapsejlads> findAllByOrderByKapsejladsDatoAsc();

    List<Kapsejlads> findAllByOrderByKapsejladsId();

}
