package com.example.demo.controllers;

import com.example.demo.DAL.Neo4j;
import com.example.demo.DAL.NoSql;
import com.example.demo.factory.DalFactory;
import com.example.demo.interfaces.IDAL;
import com.example.demo.models.Neo4j.Person;
import com.example.demo.models.NoSql.PersonNosql;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controler {

    //METHODS
    @CrossOrigin
    @GetMapping(path = "/nosql/getAll")
    public List<PersonNosql> returnAllEntities() {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.NOSQL, DalFactory.Entity.Person);
        List<PersonNosql> list = new ArrayList<>();
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
    @PutMapping(path = "/insert_nosql/{name}/{surname}/{age}")
    public String add(@PathVariable String name, @PathVariable String surname, @PathVariable int age) {
        try {
            NoSql noSql = new NoSql();
            PersonNosql person = new PersonNosql();
            person.setAge(age);
            person.setName(name);
            person.setSurname(surname);
            noSql.AddEntity(person);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/neo/getAll")
    public List<Person> neo() {
        List<Person> list = new ArrayList<>();
        try {
            IDAL factory = DalFactory.getRepository(DalFactory.DB.GRAPHDB, DalFactory.Entity.Person);
            list = factory.getAll();
        } catch (Exception e) {
            System.out.println("Izuzetak" + e.toString());
        } finally {
            return list;
        }
    }

}
