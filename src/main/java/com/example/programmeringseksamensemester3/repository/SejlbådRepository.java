package com.example.programmeringseksamensemester3.repository;

import com.example.programmeringseksamensemester3.model.Sejlbåd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SejlbådRepository extends JpaRepository<Sejlbåd, Integer> {



}
