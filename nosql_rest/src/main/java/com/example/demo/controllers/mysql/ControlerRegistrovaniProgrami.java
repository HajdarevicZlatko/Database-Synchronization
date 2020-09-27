package com.example.demo.controllers.mysql;
import com.example.demo.factory.DalFactory;
import com.example.demo.interfaces.IDAL;
import com.example.demo.models.NastavniPredmeti;
import com.example.demo.models.RegistrovaniProgrami;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class ControlerRegistrovaniProgrami {
    //METHODS
    @CrossOrigin
    @GetMapping(path = "/mysql/getAll/RegistrovaniProgrami")
    public List<NastavniPredmeti> returnAllEntities() {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.REGISTROVANI_PROGRAMI);
        List<NastavniPredmeti> list = new ArrayList<>();
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
    @GetMapping(path = "/mysql/getById/RegistrovaniProgrami/{id}")
    public RegistrovaniProgrami returnById(@PathVariable String id) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.REGISTROVANI_PROGRAMI);
        try {
            return (RegistrovaniProgrami) factory.getById(id);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return null;
        }
    }
    @CrossOrigin
    @PutMapping(path = "/mysql/update/RegistrovaniProgrami")
    public boolean update(NastavniPredmeti predmet) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.REGISTROVANI_PROGRAMI);
        try {
            return factory.updateEntity(predmet);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
    @CrossOrigin
    @PutMapping(path = "/mysql/insert/RegistrovaniProgrami")
    public boolean insert(NastavniPredmeti predmet) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.REGISTROVANI_PROGRAMI);
        try {
            return factory.insert(predmet);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
    @CrossOrigin
    @GetMapping(path = "/mysql/remove/RegistrovaniProgrami/{id}")
    public boolean remove(@PathVariable String id) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.MYSQL, DalFactory.Entity.REGISTROVANI_PROGRAMI);
        try {
            return factory.removeEntity(id);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
}
