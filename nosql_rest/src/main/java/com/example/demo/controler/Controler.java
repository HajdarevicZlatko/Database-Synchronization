package com.example.demo.controler;
import com.example.demo.DAL.NoSql;
import com.example.demo.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class Controler {
    @CrossOrigin
    @GetMapping(path = "/GetAll")
    public List<Person> returnAllEntities(){
        List<Person> list=new ArrayList<>();
        try{
            NoSql nosql=new NoSql();
            list= nosql.GetAllEntities();
        }catch (Exception e){
            System.out.println("Izuzetak");
            System.out.println(e.toString());
        }
        finally {
            return list;
        }
    }
    @CrossOrigin
    @PutMapping(path="/insert_nosql/{name}/{surname}/{age}")
    public String add(@PathVariable String name,@PathVariable String surname,@PathVariable String age){
            try{
                NoSql noSql=new NoSql();
                Person person=new Person();
                person.setAge(age);
                person.setName(name);
                person.setSurname(surname);
                noSql.AddEntity(person);
                return "success";
            }catch (Exception e){
                return e.getMessage();
            }
    }

}
