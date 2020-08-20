package com.example.demo.DAL;

import com.example.demo.interfaces.IDAL;
import com.example.demo.models.Neo4j.Person;
import com.google.gson.Gson;
import org.neo4j.driver.*;
import org.neo4j.driver.types.Node;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;


import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.Values.parameters;

public class Neo4j implements AutoCloseable{


    //CONSTRUCTORS
    public Neo4j(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    //PROPERTY
    private final Driver driver;

    //METHODS
    @Override
    public void close() throws Exception {
        driver.close();
    }

    public List<Person> printGreeting(final String query) {
        try (Session session = driver.session()) {
            List<Person> greeting = session.writeTransaction(new TransactionWork<List>() {
                @Override
                public List<Person> execute(Transaction tx) {
                    List<Person> list=new ArrayList<>();
                    Result result = tx.run(query);
                    while ( result.hasNext() ){
                        Record rec=result.next();
                        Person person=new Person();
                        if(!rec.get( 0 ).isNull())person.setName(rec.get(0).asString());
                        if(!rec.get(1).isNull())person.setTitle(rec.get(1).asString());
                        if(!rec.get(2).isNull())person.setId(rec.get(2).asInt());
                        list.add(person);
                    }
                   return list;
                }
            });
            return greeting;
        }
    }


}