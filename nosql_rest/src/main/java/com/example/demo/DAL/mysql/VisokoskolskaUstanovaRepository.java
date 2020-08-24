package com.example.demo.DAL.mysql;

import com.example.demo.interfaces.IDAL;
import com.example.demo.models.NastavniPredmeti;
import com.example.demo.models.VisokoskolskaUstanova;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisokoskolskaUstanovaRepository implements IDAL<VisokoskolskaUstanova> {
    Connection con;

    public VisokoskolskaUstanovaRepository() {
        con=MySqlDriver.getDriver();
    }

    @Override
    public List<VisokoskolskaUstanova> getAll() {
        List<VisokoskolskaUstanova> list = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from Visokoskolska_Ustanova");
            NastavniPredmetiRepository b=new NastavniPredmetiRepository();
            while (rs.next()) {
/*
            int id,
            String tip_ustanove,
            String naziv,
            String identifikator,
            Date osnovana,
            int NM_IDENTIFIKATOR;
            String adresa,
            String web_adresa,
            String email,
            String oznaka,
            String PIB,
            String maticni_broj,
            byte[] grb,
            byte[] memorandum,
            List<RegistrovaniProgrami> registrovaniProgramiLIst,
            List<NastavniPredmeti> nastavniPredmeti
 */
                list.add(new VisokoskolskaUstanova(
                        rs.getInt(2),
                        rs.getString(1),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getBytes(13),
                        rs.getBytes(14),
                        null,
                         b.getAllByTipAndIdentificator(rs.getString(1),rs.getInt(2))
                ));
            }
            con.close();
        } catch (Exception throwables) {
            System.out.println(throwables.toString());
            throwables.printStackTrace();
        } finally {
            return list;
        }
    }

    @Override
    public VisokoskolskaUstanova getById(String id) {
        return null;
    }



    @Override
    public boolean updateEntity(VisokoskolskaUstanova visokoskolskaUstanova) {
        return false;
    }

    @Override
    public boolean removeEntity(String id) {
        return false;
    }

    @Override
    public boolean insert(VisokoskolskaUstanova visokoskolskaUstanova) {
        return false;
    }
}
