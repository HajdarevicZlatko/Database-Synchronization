package com.example.demo.models;

import java.util.Date;
import java.util.List;

public class RegistrovaniProgrami {
    //PROPERTIES
    private String TIP_UST;
    private int VU_IDENTIFIKATOR;
    char TIPP_TIP;
    int SP_EVIDENCIONI_BROJ;
    double SP_VERZIJA;
    String SP_NAZIV;
    String STS_OZNAKA;
    double NS_NIVO;
    String JEZ_JERIK2;
    String SN_OZNAKA;
    Date SP_DATUM_FORMIRANJA;
    Date SP_DATUM_UKIDANJA;
    List<NivoStudija> nivoStudijaList;



    //CONSTRUCTORS
    public RegistrovaniProgrami(
            String TIP_UST,
            int VU_IDENTIFIKATOR,
            char TIPP_TIP,
            int SP_EVIDENCIONI_BROJ,
            double SP_VERZIJA, String SP_NAZIV,
            String STS_OZNAKA,
            double NS_NIVO,
            String JEZ_JERIK2,
            String SN_OZNAKA,
            Date SP_DATUM_FORMIRANJA,
            Date SP_DATUM_UKIDANJA,
            List<NivoStudija> list
    ) {
        this.TIP_UST = TIP_UST;
        this.VU_IDENTIFIKATOR = VU_IDENTIFIKATOR;
        this.TIPP_TIP = TIPP_TIP;
        this.SP_EVIDENCIONI_BROJ = SP_EVIDENCIONI_BROJ;
        this.SP_VERZIJA = SP_VERZIJA;
        this.SP_NAZIV = SP_NAZIV;
        this.STS_OZNAKA = STS_OZNAKA;
        this.NS_NIVO = NS_NIVO;
        this.JEZ_JERIK2 = JEZ_JERIK2;
        this.SN_OZNAKA = SN_OZNAKA;
        this.SP_DATUM_FORMIRANJA = SP_DATUM_FORMIRANJA;
        this.SP_DATUM_UKIDANJA = SP_DATUM_UKIDANJA;
        this.nivoStudijaList=list;
    }

    public RegistrovaniProgrami() {
    }
    //METHODS
    public String getTIP_UST() {
        return TIP_UST;
    }

    public List<NivoStudija> getNivoStudijaList() {
        return nivoStudijaList;
    }

    public void setNivoStudijaList(List<NivoStudija> nivoStudijaList) {
        this.nivoStudijaList = nivoStudijaList;
    }

    public void setTIP_UST(String TIP_UST) {
        this.TIP_UST = TIP_UST;
    }

    public int getVU_IDENTIFIKATOR() {
        return VU_IDENTIFIKATOR;
    }

    public void setVU_IDENTIFIKATOR(int VU_IDENTIFIKATOR) {
        this.VU_IDENTIFIKATOR = VU_IDENTIFIKATOR;
    }

    public char getTIPP_TIP() {
        return TIPP_TIP;
    }

    public void setTIPP_TIP(char TIPP_TIP) {
        this.TIPP_TIP = TIPP_TIP;
    }

    public int getSP_EVIDENCIONI_BROJ() {
        return SP_EVIDENCIONI_BROJ;
    }

    public void setSP_EVIDENCIONI_BROJ(int SP_EVIDENCIONI_BROJ) {
        this.SP_EVIDENCIONI_BROJ = SP_EVIDENCIONI_BROJ;
    }

    public double getSP_VERZIJA() {
        return SP_VERZIJA;
    }

    public void setSP_VERZIJA(double SP_VERZIJA) {
        this.SP_VERZIJA = SP_VERZIJA;
    }

    public String getSP_NAZIV() {
        return SP_NAZIV;
    }

    public void setSP_NAZIV(String SP_NAZIV) {
        this.SP_NAZIV = SP_NAZIV;
    }

    public String getSTS_OZNAKA() {
        return STS_OZNAKA;
    }

    public void setSTS_OZNAKA(String STS_OZNAKA) {
        this.STS_OZNAKA = STS_OZNAKA;
    }

    public double getNS_NIVO() {
        return NS_NIVO;
    }

    public void setNS_NIVO(double NS_NIVO) {
        this.NS_NIVO = NS_NIVO;
    }

    public String getJEZ_JERIK2() {
        return JEZ_JERIK2;
    }

    public void setJEZ_JERIK2(String JEZ_JERIK2) {
        this.JEZ_JERIK2 = JEZ_JERIK2;
    }

    public String getSN_OZNAKA() {
        return SN_OZNAKA;
    }

    public void setSN_OZNAKA(String SN_OZNAKA) {
        this.SN_OZNAKA = SN_OZNAKA;
    }

    public Date getSP_DATUM_FORMIRANJA() {
        return SP_DATUM_FORMIRANJA;
    }

    public void setSP_DATUM_FORMIRANJA(Date SP_DATUM_FORMIRANJA) {
        this.SP_DATUM_FORMIRANJA = SP_DATUM_FORMIRANJA;
    }

    public Date getSP_DATUM_UKIDANJA() {
        return SP_DATUM_UKIDANJA;
    }

    public void setSP_DATUM_UKIDANJA(Date SP_DATUM_UKIDANJA) {
        this.SP_DATUM_UKIDANJA = SP_DATUM_UKIDANJA;
    }
}
