package com.example.demo.interfaces;

import java.util.List;

public interface IDAL <Entity>{

    List<Entity> getAll();
    Entity getById(String id);
    boolean updateEntity(Entity entity);
    boolean removeEntity(String id);
    boolean insert(Entity entity);

}
