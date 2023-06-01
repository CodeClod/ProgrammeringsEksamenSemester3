package com.example.programmeringseksamensemester3.config;

import com.example.programmeringseksamensemester3.model.Sejlbåd;
import com.example.programmeringseksamensemester3.repository.SejlbådRepository;
import com.example.programmeringseksamensemester3.service.KapsejladsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class InitData implements CommandLineRunner {
    // Entities are created on application start in run method
    /* In this case used to fill db with dummy entities which makes it easier to
    test the implementation of viewing db data on the frontend.
     */

    @Autowired
    SejlbådRepository sejlbådRepository;

    @Autowired
    KapsejladsService kapsejladsService;


    @Override
    public void run(String... args) throws Exception {

        Sejlbåd sejlbåd1 = new Sejlbåd();

        sejlbåd1.setNavn("The Black Pearl");
        sejlbåd1.setBådtype("Længere end 40fod");
        sejlbådRepository.save(sejlbåd1);

        Sejlbåd sejlbåd2 = new Sejlbåd();
        sejlbåd2.setNavn("Titanic");
        sejlbåd2.setBådtype("Mindre end 25fod");
        sejlbådRepository.save(sejlbåd2);

        // Add kapsejlads' to db
        kapsejladsService.createKapsejlads();
    }


}
