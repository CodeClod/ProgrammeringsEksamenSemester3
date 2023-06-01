package com.example.programmeringseksamensemester3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
public class Kapsejlads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kapsejladsId;

    private String navn;
    private LocalDate kapsejladsDato;

    @OneToMany(mappedBy = "kapsejlads")
    @JsonBackReference
    private Set<KapsejladsDeltager> kapsejladsDeltagere;



    public int getKapsejladsId() {
        return kapsejladsId;
    }

    public void setKapsejladsId(int kapsejladsId) {
        this.kapsejladsId = kapsejladsId;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public LocalDate getKapsejladsDato() {
        return kapsejladsDato;
    }

    public void setKapsejladsDato(LocalDate kapsejladsDato) {
        this.kapsejladsDato = kapsejladsDato;
    }

    public Set<KapsejladsDeltager> getKapsejladsDeltagere() {
        return kapsejladsDeltagere;
    }

    public void setKapsejladsDeltagere(Set<KapsejladsDeltager> kapsejladsDeltagere) {
        this.kapsejladsDeltagere = kapsejladsDeltagere;
    }
}
