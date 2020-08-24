package com.example.demo.controllers.mysql;

import com.example.demo.factory.DalFactory;
import com.example.demo.interfaces.IDAL;
import com.example.demo.models.StepenStudija;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControlerStepenStudija {
    //METHODS
    @CrossOrigin
    @GetMapping(path = "/mysql/getAll/StepenStudija")
    public List<StepenStudija> returnAllEntities() {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.STEPEN_STUDIJA);
        List<StepenStudija> list = new ArrayList<>();
        try
        {
            list = factory.getAll();
        }
        catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
        }
        finally
        {
            return list;
        }
    }
    @CrossOrigin
    @GetMapping(path = "/mysql/getById/StepenStudija/{id}")
    public StepenStudija returnById(@PathVariable String id) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.STEPEN_STUDIJA);
        try
        {
            return (StepenStudija)factory.getById(id);
        }
        catch (Exception e)
        {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return null;
        }
    }
    @CrossOrigin
    @PutMapping(path = "/mysql/update/StepenStudija")
    public boolean update(StepenStudija entity) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.STEPEN_STUDIJA);
        try
        {
            return factory.updateEntity(entity);
        }
        catch (Exception e)
        {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
    @CrossOrigin
    @PutMapping(path = "/mysql/insert/StepenStudija")
    public boolean insert(StepenStudija predmet) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.STEPEN_STUDIJA);
        try
        {
            return factory.insert(predmet);
        }
        catch (Exception e)
        {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
    @CrossOrigin
    @GetMapping(path = "/mysql/remove/StepenStudija/{id}")
    public boolean remove(@PathVariable String id) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.STEPEN_STUDIJA);
        try
        {
            return factory.removeEntity(id);
        }
        catch (Exception e)
        {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
}
