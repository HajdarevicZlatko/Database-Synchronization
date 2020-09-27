package com.example.demo.interfaces;

import java.text.ParseException;
import java.util.List;

public interface IDAL <Entity>{

    List<Entity> getAll() throws ParseException;
    Entity getById(String id);
    boolean updateEntity(Entity entity);
    boolean removeEntity(String id);
    boolean insert(Entity entity);

}
