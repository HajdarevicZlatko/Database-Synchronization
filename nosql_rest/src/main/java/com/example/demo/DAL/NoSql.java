package com.example.demo.DAL;

import com.example.demo.models.NoSql.PersonNosql;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import org.springframework.stereotype.Service;

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
        public List<PersonNosql> GetAllEntities() {
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
                    person.setAge(Integer.parseInt(document.get("age").toString()));
                    list.add(person);
                }
            }
            catch (Exception e){
                throw e;
            }

            return list;
        }
        public void AddEntity(PersonNosql entity) {
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
        public String RemoveEntity(PersonNosql entity) {
            return null;
        }
    }
