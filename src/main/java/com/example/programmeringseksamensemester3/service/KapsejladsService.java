package com.example.programmeringseksamensemester3.service;

import com.example.programmeringseksamensemester3.model.Kapsejlads;
import com.example.programmeringseksamensemester3.repository.KapsejladsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

    @Service
    public class KapsejladsService {

        @Autowired
        private KapsejladsRepository kapsejladsRepository;

        public void createKapsejlads() {
            LocalDate startDate = LocalDate.of(LocalDate.now().getYear(), 5, 1);
            LocalDate endDate = LocalDate.of(LocalDate.now().getYear(), 10, 1);

            Set<LocalDate> wednesdays = new HashSet<>();
            LocalDate current = startDate;
            while (current.isBefore(endDate) || current.isEqual(endDate)) {
                if (current.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                    wednesdays.add(current);
                }
                current = current.plusDays(1);
            }

            for (LocalDate wednesday : wednesdays) {
                Kapsejlads kapsejlads = new Kapsejlads();
                kapsejlads.setNavn("Kapsejlads " + wednesday.toString());
                kapsejlads.setKapsejladsDato(wednesday);
                kapsejladsRepository.save(kapsejlads);
            }
        }
    }

