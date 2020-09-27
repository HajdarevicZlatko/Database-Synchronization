package com.example.demo.models;

import java.util.Date;
import java.util.List;

public class VisokoskolskaUstanova {

    //PROPERTIES
    /*"TIP_UST=?, " +
            "VU_IDENTIFIKATOR=?, " +
            "VU_NAZIV=?, " +
            "DR_IDENTIFIKATOR=?, " +
            "VU_OSNOVANA=?, " +
            "NM_IDENTIFIKATOR=?, " +
            "VU_ADRESA=?, " +
            "VU_WEB_ADRESA=?, " +
            "VU_E_MAIL=?, " +
            "VV_OZNAKA=?, " +
            "VU_PIB=?, " +
            "VU_MATICNI_BROJ=?, " +
            "VU_GRB=?, " +
            "VU_MEMORANDUM=?"

     */
    private int VU_IDENTIFIKATOR;
    private String TIP_UST;
    private String VU_NAZIV;
    private String DR_IDENTIFIKATOR;
    private Date VU_OSNOVANA;
    int NM_IDENTIFIKATOR;
    private String VU_ADRESA;
    private String VU_WEB_ADRESA;
    private String VU_E_MAIL;
    private String VV_OZNAKA;
    private String VU_PIB;
    private String VU_MATICNI_BROJ;
    private byte[] VU_GRB;
    private byte[] VU_MEMORANDUM;
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

            String TIP_UST,
            int VU_IDENTIFIKATOR,
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
        this.VU_IDENTIFIKATOR = VU_IDENTIFIKATOR;
        this.TIP_UST = TIP_UST;
        this.VU_NAZIV = VU_NAZIV;
        this.DR_IDENTIFIKATOR = DR_IDENTIFIKATOR;
        this.VU_OSNOVANA = VU_OSNOVANA;
        this.NM_IDENTIFIKATOR=NM_IDENTIFIKATOR;
        this.VU_ADRESA = VU_ADRESA;
        this.VU_WEB_ADRESA = VU_WEB_ADRESA;
        this.VU_E_MAIL = VU_E_MAIL;
        this.VV_OZNAKA = VV_OZNAKA;
        this.VU_PIB = VU_PIB;
        this.VU_MATICNI_BROJ = VU_MATICNI_BROJ;
        this.VU_GRB = VU_GRB;
        this.VU_MEMORANDUM = VU_MEMORANDUM;
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

    public int getVU_IDENTIFIKATOR() {
        return VU_IDENTIFIKATOR;
    }

    public void setVU_IDENTIFIKATOR(int VU_IDENTIFIKATOR) {
        this.VU_IDENTIFIKATOR = VU_IDENTIFIKATOR;
    }

    public String getTIP_UST() {
        return TIP_UST;
    }

    public void setTIP_UST(String TIP_UST) {
        this.TIP_UST = TIP_UST;
    }

    public String getVU_NAZIV() {
        return VU_NAZIV;
    }

    public void setVU_NAZIV(String VU_NAZIV) {
        this.VU_NAZIV = VU_NAZIV;
    }

    public Date getVU_OSNOVANA() {
        return VU_OSNOVANA;
    }

    public void setVU_OSNOVANA(Date VU_OSNOVANA) {
        this.VU_OSNOVANA = VU_OSNOVANA;
    }

    public String getVU_ADRESA() {
        return VU_ADRESA;
    }

    public void setVU_ADRESA(String VU_ADRESA) {
        this.VU_ADRESA = VU_ADRESA;
    }

    public String getVU_WEB_ADRESA() {
        return VU_WEB_ADRESA;
    }

    public void setVU_WEB_ADRESA(String VU_WEB_ADRESA) {
        this.VU_WEB_ADRESA = VU_WEB_ADRESA;
    }

    public String getVU_E_MAIL() {
        return VU_E_MAIL;
    }

    public void setVU_E_MAIL(String VU_E_MAIL) {
        this.VU_E_MAIL = VU_E_MAIL;
    }

    public String getVV_OZNAKA() {
        return VV_OZNAKA;
    }

    public void setVV_OZNAKA(String VV_OZNAKA) {
        this.VV_OZNAKA = VV_OZNAKA;
    }

    public String getVU_PIB() {
        return VU_PIB;
    }

    public void setVU_PIB(String VU_PIB) {
        this.VU_PIB = VU_PIB;
    }

    public String getVU_MATICNI_BROJ() {
        return VU_MATICNI_BROJ;
    }

    public void setVU_MATICNI_BROJ(String VU_MATICNI_BROJ) {
        this.VU_MATICNI_BROJ = VU_MATICNI_BROJ;
    }

    public byte[] getVU_GRB() {
        return VU_GRB;
    }

    public void setVU_GRB(byte[] VU_GRB) {
        this.VU_GRB = VU_GRB;
    }

    public byte[] getVU_MEMORANDUM() {
        return VU_MEMORANDUM;
    }

    public void setVU_MEMORANDUM(byte[] VU_MEMORANDUM) {
        this.VU_MEMORANDUM = VU_MEMORANDUM;
    }
}
