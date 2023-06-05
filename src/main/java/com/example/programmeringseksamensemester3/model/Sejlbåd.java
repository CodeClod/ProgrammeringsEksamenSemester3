package com.example.programmeringseksamensemester3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Sejlbåd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sejlbådId;


    private String navn;
    private String bådtype;


    /*
        @OneToOne
        @JoinColumn(name = "kapsejlads_deltager_id")
        private KapsejladsDeltager kapsejladsDeltager;


         */
    public int getSejlbådId() {
        return sejlbådId;
    }

    public void setSejlbådId(int sejlbådId) {
        this.sejlbådId = sejlbådId;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBådtype() {
        return bådtype;
    }

    public void setBådtype(String bådtype) {
        this.bådtype = bådtype;
    }
}
