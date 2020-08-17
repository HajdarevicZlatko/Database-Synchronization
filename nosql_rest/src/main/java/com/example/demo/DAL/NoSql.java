package com.example.demo.DAL;

import com.example.demo.model.Person;
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import com.mongodb.util.JSON;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class NoSql {

    MongoClient client = client = MongoClients.create();

        public MongoCollection GetMongoCollection(){
            client.getDatabase("Test");
            MongoDatabase database=client.getDatabase("local");
            MongoCollection coll=database.getCollection("Test");
            return coll;
        }
        public List<Person> GetAllEntities() {
            List<Person> list=new ArrayList<>();
            try{
                MongoCollection coll=GetMongoCollection();
                FindIterable findIterable=coll.find();
                Iterator<Document> iterator=findIterable.iterator();
                while(iterator.hasNext()){
                    Person person=new Person();
                    Document document=iterator.next();
                    person.setId(document.get("_id").toString());
                    person.setName(document.get("name").toString());
                    person.setSurname(document.get("surname").toString());
                    person.setAge(document.get("age").toString());
                    list.add(person);
                }
            }
            catch (Exception e){
                throw e;
            }

            return list;
        }
        public void AddEntity(Person entity) {
            try{
                MongoCollection coll=GetMongoCollection();
                Document doc = new Document("name", entity.getName())
                        .append("surname",entity.getSurname())
                        .append("age", entity.getAge());
                coll.insertOne(doc);
            } catch (Exception e){
               throw e;
            }


        }
        public String RemoveEntity(Person entity) {
            return null;
        }
    }
