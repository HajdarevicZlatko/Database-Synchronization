package com.example.demo.DAL.mysql;

import com.example.demo.interfaces.IDAL;
import com.example.demo.models.StepenStudija;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StepenStudijaRepository implements IDAL<StepenStudija> {
    Connection con;
    public StepenStudijaRepository() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/nosql","root","");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<StepenStudija> getAll() {
        List<StepenStudija> list=new ArrayList<>();
        try {
            Statement stmt=con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from stepen_studija");
            while(rs.next()){

                //STS_OZNAKA, STS_NAZIV
                list.add(new StepenStudija(
                        rs.getString(1),
                        rs.getString(2),
                        new NivoStudijaRepository().getAllBySTS_oznaka(rs.getString(1))
                ));
            }
            con.close();
        } catch (Exception throwables) {
            System.out.println(throwables.toString());
            throwables.printStackTrace();
        }
        finally {
            return list;
        }
    }

    @Override
    public StepenStudija getById(String id) {
        StepenStudija entity=new StepenStudija();
        try
        {
            Statement stmt=con.createStatement();
            ResultSet rs;
            String query=String.format("SELECT * FROM nosql.stepen_studija where STS_OZNAKA like '%s';",id);
            rs = stmt.executeQuery(query);
            while(rs.next())
            {
                //String VU_tip_ustanove, int VU_identifikator, String predmet, double verzija, String naziv_predmeta, boolean izborni
                entity= new StepenStudija(
                        rs.getString(1),
                        rs.getString(2),
                        null
                );
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
            return entity;
        }
    }

    @Override
    public boolean updateEntity(StepenStudija stepenStudija)
    {
        try {
            String query="update nosql.stepen_studija set STS_NAZIV= ? where STS_OZNAKA= ? ;";
            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setString(1,stepenStudija.getNaziv());
            preparedStatement.setString(2,stepenStudija.getSTS_oznaka());
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
            String query="DELETE FROM nosql.stepen_studija WHERE STS_OZNAKA= ? ;";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,id);
            preparedStatement.execute();
            con.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insert(StepenStudija stepenStudija) {
        PreparedStatement preparedStatement= null;
        try {
            String query="insert into nosql.stepen_studija (STS_OZNAKA, STS_NAZIV) " +
                    "values(?, ?);";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,stepenStudija.getSTS_oznaka());
            preparedStatement.setString(2,stepenStudija.getNaziv());
            preparedStatement.execute();
            con.close();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }



}
