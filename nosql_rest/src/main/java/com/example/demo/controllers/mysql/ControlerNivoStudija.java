package com.example.demo.controllers.mysql;

import com.example.demo.DAL.mysql.NastavniPredmetiRepository;
import com.example.demo.factory.DalFactory;
import com.example.demo.interfaces.IDAL;
import com.example.demo.models.NastavniPredmeti;
import com.example.demo.models.NivoStudija;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
