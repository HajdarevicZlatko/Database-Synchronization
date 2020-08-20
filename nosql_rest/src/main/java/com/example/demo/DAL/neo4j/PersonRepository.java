package com.example.demo.DAL.neo4j;

import com.example.demo.interfaces.IDAL;
import com.example.demo.models.Neo4j.Person;
import org.neo4j.driver.*;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository implements IDAL<Person>,AutoCloseable{

    //CONSTRUCTORS
    public PersonRepository() {
        driver = GraphDatabase.driver(this.uri, AuthTokens.basic(this.user, this.password));
    }

    //PROPERTIES
    private final Driver driver;
    private final String  uri="bolt://localhost:7687";
    private final String  user="neo4j";
    private final String  password="Dzakarta1";

    //METHODS
    @Override
    public List<Person> getAll() {
        try (Session session = driver.session()) {
            List<Person> greeting = session.writeTransaction(new TransactionWork<List>() {
                @Override
                public List<Person> execute(Transaction tx) {
                    List<Person> list=new ArrayList<>();
                    Result result = tx.run("match(n:Person) return n.name, n.title, n.id");
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

    @Override
    public Person getById(String id) {
        return null;
    }

    @Override
    public Person getByName(String name) {
        return null;
    }

    @Override
    public boolean updateEntity(Person person) {
        return false;
    }

    @Override
    public boolean removeEntity(Person person) {
        return false;
    }

    @Override
    public void close() throws Exception {
        driver.close();
    }
}
