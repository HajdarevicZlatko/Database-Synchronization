package com.example.demo.DAL.mysql;

import com.example.demo.interfaces.IDAL;
import com.example.demo.models.NastavniPredmeti;
import com.example.demo.models.NivoStudija;
import com.example.demo.models.RegistrovaniProgrami;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrovaniProgramiRepository implements IDAL<RegistrovaniProgrami> {
    Connection con;

    public RegistrovaniProgramiRepository() {
        this.con = MySqlDriver.getDriver();
    }

    @Override
    public List<RegistrovaniProgrami> getAll() {
        List<RegistrovaniProgrami> list = new ArrayList<>();
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("select * from registrovani_programi");
            while (rs.next()) {
                /*
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
                 */
                list.add(new RegistrovaniProgrami(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3).toCharArray()[0],
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11),
                        rs.getDate(12),
                        new NivoStudijaRepository().getAllBySTS_oznakaAandNivo(rs.getString(7),rs.getDouble(8))
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
    public RegistrovaniProgrami getById(String id) {

        List<RegistrovaniProgrami> list=new ArrayList<>();
        try{
            PreparedStatement stmt;
            ResultSet rs;
            stmt = con.prepareStatement("select * from registrovani_programi where SP_EVIDENCIONI_BROJ = ?");
            stmt.setInt(1, Integer.parseInt(id) );
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new RegistrovaniProgrami(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3).toCharArray()[0],
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11),
                        rs.getDate(12),
                        new NivoStudijaRepository().getAllBySTS_oznakaAandNivo(rs.getString(7),rs.getDouble(8))
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
    public boolean updateEntity(RegistrovaniProgrami registrovaniProgrami) {

        try {
            String query = "update nosql.registrovani_programi set TIP_UST=?, VU_IDENTIFIKATOR=?, TIPP_TIP=?, SP_EVIDENCIONI_BROJ=?, SP_VERZIJA=?, SP_NAZIV=?, STS_OZNAKA=?, NS_NIVO=?, JEZ_JERIK2=?, SN_OZNAKA=?, SP_DATUM_FORMIRANJA=?, SP_DATUM_UKIDANJA=? where SP_EVIDENCIONI_BROJ= ? ;";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement=prepareStatement(preparedStatement,registrovaniProgrami);
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

        return false;
    }

    @Override
    public boolean insert(RegistrovaniProgrami registrovaniProgrami) {
        return false;
    }
    public List<RegistrovaniProgrami> getByTipUST_and_VU_IDENTIFIKATOR(String tip, int identifikator)
    {
        List<RegistrovaniProgrami> list = new ArrayList<>();
        try
        {
            PreparedStatement stmt;
            ResultSet rs;
            con=MySqlDriver.getDriver();
            stmt = con.prepareStatement("select * from registrovani_programi where TIP_UST = ? and VU_identifikator = ?");
            stmt.setString(1, tip);
            stmt.setInt(2, identifikator);
            rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new RegistrovaniProgrami(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getString(3).toCharArray()[0],
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDouble(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getDate(11),
                        rs.getDate(12),
                        new NivoStudijaRepository().getAllBySTS_oznakaAandNivo(rs.getString(7),rs.getDouble(8))
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
    private PreparedStatement prepareStatement( PreparedStatement prepared, RegistrovaniProgrami reg) throws SQLException {
        /*
        TIP_UST,
         VU_IDENTIFIKATOR,
         TIPP_TIP,
         SP_EVIDENCIONI_BROJ,
         SP_VERZIJA,
         SP_NAZIV,
         STS_OZNAKA,
         NS_NIVO,
         JEZ_JERIK2,
         SN_OZNAKA,
         SP_DATUM_FORMIRANJA,
         SP_DATUM_UKIDANJA
         */
        prepared.setString(1, reg.getTIP_UST());
        prepared.setDouble(2, reg.getVU_IDENTIFIKATOR());
        prepared.setString(3, String.valueOf(reg.getTIPP_TIP()));
        prepared.setInt(4, reg.getSP_EVIDENCIONI_BROJ());
        prepared.setDouble(5, reg.getSP_VERZIJA());
        prepared.setString(6, reg.getSP_NAZIV());
        prepared.setString(7, reg.getSP_NAZIV());
        prepared.setString(8, reg.getSTS_OZNAKA());
        prepared.setDouble(9, reg.getNS_NIVO());
        prepared.setString(10, reg.getJEZ_JERIK2());
        prepared.setString(11, reg.getSN_OZNAKA());
        prepared.setDate(12, (Date) reg.getSP_DATUM_FORMIRANJA());
        prepared.setDate(7, (Date) reg.getSP_DATUM_UKIDANJA());
        return prepared;
    }
}
