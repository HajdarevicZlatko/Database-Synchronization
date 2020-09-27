package com.example.demo.controllers;

import com.example.demo.factory.DalFactory;
import com.example.demo.interfaces.IDAL;
import com.example.demo.models.VisokoskolskaUstanova;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controler {

    //METHODS
    @CrossOrigin
    @PutMapping(path = "/insert_nosql/")
    public String add() {
        try {
            IDAL factory = DalFactory.getRepository(DalFactory.DB.NOSQL, DalFactory.Entity.VISOKOSKOLSKA_USTANOVA);
            factory.insert(new VisokoskolskaUstanova());
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
