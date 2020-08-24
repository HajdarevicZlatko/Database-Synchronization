package com.example.demo.DAL.mysql;

import com.example.demo.interfaces.IDAL;
import com.example.demo.models.RegistrovaniProgrami;

import java.util.List;

public class RegistrovaniProgramiRepository implements IDAL<RegistrovaniProgrami> {
    @Override
    public List<RegistrovaniProgrami> getAll() {
        return null;
    }

    @Override
    public RegistrovaniProgrami getById(String id) {
        return null;
    }


    @Override
    public boolean updateEntity(RegistrovaniProgrami registrovaniProgrami) {
        return false;
    }

    @Override
    public boolean removeEntity(String id) {
        return false;
    }

    @Override
    public boolean insert(RegistrovaniProgrami registrovaniProgrami) {
        return false;
    }
}
