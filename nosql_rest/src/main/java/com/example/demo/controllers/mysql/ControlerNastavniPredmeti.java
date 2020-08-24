package com.example.demo.controllers.mysql;

import com.example.demo.DAL.mysql.NastavniPredmetiRepository;
import com.example.demo.factory.DalFactory;
import com.example.demo.interfaces.IDAL;
import com.example.demo.models.NastavniPredmeti;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControlerNastavniPredmeti {
    //METHODS
    @CrossOrigin
    @GetMapping(path = "/mysql/getAll/NastavniPredmeti")
    public List<NastavniPredmeti> returnAllEntities() {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.NASTAVNI_PREDMETI);
        List<NastavniPredmeti> list = new ArrayList<>();
        try {
            NastavniPredmetiRepository r=new NastavniPredmetiRepository();
            list=r.getAllByTipAndIdentificator("FK",1);
            list = factory.getAll();
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
        } finally {
            return list;
        }
    }
    @CrossOrigin
    @GetMapping(path = "/mysql/getById/NastavniPredmeti/{id}")
    public NastavniPredmeti returnById(@PathVariable String id) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.NASTAVNI_PREDMETI);
        try {
            return (NastavniPredmeti)factory.getById(id);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return null;
        }
    }
    @CrossOrigin
    @PutMapping(path = "/mysql/update/NastavniPredmeti")
    public boolean update(NastavniPredmeti predmet) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.NASTAVNI_PREDMETI);
        try {
            return factory.updateEntity(predmet);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
    @CrossOrigin
    @PutMapping(path = "/mysql/insert/NastavniPredmeti")
    public boolean insert(NastavniPredmeti predmet) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.NASTAVNI_PREDMETI);
        try {
            return factory.insert(predmet);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
    @CrossOrigin
    @GetMapping(path = "/mysql/remove/NastavniPredmeti/{id}")
    public boolean remove(@PathVariable String id) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.NASTAVNI_PREDMETI);
        try {
            return factory.removeEntity(id);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
}
