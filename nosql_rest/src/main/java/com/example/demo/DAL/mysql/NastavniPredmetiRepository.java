package com.example.demo.DAL.mysql;

import com.example.demo.interfaces.IDAL;
import com.example.demo.models.NastavniPredmeti;

import java.sql.*;
import java.util.*;

public class NastavniPredmetiRepository implements IDAL<NastavniPredmeti> {

    Connection con;

    public NastavniPredmetiRepository() {
        con=MySqlDriver.getDriver();
    }


    @Override
    public List<NastavniPredmeti> getAll() {
        List<NastavniPredmeti> list = new ArrayList<>();
        try {


            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from nastavni_predmeti");
            while (rs.next()) {
                //String VU_tip_ustanove, int VU_identifikator, String predmet, double verzija, String naziv_predmeta, boolean izborni
                list.add(new NastavniPredmeti(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getBoolean(6)
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
    public NastavniPredmeti getById(String id) {

        NastavniPredmeti predmet = new NastavniPredmeti();
        try {

            Statement stmt = con.createStatement();
            ResultSet rs;
            String query = String.format("SELECT * FROM nosql.nastavni_predmeti where NP_PREDMET like '%s';", id);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                //String VU_tip_ustanove, int VU_identifikator, String predmet, double verzija, String naziv_predmeta, boolean izborni
                predmet = new NastavniPredmeti(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getBoolean(6)
                );
            }
            con.close();

        } catch (Exception throwables) {
            System.out.println(throwables.toString());
            throwables.printStackTrace();
        } finally {
            return predmet;
        }
    }


    @Override
    public boolean updateEntity(NastavniPredmeti nastavniPredmeti) {

        try {
            String query = "update nosql.nastavni_predmeti set TIP_UST= ? ,VU_IDENTIFIKATOR= ? ,NP_PREDMET= ? , NP_VERZIJA= ?  ,NP_NAZIV_PREDMETA= ? ,NP_IZBORNA= ? where NP_PREDMET= ? ;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nastavniPredmeti.getVU_tip_ustanove());
            preparedStatement.setInt(2, nastavniPredmeti.getVU_identifikator());
            preparedStatement.setString(3, nastavniPredmeti.getPredmet());
            preparedStatement.setDouble(4, nastavniPredmeti.getVerzija());
            preparedStatement.setString(5, nastavniPredmeti.getNaziv_predmeta());
            preparedStatement.setBoolean(6, nastavniPredmeti.isIzborni());
            preparedStatement.setString(7, nastavniPredmeti.getPredmet());
            preparedStatement.executeUpdate();
            con.close();
            return true;
        } catch (Exception throwables) {
            System.out.println(throwables.toString());
            throwables.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean removeEntity(String id) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "DELETE FROM nosql.nastavni_predmeti WHERE NP_PREDMET= ? ;";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            con.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean insert(NastavniPredmeti predmeti) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "insert into nosql.nastavni_predmeti (TIP_UST, " +
                    "VU_IDENTIFIKATOR, " +
                    "NP_PREDMET, " +
                    "NP_VERZIJA, " +
                    "NP_NAZIV_PREDMETA, " +
                    "NP_IZBORNA) " +
                    "values(?, ?,?,?,?,?);";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, predmeti.getVU_tip_ustanove());
            preparedStatement.setInt(2, predmeti.getVU_identifikator());
            preparedStatement.setString(3, predmeti.getPredmet());
            preparedStatement.setDouble(4, predmeti.getVerzija());
            preparedStatement.setString(5, predmeti.getNaziv_predmeta());
            preparedStatement.setBoolean(6, predmeti.isIzborni());
            preparedStatement.execute();
            con.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public List<NastavniPredmeti> getAllByTipAndIdentificator(String tip, int identificator) {
        List<NastavniPredmeti> list = new ArrayList<>();
        try {
            PreparedStatement stmt;
            ResultSet rs;
            con=MySqlDriver.getDriver();
            stmt = con.prepareStatement("select * from nastavni_predmeti where TIP_UST = ? and VU_identifikator = ?");
            stmt.setString(1, tip);
            stmt.setInt(2, identificator);
            rs = stmt.executeQuery();
            while (rs.next()) {
                //String VU_tip_ustanove, int VU_identifikator, String predmet, double verzija, String naziv_predmeta, boolean izborni
                list.add(new NastavniPredmeti(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getBoolean(6)
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
}
