package com.example.demo.DAL.nosql;

import com.example.demo.interfaces.IDAL;
import com.example.demo.models.Agg;
import com.example.demo.models.Student;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.sort;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

public class NosqlRepository implements IDAL <Student>{
    MongoClient client;
    //CONSTRUCTORS
    public NosqlRepository() {
        this.client= MongoClients.create();
    }

    private MongoCollection GetMongoCollection(){
        MongoDatabase database=client.getDatabase("local");
        MongoCollection coll=database.getCollection("NOSQL");
        return coll;
    }

    @Override
    public List<Student> getAll() throws ParseException {
        List<Student> list=new ArrayList<>();
        try{
            MongoCollection coll=GetMongoCollection();

            BasicDBObject neQuery = new BasicDBObject();
            neQuery.put("diplomirao", new BasicDBObject("$ne", true));
            FindIterable findIterable=coll.find(neQuery);
            Iterator<Document> iterator=findIterable.iterator();
            while(iterator.hasNext()){
                Document document=iterator.next();
                Gson g=new Gson();
                Student p = g.fromJson(document.toJson(), Student.class);
                p.setIndeks(document.getObjectId("_id").toString());
                list.add(p);
            }
        }
        catch (Exception e){
            throw e;
        }
        return list;
    }

    @Override
    public Student getById(String id) {
        return null;
    }

    @Override
    public boolean updateEntity(Student o) {
        /*
        db.NOSQL.update({_id:ObjectId("5f4eadb71e868e464a1c5915")},
        {
    "name":"TestUpdate"
        })
        {
    "_id" : ObjectId("5f4eae141e868e464a1c5917"),
    "ime" : "Zlatko",
    "prezime" : "Hajdarevic",
    "adresa" : "Bul kralja",
    "grad" : "Beograd",
    "drzava" : "Srbija",
    "zip" : "11000",
    "studije" : "OSNOVNE STUDIJE OS",
    "program" : "SOFTVERSKO INZENJERSTVO",
    "fakultet" : "OSNOVNE STUDIJE OS"
}
         */
        try {
            MongoCollection coll = GetMongoCollection();
            Bson filter = eq("_id",new ObjectId(o.getIndeks()));
            Bson updateOperation = set("ime", o.getIme());
            Bson updateOperation8 = set("prezime", o.getPrezime());
            Bson updateOperation1 = set("adresa", o.getAdresa());
            Bson updateOperation2 = set("grad", o.getGrad());
            Bson updateOperation3 = set("drzava", o.getDrzava());
            Bson updateOperation4 = set("zip", o.getZip());
            Bson updateOperation5 = set("studije", o.getStudije());
            Bson updateOperation6 = set("program", o.getProgram());
            Bson updateOperation7 = set("fakultet", o.getFakultet());
            Bson updates = combine(updateOperation, updateOperation1, updateOperation2, updateOperation3, updateOperation4, updateOperation5, updateOperation6, updateOperation7,updateOperation8);
            UpdateResult updateResult = coll.updateOne(filter, updates);
            System.out.println(updateResult);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean removeEntity(String id) {
        return false;
    }

    @Override
    public boolean insert(Student o) {
        Gson gson = new Gson();
        MongoCollection coll=GetMongoCollection();
        Document doc=Document.parse(gson.toJson(o));
        coll.insertOne(doc);
        return true;
    }
    public boolean diplomirao(String indeks) {
        try {
            MongoCollection coll = GetMongoCollection();
            Bson filter = eq("_id", new ObjectId(indeks));
            Bson updateOperation = set("diplomirao", true);
            UpdateResult updateResult = coll.updateOne(filter, updateOperation);
            System.out.println(updateResult);
            return true;
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
    public List<Agg> agg() {
        try {
            List<Agg> agg = new ArrayList<>();
            MongoCollection coll=GetMongoCollection();
            AggregateIterable<Document> iterable = coll.aggregate(Arrays.asList(
                    group("$fakultet", Accumulators.sum("suma", 1)),
                    sort(Sorts.descending("fakultet"))));
            for (Document doc : iterable) {
                Agg o = new Agg(doc.getString("_id"), doc.getInteger("suma"));
                agg.add(o);
            }
            client.close();
            return agg;
        }
        catch (Exception r){
            System.out.println("sdfdf");
            return null;
        }
    }

}
