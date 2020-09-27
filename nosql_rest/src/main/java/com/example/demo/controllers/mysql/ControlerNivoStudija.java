package com.example.demo.controllers.mysql;


import com.example.demo.factory.DalFactory;
import com.example.demo.interfaces.IDAL;
import com.example.demo.models.NivoStudija;
import com.example.demo.models.VisokoskolskaUstanova;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControlerNivoStudija {
    //METHODS
    @CrossOrigin
    @GetMapping(path = "/mysql/getAll/NivoStudija")
    public List<NivoStudija> returnAllEntities() {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.NIVO_STUDIJA);
        List<NivoStudija> list = new ArrayList<>();
        try {
            list = factory.getAll();
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
        } finally {
            return list;
        }
    }
    @CrossOrigin
    @PutMapping(path = "/mysql/insert/NivoStudija")
    public boolean insert(NivoStudija nivo) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.NIVO_STUDIJA);
        try {
            return factory.insert(nivo);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
    @CrossOrigin
    @GetMapping(path = "/mysql/getById/NivoStudija/{id}")
    public NivoStudija returnById(@PathVariable String id) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.NIVO_STUDIJA);
        try {
            return (NivoStudija)factory.getById(id);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return null;
        }
    }
    @CrossOrigin
    @GetMapping(path = "/mysql/remove/NivoStudija/{id}")
    public boolean remove(@PathVariable String id) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.NIVO_STUDIJA);
        try {
            return factory.removeEntity(id);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
}
