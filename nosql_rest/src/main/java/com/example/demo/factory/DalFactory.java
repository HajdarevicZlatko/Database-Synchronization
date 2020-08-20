package com.example.demo.factory;

import com.example.demo.DAL.neo4j.PersonRepository;
import com.example.demo.interfaces.IDAL;

public class DalFactory {
    public enum DB{
        MYSQL,
        NOSQL,
        GRAPHDB
    }
    public enum Entity{
        Person
    }
public static IDAL getRepository(DB database, Entity entity){
    switch (database){
        case MYSQL: return null;
        case NOSQL: switch (entity){
            case Person: return new com.example.demo.DAL.nosql.PersonRepository();
        }
        case GRAPHDB:
            switch (entity) {
                case Person: return new PersonRepository();
            }
        default:return null;
    }
}

}
