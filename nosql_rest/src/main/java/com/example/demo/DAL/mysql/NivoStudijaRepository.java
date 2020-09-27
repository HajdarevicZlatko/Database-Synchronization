package com.example.demo.DAL.mysql;

import com.example.demo.interfaces.IDAL;
import com.example.demo.models.NastavniPredmeti;
import com.example.demo.models.NivoStudija;
import com.example.demo.models.RegistrovaniProgrami;
import com.example.demo.models.StepenStudija;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NivoStudijaRepository implements IDAL<NivoStudija> {
    Connection con;
    public NivoStudijaRepository() {
        con=MySqlDriver.getDriver();
    }

    @Override
    public List<NivoStudija> getAll() {
        List<NivoStudija> list = new ArrayList<>();
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from nivo_studija");
            while (rs.next()) {
                list.add(new NivoStudija(
                        rs.getString(1),
                        rs.getDouble(2),
                        rs.getString(3),
                        rs.getString(4),
                        new StepenStudijaRepository().getStepenStudijaBySTS_OZNAKA(rs.getString(1))
                ));
            }
            con.close();
        }
        catch (Exception throwables)
        {
            System.out.println(throwables.toString());
            throwables.printStackTrace();
        }
        finally
        {
            return list;
        }
    }
    public List<NivoStudija> getAllBySTS_oznakaAndNivo(String sts_oznaka,int nivo) {
        List<NivoStudija> list = new ArrayList<>();
        try
        {
            PreparedStatement stmt;
            ResultSet rs;
            stmt = con.prepareStatement("select * from nivo_studija where STS_OZNAKA = ? and ns_nivo=?;");
            stmt.setString(1, sts_oznaka);
            stmt.setInt(2, nivo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                //double nivo, String naziv, String oznaka
                list.add(new NivoStudija(
                        rs.getString(1),
                        rs.getDouble(2),
                        rs.getString(3),
                        rs.getString(4),
                        new StepenStudijaRepository().getStepenStudijaBySTS_OZNAKA(rs.getString(1))
                ));
            }
            con.close();
        }
        catch (Exception throwables)
        {
            System.out.println(throwables.toString());
            throwables.printStackTrace();
        }
        finally
        {
            return list;
        }
    }
    public List<NivoStudija> getAllBySTS_oznakaAandNivo(String sts_oznaka, double nivo) {
        List<NivoStudija> list = new ArrayList<>();
        try
        {
            con=MySqlDriver.getDriver();
            PreparedStatement stmt;
            ResultSet rs;
            stmt = con.prepareStatement("select * from nivo_studija where STS_OZNAKA = ? and NS_NIVO=?;");
            stmt.setString(1, sts_oznaka);
            stmt.setDouble(2, nivo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                //double nivo, String naziv, String oznaka
                list.add(new NivoStudija(
                        rs.getString(1),
                        rs.getDouble(2),
                        rs.getString(3),
                        rs.getString(4),
                        new StepenStudijaRepository().getStepenStudijaBySTS_OZNAKA(rs.getString(1))
                ));
            }
            con.close();
        }
        catch (Exception throwables)
        {
            System.out.println(throwables.toString());
            throwables.printStackTrace();
        }
        finally
        {
            return list;
        }
    }
    @Override
    public NivoStudija getById(String id) {
        List<NivoStudija> list=new ArrayList<>();
        try{
        PreparedStatement stmt;
        ResultSet rs;
        stmt = con.prepareStatement("select * from nivo_studija where NS_NIVO = ?");
        stmt.setDouble(1, Double.parseDouble(id));
        rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new NivoStudija(
                        rs.getString(1),
                        rs.getDouble(2),
                        rs.getString(3),
                        rs.getString(4),
                        new StepenStudijaRepository().getStepenStudijaBySTS_OZNAKA(rs.getString(1))
                ));
            }
        con.close();
    }
        catch (Exception throwables)
    {
        System.out.println(throwables.toString());
        throwables.printStackTrace();
    }
        finally
    {
        return list.get(0);
    }
    }


    @Override
    public boolean updateEntity(NivoStudija nivoStudija) {

        try {
            String query = "update nosql.nivo_studija set TIP_UST= ? ,VU_IDENTIFIKATOR= ? ,NP_PREDMET= ? , NP_VERZIJA= ?  ,NP_NAZIV_PREDMETA= ? ,NP_IZBORNA= ? where NP_PREDMET= ? ;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement=prepareStatement(preparedStatement,nivoStudija);
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
        PreparedStatement preparedStatement= null;
        try {
            String query="DELETE FROM nosql.nivo_studija WHERE NS_NIVO= ? ;";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setDouble(1,Double.parseDouble(id));
            preparedStatement.execute();
            con.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insert(NivoStudija nivoStudija) {

        PreparedStatement preparedStatement = null;
        try {
            String query = "insert into nosql.nivo_studija (" +
                    "STS_OZNAKA, NS_NIVO, NA_NAZIV, SN_OZNAKA)" +
                    "values(?,?,?,?);";
            preparedStatement = con.prepareStatement(query);
            preparedStatement=prepareStatement(preparedStatement,nivoStudija);
            preparedStatement.execute();
            con.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    private PreparedStatement prepareStatement( PreparedStatement prepared, NivoStudija nivoStudija) throws SQLException {
        prepared.setString(1, nivoStudija.getSts_oznaka());
        prepared.setDouble(2, nivoStudija.getNivo());
        prepared.setString(3, nivoStudija.getNaziv());
        prepared.setString(4, nivoStudija.getOznaka());
        return prepared;
    }
}
