package com.example.demo.models;

import java.util.List;

public class NivoStudija {
    //PROPERTIES
    double nivo;
    private String naziv;
    private String oznaka;
    private String sts_oznaka;
    List<StepenStudija> stepenStudijaList;

    //CONSTRUCTORS
    public NivoStudija() {
    }

    public NivoStudija(String sts_oznaka, double nivo, String naziv, String oznaka,List<StepenStudija> stepenStudijaList) {
        this.nivo = nivo;
        this.naziv = naziv;
        this.oznaka = oznaka;
        this.sts_oznaka=sts_oznaka;
        this.stepenStudijaList=stepenStudijaList;
    }

    //METHODS
    public String getSts_oznaka() {
        return sts_oznaka;
    }

    public List<StepenStudija> getStepenStudijaList() {
        return stepenStudijaList;
    }

    public void setStepenStudijaList(List<StepenStudija> stepenStudijaList) {
        this.stepenStudijaList = stepenStudijaList;
    }

    public void setSts_oznaka(String sts_oznaka) {
        this.sts_oznaka = sts_oznaka;
    }
    public double getNivo() {
        return nivo;
    }

    public void setNivo(double nivo) {
        this.nivo = nivo;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }
}
