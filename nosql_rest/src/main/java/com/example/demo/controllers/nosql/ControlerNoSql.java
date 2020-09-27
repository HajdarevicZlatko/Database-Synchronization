package com.example.demo.controllers.nosql;

import com.example.demo.DAL.nosql.NosqlRepository;
import com.example.demo.factory.DalFactory;
import com.example.demo.interfaces.IDAL;
import com.example.demo.models.Agg;
import com.example.demo.models.Student;
import com.mongodb.client.MongoClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControlerNoSql {
    MongoClient client;
    @CrossOrigin
    @GetMapping(path = "/nosql/getAll/")
    public List<Student> getAll() {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.NOSQL, DalFactory.Entity.REGISTROVANI_PROGRAMI);
        try {
            return factory.getAll();
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return new ArrayList<>();
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/nosql/insert/{ime}/{prezime}/{adresa}/{drzava}/{grad}/{program}/{fakultet}/{studije}/{zip}", method = RequestMethod.POST)
    public boolean insertStudent(@PathVariable String ime, @PathVariable String prezime, @PathVariable String adresa, @PathVariable String drzava, @PathVariable String grad, @PathVariable String program, @PathVariable String fakultet, @PathVariable String studije, @PathVariable String zip) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.NOSQL, DalFactory.Entity.STUDENT);
        try {
            Student o = new Student(ime, prezime, adresa, grad, drzava, zip, studije, program, fakultet);
            return factory.insert(o);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/nosql/update/{indeks}/{ime}/{prezime}/{adresa}/{drzava}/{grad}/{program}/{fakultet}/{studije}/{zip}", method = RequestMethod.POST)
    public boolean updateStudent(@PathVariable String indeks, @PathVariable String ime, @PathVariable String prezime, @PathVariable String adresa, @PathVariable String drzava, @PathVariable String grad, @PathVariable String program, @PathVariable String fakultet, @PathVariable String studije, @PathVariable String zip) {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.NOSQL, DalFactory.Entity.STUDENT);
        try {
            Student o = new Student(ime, prezime, adresa, grad, drzava, zip, studije, program, fakultet);
            o.setIndeks(indeks);
            return factory.updateEntity(o);
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
    @CrossOrigin
    @RequestMapping(value = "/nosql/diplomirao/{indeks}", method = RequestMethod.POST)
    public boolean diplomirao(@PathVariable String indeks) {
        return new NosqlRepository().diplomirao(indeks);
    }
    @CrossOrigin
    @RequestMapping(value = "/agg", method = RequestMethod.GET)
    public List<Agg> agg() {
        try {
            NosqlRepository t=new NosqlRepository();
            return t.agg();
        }catch (Exception r){
            System.out.println("sdfsdf");
            return new ArrayList<>();
        }
    }

}
