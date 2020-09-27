package com.example.demo.controllers.graphdb;

import com.example.demo.factory.DalFactory;
import com.example.demo.interfaces.IDAL;
import com.example.demo.models.RegistrovaniProgrami;
import com.example.demo.models.StepenStudija;
import com.example.demo.models.VisokoskolskaUstanova;
import org.neo4j.driver.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NeoControler {

    @CrossOrigin
    @GetMapping(path = "/graph/getStudije/")
    public List<StepenStudija> getStepenStudija() {
         final Driver driver;
         final String uri = "bolt://localhost:7687";
         final String user = "neo4j";
         final String password = "Dzakarta1";
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
        try (Session session = driver.session()) {
            List<StepenStudija> greeting = session.writeTransaction(new TransactionWork<List>() {
                @Override
                public List<StepenStudija> execute(Transaction tx) {
                    List<StepenStudija> list = new ArrayList<>();
                    Result result = tx.run("match(n:STEPEN_STUDIJA) return DISTINCT n.STS_NAZIV");
                    while (result.hasNext()) {
                        Record rec = result.next();
                        list.add(new StepenStudija(null,rec.get(0).asString()));
                    }
                    return list;
                }
            });
            return greeting;
        }
        catch (Exception e){
            return new ArrayList<StepenStudija>();
        }
    }
    @CrossOrigin
    @GetMapping(path = "/graph/getRegistrovaniProgrami/{tip}")
    public List<RegistrovaniProgrami> getStepenStudija(@PathVariable String tip) {
        final Driver driver;
        final String uri = "bolt://localhost:7687";
        final String user = "neo4j";
        final String password = "Dzakarta1";
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
        List<RegistrovaniProgrami> list1=new ArrayList<>();
        try (Session session = driver.session()) {
            list1=session.writeTransaction(new TransactionWork<List>() {
                @Override
                public List<RegistrovaniProgrami> execute(Transaction tx) {
                    List<RegistrovaniProgrami> list=new ArrayList<>();
                    Result result = tx.run("match(e:REGISTROVANI_PROGRAM)<-[t:NIVO_STUDIJA_REL]-(k:NIVO_STUDIJA)<-[y:STEPEN_STUDIJA_REL]-(r:STEPEN_STUDIJA{STS_NAZIV:'"+tip+"'}) return DISTINCT e.SP_NAZIV");
                    while (result.hasNext()) {
                        Record rec = result.next();
                        RegistrovaniProgrami h=new RegistrovaniProgrami();
                        h.setSP_NAZIV(rec.get(0).asString());
                       list.add(h);
                    }
                    return list;
                }
            });
            return  list1;
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }
    @CrossOrigin
    @GetMapping(path = "/graph/insert/")
    public boolean insert() {
        IDAL factory = DalFactory.getRepository(DalFactory.DB.GRAPHDB, DalFactory.Entity.VISOKOSKOLSKA_USTANOVA);
        try {
            return factory.insert(new VisokoskolskaUstanova());
        } catch (Exception e) {
            System.out.println("Izuzetak");
            System.out.println(e.toString());
            return false;
        }
    }
    @CrossOrigin
    @GetMapping(path = "/graph/getObrazovnaUstanova/{tip}/{prog}")
    //match(faks:VISOKOSKOLSKA_USTANOVA)<-[]-(e:REGISTROVANI_PROGRAM{SP_NAZIV:"SOFTVERSKO INZENJERSTVO"})<-[t:NIVO_STUDIJA_REL]-(k:NIVO_STUDIJA)<-[y:STEPEN_STUDIJA_REL]-(r:STEPEN_STUDIJA{STS_NAZIV:'OSNOVNE STUDIJE OS'}) return DISTINCT faks.VU_NAZIV
    public List<VisokoskolskaUstanova> getStepenStudija(@PathVariable String tip, @PathVariable String prog) {
        final Driver driver;
        final String uri = "bolt://localhost:7687";
        final String user = "neo4j";
        final String password = "Dzakarta1";
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
        List<VisokoskolskaUstanova> list1=new ArrayList<>();
        try (Session session = driver.session()) {
            session.writeTransaction(new TransactionWork<List>() {
                @Override
                public List<VisokoskolskaUstanova> execute(Transaction tx) {
                    List<VisokoskolskaUstanova> list=new ArrayList<>();
                    Result result = tx.run("match(faks:VISOKOSKOLSKA_USTANOVA)<-[]-(e:REGISTROVANI_PROGRAM{SP_NAZIV:'"+prog+"'})<-[]-(k:NIVO_STUDIJA)<-[]-(r:STEPEN_STUDIJA{STS_NAZIV:'"+tip+"'}) return DISTINCT faks.VU_NAZIV");
                    while (result.hasNext()) {
                        Record rec = result.next();
                        VisokoskolskaUstanova h=new VisokoskolskaUstanova();
                        h.setVU_NAZIV(rec.get(0).asString());
                        list1.add(h);
                    }
                    return list;
                }
            });
            return  list1;
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }
}
