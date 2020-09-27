package com.example.demo.factory;

import com.example.demo.DAL.mysql.*;
import com.example.demo.DAL.neo4j.GraphRepository;
import com.example.demo.DAL.nosql.NosqlRepository;
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
        NASTAVNI_PREDMETI,
        NIVO_STUDIJA,
        REGISTROVANI_PROGRAMI,
        STEPEN_STUDIJA,
        VISOKOSKOLSKA_USTANOVA,
        STUDENT
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
        case NOSQL:
            return new NosqlRepository();
        case GRAPHDB:
            return new GraphRepository();
        default:return null;
    }
}

}
