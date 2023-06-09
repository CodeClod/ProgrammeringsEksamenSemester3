package com.example.programmeringseksamensemester3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class KapsejladsDeltager {
    // Tried to make Kapsejlads-Deltager is a form of pseudo-binary entity relationship that connects Boats and "Kapsejlads" and holds point from each time.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kapsejladsDeltagerId;

    @ManyToOne
    @JoinColumn(name = "kapsejlads_id")
    @JsonBackReference
    private Kapsejlads kapsejlads;

    @OneToOne
    @JoinColumn(name = "sejlbåd_id")
    @JsonBackReference
    private Sejlbåd sejlbåd;


    private int points;

    public int getKapsejladsDeltagerId() {
        return kapsejladsDeltagerId;
    }

    public void setKapsejladsDeltagerId(int kapsejladsDeltagerId) {
        this.kapsejladsDeltagerId = kapsejladsDeltagerId;
    }

    public Kapsejlads getKapsejlads() {
        return kapsejlads;
    }

    public void setKapsejlads(Kapsejlads kapsejladsId) {
        this.kapsejlads = kapsejladsId;
    }

    public Sejlbåd getSejlbåd() {
        return sejlbåd;
    }

    public void setSejlbåd(Sejlbåd sejlbådId) {
        this.sejlbåd = sejlbådId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
