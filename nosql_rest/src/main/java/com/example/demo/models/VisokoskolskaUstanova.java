package com.example.demo.models;

import java.util.Date;
import java.util.List;

public class VisokoskolskaUstanova {

    //PROPERTIES
    private int id;
    private String tip_ustanove;
    private String naziv;
    private String DR_IDENTIFIKATOR;
    private Date osnovana;
    private String adresa;
    private String web_adresa;
    private String email;
    private String oznaka;
    private String PIB;
    private String maticni_broj;
    private byte[] grb;
    private byte[] memorandum;
    int NM_IDENTIFIKATOR;



    private List<RegistrovaniProgrami> registrovaniProgramiLIst;
    private List<NastavniPredmeti> nastavniPredmeti;


    //CONSTRUCTORS
    public VisokoskolskaUstanova() {
    }

    public VisokoskolskaUstanova(
            /*
            TIP_UST,
             VU_IDENTIFIKATOR,
              VU_NAZIV,
               DR_IDENTIFIKATOR,
                VU_OSNOVANA,
                 NM_IDENTIFIKATOR,
                  VU_ADRESA,
                   VU_WEB_ADRESA,
                    VU_E_MAIL,
                     VV_OZNAKA,
                      VU_PIB,
                       VU_MATICNI_BROJ,
                        VU_GRB,
                         VU_MEMORANDUM
             */
            int VU_IDENTIFIKATOR,
            String TIP_UST,
            String VU_NAZIV,
            String DR_IDENTIFIKATOR,
            Date VU_OSNOVANA,
            int NM_IDENTIFIKATOR,
            String VU_ADRESA,
            String VU_WEB_ADRESA,
            String VU_E_MAIL,
            String VV_OZNAKA,
            String VU_PIB,
            String VU_MATICNI_BROJ,
            byte[] VU_GRB,
            byte[] VU_MEMORANDUM,
            List<RegistrovaniProgrami> registrovaniProgramiLIst,
            List<NastavniPredmeti> nastavniPredmeti
    )
    {
        this.id = VU_IDENTIFIKATOR;
        this.tip_ustanove = TIP_UST;
        this.naziv = VU_NAZIV;
        this.DR_IDENTIFIKATOR = DR_IDENTIFIKATOR;
        this.osnovana = VU_OSNOVANA;
        this.NM_IDENTIFIKATOR=NM_IDENTIFIKATOR;
        this.adresa = VU_ADRESA;
        this.web_adresa = VU_WEB_ADRESA;
        this.email = VU_E_MAIL;
        this.oznaka = VV_OZNAKA;
        this.PIB = VU_PIB;
        this.maticni_broj = VU_MATICNI_BROJ;
        this.grb = VU_GRB;
        this.memorandum = VU_MEMORANDUM;
        this.registrovaniProgramiLIst = registrovaniProgramiLIst;
        this.nastavniPredmeti = nastavniPredmeti;
    }

    //METHODDS
    public List<RegistrovaniProgrami> getRegistrovaniProgramiLIst() {
        return registrovaniProgramiLIst;
    }

    public void setRegistrovaniProgramiLIst(List<RegistrovaniProgrami> registrovaniProgramiLIst) {
        this.registrovaniProgramiLIst = registrovaniProgramiLIst;
    }

    public String getDR_IDENTIFIKATOR() {
        return DR_IDENTIFIKATOR;
    }

    public void setDR_IDENTIFIKATOR(String DR_IDENTIFIKATOR) {
        this.DR_IDENTIFIKATOR = DR_IDENTIFIKATOR;
    }

    public int getNM_IDENTIFIKATOR() {
        return NM_IDENTIFIKATOR;
    }

    public void setNM_IDENTIFIKATOR(int NM_IDENTIFIKATOR) {
        this.NM_IDENTIFIKATOR = NM_IDENTIFIKATOR;
    }

    public List<NastavniPredmeti> getNastavniPredmeti() {
        return nastavniPredmeti;
    }

    public void setNastavniPredmeti(List<NastavniPredmeti> nastavniPredmeti) {
        this.nastavniPredmeti = nastavniPredmeti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTip_ustanove() {
        return tip_ustanove;
    }

    public void setTip_ustanove(String tip_ustanove) {
        this.tip_ustanove = tip_ustanove;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }


    public Date getOsnovana() {
        return osnovana;
    }

    public void setOsnovana(Date osnovana) {
        this.osnovana = osnovana;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getWeb_adresa() {
        return web_adresa;
    }

    public void setWeb_adresa(String web_adresa) {
        this.web_adresa = web_adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public String getMaticni_broj() {
        return maticni_broj;
    }

    public void setMaticni_broj(String maticni_broj) {
        this.maticni_broj = maticni_broj;
    }

    public byte[] getGrb() {
        return grb;
    }

    public void setGrb(byte[] grb) {
        this.grb = grb;
    }

    public byte[] getMemorandum() {
        return memorandum;
    }

    public void setMemorandum(byte[] memorandum) {
        this.memorandum = memorandum;
    }
}
