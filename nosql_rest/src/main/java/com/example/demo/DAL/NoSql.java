package com.example.demo.DAL;

import com.example.demo.DAL.mysql.VisokoskolskaUstanovaRepository;
import com.example.demo.models.VisokoskolskaUstanova;
import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Service;

@Service
public class NoSql {

    MongoClient client = client = MongoClients.create();
        public MongoCollection GetMongoCollection(){
            client.getDatabase("Test");
            MongoDatabase database=client.getDatabase("local");
            MongoCollection coll=database.getCollection("Test");
            return coll;
        }
        public boolean AddEntity(){
            VisokoskolskaUstanova r= new VisokoskolskaUstanovaRepository().getAll().get(0);
            Gson gson = new Gson();
            MongoCollection coll=GetMongoCollection();
            Document doc=Document.parse(gson.toJson(r));
            coll.insertOne(doc);
            return true;
        }

    }
