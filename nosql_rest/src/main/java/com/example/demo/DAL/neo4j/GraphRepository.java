package com.example.demo.DAL.neo4j;

import com.example.demo.DAL.mysql.NivoStudijaRepository;
import com.example.demo.DAL.mysql.RegistrovaniProgramiRepository;
import com.example.demo.DAL.mysql.VisokoskolskaUstanovaRepository;
import com.example.demo.interfaces.IDAL;
import com.example.demo.models.*;

import org.neo4j.driver.*;

import java.util.ArrayList;
import java.util.List;

public class GraphRepository implements IDAL<VisokoskolskaUstanova>, AutoCloseable {

    //CONSTRUCTORS
    public GraphRepository() {
        driver = GraphDatabase.driver(this.uri, AuthTokens.basic(this.user, this.password));
    }

    //PROPERTIES
    private final Driver driver;
    private final String uri = "bolt://localhost:7687";
    private final String user = "neo4j";
    private final String password = "Dzakarta1";

    //METHODS
    @Override
    public List<VisokoskolskaUstanova> getAll() {
        try (Session session = driver.session()) {
            List<VisokoskolskaUstanova> greeting = session.writeTransaction(new TransactionWork<List>() {
                @Override
                public List<VisokoskolskaUstanova> execute(Transaction tx) {
                    List<VisokoskolskaUstanova> list = new ArrayList<>();
                    Result result = tx.run("match(n:Person) return n.name, n.title, n.id");
                    while (result.hasNext()) {
                        Record rec = result.next();
                        VisokoskolskaUstanova person = new VisokoskolskaUstanova();
                        list.add(person);
                    }
                    return list;
                }
            });
            return greeting;
        }
    }


    @Override
    public VisokoskolskaUstanova getById(String id) {
        return null;
    }

    @Override
    public boolean updateEntity(VisokoskolskaUstanova person) {
        return false;
    }

    @Override
    public boolean removeEntity(String id) {
        return false;
    }

    @Override
    public boolean insert(VisokoskolskaUstanova person) {
        deleteDataInGraphDatabase();
        boolean status;
        try (Session session = driver.session()) {
            status = session.writeTransaction(new TransactionWork<Boolean>() {
                @Override
                public Boolean execute(Transaction tx) {
                    List<VisokoskolskaUstanova> lista = new VisokoskolskaUstanovaRepository().getAll();
                    for (
                            VisokoskolskaUstanova faks : lista
                    ) {
                        String query = String.format("CREATE (n:VISOKOSKOLSKA_USTANOVA { " +
                                        "name:'%s'," +
                                        "VU_NAZIV: '%s', " +
                                        "TIP_UST: '%s', " +
                                        "VU_IDENTIFIKATOR:'%s', " +
                                        "VU_NAZIV:'%s', " +
                                        "DR_IDENTIFIKATOR:'%s', " +
                                        "VU_OSNOVANA:'%s', " +
                                        "NM_IDENTIFIKATOR:'%s', " +
                                        "VU_ADRESA:'%s', " +
                                        "VU_WEB_ADRESA:'%s', " +
                                        "VU_E_MAIL:'%s', " +
                                        "VV_OZNAKA:'%s', " +
                                        "VU_PIB:'%s', " +
                                        "VU_MATICNI_BROJ:'%s' })",
                                faks.getVU_NAZIV(),
                                faks.getVU_NAZIV(),
                                faks.getTIP_UST(),
                                faks.getVU_IDENTIFIKATOR(),
                                faks.getVU_NAZIV(),
                                faks.getDR_IDENTIFIKATOR(),
                                faks.getVU_OSNOVANA(),
                                faks.getNM_IDENTIFIKATOR(),
                                faks.getVU_ADRESA(),
                                faks.getVU_WEB_ADRESA(),
                                faks.getVU_E_MAIL(),
                                faks.getVV_OZNAKA(),
                                faks.getVU_PIB(),
                                faks.getVU_MATICNI_BROJ());
                        tx.run(query);

                    }
                    tx.commit();
                    insertRegistrovaniProgrami();
                    insertNastavniPredmeti();
                    insertNivoStudija();
                    insertStepenStudija();
                    return true;
                }
            });
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    @Override
    public void close() throws Exception {
        driver.close();
    }

    private void insertNastavniPredmeti() {
        VisokoskolskaUstanovaRepository vsu = new VisokoskolskaUstanovaRepository();
        List<VisokoskolskaUstanova> list=vsu.getAll();
        try (Session session = driver.session()) {
            session.writeTransaction(new TransactionWork<Boolean>() {
                @Override
                public Boolean execute(Transaction tx) {
                    for (
                            VisokoskolskaUstanova faks :list
                    ) {
                        for (
                                NastavniPredmeti nastavniPredmeti : faks.getNastavniPredmeti()
                        ) {
                            String queryNastavniProgram = String.format("match(n:VISOKOSKOLSKA_USTANOVA {VU_MATICNI_BROJ:'" + faks.getVU_MATICNI_BROJ() + "'}) " +
                                            "create (n)<-[:PROGRAM_REL]-(p:NASTAVNI_PROGRAM{" +
                                            "name:'%s'," +
                                            "VU_IDENTIFIKATOR:'%s', " +
                                            "NP_PREDMET:'%s', " +
                                            "NP_VERZIJA:'%s', " +
                                            "NP_NAZIV_PREDMETA:'%s', " +
                                            "NP_IZBORNA:%B})",
                                    nastavniPredmeti.getNaziv_predmeta(),
                                    nastavniPredmeti.getNaziv_predmeta(),
                                    nastavniPredmeti.getVU_identifikator(),
                                    nastavniPredmeti.getPredmet(),
                                    nastavniPredmeti.getVerzija(),
                                    nastavniPredmeti.isIzborni());
                            tx.run(queryNastavniProgram);
                        }
                    }
                    tx.commit();
                    return true;
                }
            });

        } catch (Exception e) {
            throw e;
        }
    }

    private void insertRegistrovaniProgrami() {
        VisokoskolskaUstanovaRepository vsu = new VisokoskolskaUstanovaRepository();
        try (Session session = driver.session()) {
            session.writeTransaction(new TransactionWork<Boolean>() {
                @Override
                public Boolean execute(Transaction tx) {
                    for (VisokoskolskaUstanova faks : vsu.getAll()
                    ) {
                        for (
                                RegistrovaniProgrami registrovaniProgrami : faks.getRegistrovaniProgramiLIst()
                        ) {
                            String datum = registrovaniProgrami.getSP_DATUM_UKIDANJA() == null ? "" : registrovaniProgrami.getSP_DATUM_UKIDANJA().toString();
                            String queryNastavniProgram = String.format("match(n:VISOKOSKOLSKA_USTANOVA {VU_MATICNI_BROJ:'" + faks.getVU_MATICNI_BROJ() + "'}) " +
                                            "create (n)<-[:REG_PROGRAM_REL]-(p:REGISTROVANI_PROGRAM{" +
                                            "STS_OZNAKA:'%s', " +
                                            "VU_IDENTIFIKATOR:'%s', " +
                                            "TIPP_TIP:'%s', " +
                                            "SP_EVIDENCIONI_BROJ:'%s', " +
                                            "SP_VERZIJA:'%s', " +
                                            "SP_NAZIV:'%s', " +
                                            "TIP_UST:'%s', " +
                                            "NS_NIVO:'%s', " +
                                            "JEZ_JERIK2:'%s', " +
                                            "SN_OZNAKA:'%s', " +
                                            "SP_DATUM_FORMIRANJA:'%s', " +
                                            "SP_DATUM_UKIDANJA:'%s'})",
                                    registrovaniProgrami.getSTS_OZNAKA(),
                                    registrovaniProgrami.getVU_IDENTIFIKATOR(),
                                    registrovaniProgrami.getTIPP_TIP(),
                                    registrovaniProgrami.getSP_EVIDENCIONI_BROJ(),
                                    registrovaniProgrami.getSP_VERZIJA(),
                                    registrovaniProgrami.getSP_NAZIV(),
                                    registrovaniProgrami.getTIP_UST(),
                                    registrovaniProgrami.getNS_NIVO(),
                                    registrovaniProgrami.getJEZ_JERIK2(),
                                    registrovaniProgrami.getSN_OZNAKA(),
                                    registrovaniProgrami.getSP_DATUM_FORMIRANJA(),
                                    datum
                            );
                            tx.run(queryNastavniProgram);
                        }
                    }
                    tx.commit();
                    return true;
                }
            });

        } catch (Exception e) {
            throw e;
        }
    }

    private void insertNivoStudija() {
        RegistrovaniProgramiRepository reg = new RegistrovaniProgramiRepository();

        try (Session session = driver.session()) {
            session.writeTransaction(new TransactionWork<Boolean>() {
                @Override
                public Boolean execute(Transaction tx) {
                    for (
                            RegistrovaniProgrami reg : reg.getAll()
                    ) {
                        for (NivoStudija nivoStudija : reg.getNivoStudijaList()
                        ) {

                            String queryNivoStudija = String.format("match(n:REGISTROVANI_PROGRAM {SP_EVIDENCIONI_BROJ:'" + reg.getSP_EVIDENCIONI_BROJ() + "'}) " +
                                            "create (n)<-[:NIVO_STUDIJA_REL]-(p:NIVO_STUDIJA{" +
                                            "SN_OZNAKA:'%s', " +
                                            "NS_NIVO:'%s', " +
                                            "NA_NAZIV:'%s', " +
                                            "STS_OZNAKA:'%s'})"
                                    ,
                                    nivoStudija.getOznaka(),
                                    nivoStudija.getNivo(),
                                    nivoStudija.getNaziv(),
                                    nivoStudija.getSts_oznaka()
                            );
                            tx.run(queryNivoStudija);
                        }
                    }
                    tx.commit();
                    return true;
                }

            });
        } catch (Exception e) {
            throw e;
        }
    }

    private void insertStepenStudija() {
        NivoStudijaRepository nivo = new NivoStudijaRepository();
        try (Session session = driver.session()) {
            session.writeTransaction(new TransactionWork<Boolean>() {
                @Override
                public Boolean execute(Transaction tx) {
                    for (
                            NivoStudija reg : nivo.getAll()
                    ) {
                        for (StepenStudija stepen : reg.getStepenStudijaList()
                        ) {

                            String queryStepenStudija = String.format("match(n:NIVO_STUDIJA {NS_NIVO:'" + reg.getNivo() + "'}) " +
                                            "create (n)<-[:STEPEN_STUDIJA_REL]-(p:STEPEN_STUDIJA{" +
                                            "STS_NAZIV:'%s', " +
                                            "STS_OZNAKA:'%s'})"
                                    ,
                                    stepen.getNaziv(),
                                    stepen.getSTS_oznaka()
                            );
                            tx.run(queryStepenStudija);
                        }
                    }
                    tx.commit();
                    return true;
                }

            });
        } catch (Exception e) {
            throw e;
        }
    }

    private void deleteDataInGraphDatabase() {

        try (Session session = driver.session()) {
            session.writeTransaction(new TransactionWork<Boolean>() {
                @Override
                public Boolean execute(Transaction tx) {
                    String query = "Match(n) detach delete n";
                    tx.run(query);
                    tx.commit();
                    return true;
                }

            });
        } catch (Exception e) {
            throw e;
        }
    }
}
