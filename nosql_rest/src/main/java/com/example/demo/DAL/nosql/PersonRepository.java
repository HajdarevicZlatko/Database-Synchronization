package com.example.demo.DAL.nosql;

import com.example.demo.interfaces.IDAL;
import com.example.demo.models.NoSql.PersonNosql;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonRepository implements IDAL<PersonNosql> {
    //PROPERTIES
    MongoClient client;

    //CONSTRUCTORS
    public PersonRepository() {
        this.client=MongoClients.create();
    }

    //METHODS
    private MongoCollection GetMongoCollection(){
        client.getDatabase("Test");
        MongoDatabase database=client.getDatabase("local");
        MongoCollection coll=database.getCollection("Test");
        return coll;
    }

    @Override
    public List<PersonNosql> getAll() {
        List<PersonNosql> list=new ArrayList<>();
        try{
            MongoCollection coll=GetMongoCollection();
            FindIterable findIterable=coll.find();
            Iterator<Document> iterator=findIterable.iterator();
            while(iterator.hasNext()){
                PersonNosql person=new PersonNosql();
                Document document=iterator.next();
                person.setId(document.get("_id").toString());
                person.setName(document.get("name").toString());
                person.setSurname(document.get("surname").toString());
                person.setAge((int)document.get("age"));
                list.add(person);
            }
        }
        catch (Exception e){
            throw e;
        }

        return list;
    }

    @Override
    public PersonNosql getById(String id) {
        return null;
    }


    @Override
    public boolean updateEntity(PersonNosql personNosql) {
        return false;
    }

    @Override
    public boolean removeEntity(String id) {
        return false;
    }

    @Override
    public boolean insert(PersonNosql personNosql) {
        return false;
    }
}
