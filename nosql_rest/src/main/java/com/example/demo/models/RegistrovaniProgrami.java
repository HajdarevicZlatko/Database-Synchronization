package com.example.demo.models;

import java.util.Date;
import java.util.List;

public class RegistrovaniProgrami {
    //PROPERTIES
    private char tip;
    private int evidencioni_broj;
    private double verzija;
    private String naziv;
    private List<NivoStudija> nivoStudijaList;
    private Date datum_formiranja;
    private Date datum_ukidanja;

    //CONSTRUCTORS
    public RegistrovaniProgrami(
            char tip,
            int evidencioni_broj,
            double verzija,
            String naziv,
            List<NivoStudija> nivoStudijaList,
            Date datum_formiranja,
            Date datum_ukidanja)
    {
        this.tip = tip;
        this.evidencioni_broj = evidencioni_broj;
        this.verzija = verzija;
        this.naziv = naziv;
        this.nivoStudijaList = nivoStudijaList;
        this.datum_formiranja = datum_formiranja;
        this.datum_ukidanja = datum_ukidanja;
    }

    public RegistrovaniProgrami() {
    }

    //METHODS

    public char getTip() {
        return tip;
    }

    public void setTip(char tip) {
        this.tip = tip;
    }

    public int getEvidencioni_broj() {
        return evidencioni_broj;
    }

    public void setEvidencioni_broj(int evidencioni_broj) {
        this.evidencioni_broj = evidencioni_broj;
    }

    public double getVerzija() {
        return verzija;
    }

    public void setVerzija(double verzija) {
        this.verzija = verzija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<NivoStudija> getNivoStudijaList() {
        return nivoStudijaList;
    }

    public void setNivoStudijaList(List<NivoStudija> nivoStudijaList) {
        this.nivoStudijaList = nivoStudijaList;
    }

    public Date getDatum_formiranja() {
        return datum_formiranja;
    }

    public void setDatum_formiranja(Date datum_formiranja) {
        this.datum_formiranja = datum_formiranja;
    }

    public Date getDatum_ukidanja() {
        return datum_ukidanja;
    }

    public void setDatum_ukidanja(Date datum_ukidanja) {
        this.datum_ukidanja = datum_ukidanja;
    }
}
