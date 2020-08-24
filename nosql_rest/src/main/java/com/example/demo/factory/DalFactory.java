package com.example.demo.factory;

import com.example.demo.DAL.mysql.*;
import com.example.demo.DAL.neo4j.PersonRepository;
import com.example.demo.interfaces.IDAL;

public class DalFactory {
    public enum DB
    {
        MYSQL,
        NOSQL,
        GRAPHDB
    }
    public enum Entity
    {
        Person,
        NASTAVNI_PREDMETI,
        NIVO_STUDIJA,
        REGISTROVANI_PROGRAMI,
        STEPEN_STUDIJA,
        VISOKOSKOLSKA_USTANOVA
    }
public static IDAL getRepository(DB database, Entity entity){
    switch (database){
        case MYSQL: switch (entity){
            case NASTAVNI_PREDMETI: return new NastavniPredmetiRepository();
            case STEPEN_STUDIJA: return new StepenStudijaRepository();
            case NIVO_STUDIJA: return new NivoStudijaRepository();
            case VISOKOSKOLSKA_USTANOVA: return new VisokoskolskaUstanovaRepository();
            case REGISTROVANI_PROGRAMI: return new RegistrovaniProgramiRepository();
        };
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
