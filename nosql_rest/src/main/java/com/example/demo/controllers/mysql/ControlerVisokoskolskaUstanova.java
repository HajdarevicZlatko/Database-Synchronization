package com.example.demo.controllers.mysql;

import com.example.demo.DAL.NoSql;
import com.example.demo.factory.DalFactory;
import com.example.demo.interfaces.IDAL;
import com.example.demo.models.NastavniPredmeti;
import com.example.demo.models.VisokoskolskaUstanova;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControlerVisokoskolskaUstanova {
    //METHODS
    @CrossOrigin
    @GetMapping(path = "/mysql/getAll/VisokoskolskaUstanova")
    public List<VisokoskolskaUstanova> returnAllEntities() {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.VISOKOSKOLSKA_USTANOVA);
        List<VisokoskolskaUstanova> list = new ArrayList<>();
        try {
            new NoSql().AddEntity();
            list = factory.getAll();
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
        } finally {
            return list;
        }
    }
    @CrossOrigin
    @GetMapping(path = "/mysql/getById/VisokoskolskaUstanova/{id}")
    public VisokoskolskaUstanova returnById(@PathVariable String id) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.VISOKOSKOLSKA_USTANOVA);
        try {
            return (VisokoskolskaUstanova)factory.getById(id);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return null;
        }
    }
    @CrossOrigin
    @PutMapping(path = "/mysql/update/VisokoskolskaUstanova")
    public boolean update(VisokoskolskaUstanova predmet) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.VISOKOSKOLSKA_USTANOVA);
        try {
            return factory.updateEntity(predmet);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
    @CrossOrigin
    @PutMapping(path = "/mysql/insert/VisokoskolskaUstanova")
    public boolean insert(VisokoskolskaUstanova predmet) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.VISOKOSKOLSKA_USTANOVA);
        try {
            return factory.insert(predmet);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
    @CrossOrigin
    @GetMapping(path = "/mysql/remove/VisokoskolskaUstanova/{id}")
    public boolean remove(@PathVariable String id) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.VISOKOSKOLSKA_USTANOVA);
        try {
            return factory.removeEntity(id);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
}
