package com.example.demo.interfaces;

import java.util.List;

public interface IDAL <Entity>{

    List<Entity> getAll();
    Entity getById(String id);
    Entity getByName(String name);
    boolean updateEntity(Entity entity);
    boolean removeEntity(Entity entity);

}
