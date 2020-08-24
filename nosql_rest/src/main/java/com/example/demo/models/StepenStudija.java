package com.example.demo.models;

import java.util.List;

public class StepenStudija {
    String STS_oznaka;
    String naziv;
    List<NivoStudija> nivoStudijaList;

    public StepenStudija(String STS_oznaka, String naziv, List<NivoStudija> list) {
        this.STS_oznaka = STS_oznaka;
        this.naziv = naziv;
        nivoStudijaList=list;
    }



    public StepenStudija() {
    }

    public List<NivoStudija> getNivoStudijaList() {
        return nivoStudijaList;
    }

    public void setNivoStudijaList(List<NivoStudija> nivoStudijaList) {
        this.nivoStudijaList = nivoStudijaList;
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
