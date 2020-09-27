package com.example.demo.models;

public class Student {
    public String ime;
    public String prezime;
    public String adresa;
    public String grad;
    public String drzava;
    public String zip;
    public String studije;
    public String program;
    public String fakultet;
    private String indeks;

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public Student() {
    }

    public Student(String ime, String prezime, String adresa, String grad, String drzava, String zip, String studije, String program, String fakultet) {
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.zip = zip;
        this.studije = studije;
        this.program = program;
        this.fakultet = fakultet;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStudije() {
        return studije;
    }

    public void setStudije(String studije) {
        this.studije = studije;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getFakultet() {
        return fakultet;
    }

    public void setFakultet(String fakultet) {
        this.fakultet = fakultet;
    }
}
