package com.example.demo.models;

public class NastavniPredmeti {
    private String VU_tip_ustanove;
    private int VU_identifikator;
    private String predmet;
    private double verzija;
    private String naziv_predmeta;
    private boolean izborni;

    public NastavniPredmeti() {
    }

    public NastavniPredmeti(String VU_tip_ustanove, int VU_identifikator, String predmet, double verzija, String naziv_predmeta, boolean izborni) {
        this.VU_tip_ustanove = VU_tip_ustanove;
        this.VU_identifikator = VU_identifikator;
        this.predmet = predmet;
        this.verzija = verzija;
        this.naziv_predmeta = naziv_predmeta;
        this.izborni = izborni;
    }

    public String getVU_tip_ustanove() {
        return VU_tip_ustanove;
    }

    public void setVU_tip_ustanove(String VU_tip_ustanove) {
        this.VU_tip_ustanove = VU_tip_ustanove;
    }

    public int getVU_identifikator() {
        return VU_identifikator;
    }

    public void setVU_identifikator(int VU_identifikator) {
        this.VU_identifikator = VU_identifikator;
    }

    public String getPredmet() {
        return predmet;
    }

    public void setPredmet(String predmet) {
        this.predmet = predmet;
    }

    public double getVerzija() {
        return verzija;
    }

    public void setVerzija(double verzija) {
        this.verzija = verzija;
    }

    public String getNaziv_predmeta() {
        return naziv_predmeta;
    }

    public void setNaziv_predmeta(String naziv_predmeta) {
        this.naziv_predmeta = naziv_predmeta;
    }

    public boolean isIzborni() {
        return izborni;
    }

    public void setIzborni(boolean izborni) {
        this.izborni = izborni;
    }
}
