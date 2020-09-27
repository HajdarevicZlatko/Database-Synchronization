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
            NastavniPredmetiRepository nastavniPredmetiRepository=new NastavniPredmetiRepository();
            RegistrovaniProgramiRepository registrovaniProgramiRepository=new RegistrovaniProgramiRepository();
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

                        rs.getString(1),
                        rs.getInt(2),
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
                        registrovaniProgramiRepository.getByTipUST_and_VU_IDENTIFIKATOR(
                                rs.getString(1),
                                rs.getInt(2)
                        ),
                        nastavniPredmetiRepository.getAllByTipAndIdentificator(
                                rs.getString(1),
                                rs.getInt(2)
                        )
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

        VisokoskolskaUstanova predmet = new VisokoskolskaUstanova();
        try {
            NastavniPredmetiRepository nastavniPredmetiRepository=new NastavniPredmetiRepository();
            RegistrovaniProgramiRepository registrovaniProgramiRepository=new RegistrovaniProgramiRepository();
            Statement stmt = con.createStatement();
            ResultSet rs;
            String query = String.format("SELECT * FROM nosql.visokoskolska_ustanova where VU_IDENTIFIKATOR like '%s';", id);
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                //String VU_tip_ustanove, int VU_identifikator, String predmet, double verzija, String naziv_predmeta, boolean izborni
                predmet = new VisokoskolskaUstanova(

                        rs.getString(1),
                        rs.getInt(2),
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
                        registrovaniProgramiRepository.getByTipUST_and_VU_IDENTIFIKATOR(
                                rs.getString(1),
                                rs.getInt(2)
                        ),
                        nastavniPredmetiRepository.getAllByTipAndIdentificator(
                                rs.getString(1),
                                rs.getInt(2)
                        )
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
    public boolean updateEntity(VisokoskolskaUstanova visokoskolskaUstanova) {
        try {
        String query = "update nosql.visokoskolska_ustanova set " +
                "TIP_UST=?, " +
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
                "VU_MEMORANDUM=?" +
                "where VU_IDENTIFIKATOR= ? ;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement=setParameters(preparedStatement,visokoskolskaUstanova);
            preparedStatement.executeUpdate();
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeEntity(String id) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "DELETE FROM nosql.visokoskolska_ustanova WHERE VU_IDENTIFIKATOR= ? ;";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.execute();
            con.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insert(VisokoskolskaUstanova visokoskolskaUstanova) {
        PreparedStatement preparedStatement = null;
        try {
            String query = "insert into nosql.visokoskolska_ustanova (" +
                    "TIP_UST, " +
                    "VU_IDENTIFIKATOR, " +
                    "VU_NAZIV, " +
                    "DR_IDENTIFIKATOR, " +
                    "VU_OSNOVANA, " +
                    "NM_IDENTIFIKATOR, " +
                    "VU_ADRESA, " +
                    "VU_WEB_ADRESA, " +
                    "VU_E_MAIL, " +
                    "VV_OZNAKA, " +
                    "VU_PIB, " +
                    "VU_MATICNI_BROJ, " +
                    "VU_GRB, " +
                    "VU_MEMORANDUM" +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            preparedStatement = con.prepareStatement(query);
            preparedStatement=setParameters(preparedStatement,visokoskolskaUstanova);
            preparedStatement.execute();
            con.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    private PreparedStatement setParameters(PreparedStatement preparedStatement, VisokoskolskaUstanova vis) throws SQLException {
                /*
                "TIP_UST, " +
                "VU_IDENTIFIKATOR, " +
                "VU_NAZIV, " +
                "DR_IDENTIFIKATOR, " +
                "VU_OSNOVANA, " +
                "NM_IDENTIFIKATOR, " +
                "VU_ADRESA, " +
                "VU_WEB_ADRESA, " +
                "VU_E_MAIL, " +
                "VV_OZNAKA, " +
                "VU_PIB, " +
                "VU_MATICNI_BROJ, " +
                "VU_GRB, " +
                "VU_MEMORANDUM" +
                 */
        preparedStatement.setString(1, vis.getTIP_UST());
        preparedStatement.setInt(2, vis.getVU_IDENTIFIKATOR());
        preparedStatement.setString(3, vis.getVU_NAZIV());
        preparedStatement.setString(4, vis.getDR_IDENTIFIKATOR());
        preparedStatement.setDate(5, (Date) vis.getVU_OSNOVANA());
        preparedStatement.setInt(6, vis.getNM_IDENTIFIKATOR());
        preparedStatement.setString(7, vis.getVU_ADRESA());
        preparedStatement.setString(8, vis.getVU_WEB_ADRESA());
        preparedStatement.setString(9, vis.getVU_E_MAIL());
        preparedStatement.setString(10, vis.getVV_OZNAKA());
        preparedStatement.setString(11, vis.getVU_PIB());
        preparedStatement.setString(12, vis.getVU_MATICNI_BROJ());
        preparedStatement.setBytes(13, vis.getVU_GRB());
        preparedStatement.setBytes(14, vis.getVU_MEMORANDUM());
        return preparedStatement;
    }
}
