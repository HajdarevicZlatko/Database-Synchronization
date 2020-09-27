package com.example.demo.models;

import java.util.List;

public class StepenStudija {
    String STS_oznaka;
    String naziv;

    public StepenStudija(String STS_oznaka, String naziv) {
        this.STS_oznaka = STS_oznaka;
        this.naziv = naziv;
    }



    public StepenStudija() {
    }

    public String getSTS_oznaka() {
        return STS_oznaka;
    }

    public void setSTS_oznaka(String STS_oznaka) {
        this.STS_oznaka = STS_oznaka;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
