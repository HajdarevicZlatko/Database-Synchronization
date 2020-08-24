package com.example.demo.DAL.mysql;

import com.example.demo.interfaces.IDAL;
import com.example.demo.models.NastavniPredmeti;
import com.example.demo.models.NivoStudija;
import com.example.demo.models.StepenStudija;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
                //double nivo, String naziv,  String oznaka
                list.add(new NivoStudija(
                        rs.getString(1),
                        rs.getDouble(2),
                        rs.getString(3),
                        rs.getString(4)
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
    public List<NivoStudija> getAllBySTS_oznaka(String sts_oznaka) {
        List<NivoStudija> list = new ArrayList<>();
        try
        {
            PreparedStatement stmt;
            ResultSet rs;
            stmt = con.prepareStatement("select * from nivo_studija where STS_OZNAKA = ? ;");
            stmt.setString(1, sts_oznaka);
            rs = stmt.executeQuery();
            while (rs.next()) {
                //double nivo, String naziv,  String oznaka
                list.add(new NivoStudija(
                        rs.getString(1),
                        rs.getDouble(2),
                        rs.getString(3),
                        rs.getString(4)
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
        return null;
    }


    @Override
    public boolean updateEntity(NivoStudija nivoStudija) {
        return false;
    }

    @Override
    public boolean removeEntity(String id) {
        return false;
    }

    @Override
    public boolean insert(NivoStudija nivoStudija) {
        return false;
    }
}
