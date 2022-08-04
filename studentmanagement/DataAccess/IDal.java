package com.project.studentmanagement.DataAccess;

import java.util.List;

@Deprecated
public interface IDal {
    public abstract List getAll();

    public abstract Object getById(int id);

    public abstract <T extends Object> void add(T object);

    public abstract <T extends Object> void update(T object);

    public abstract <T extends Object> void delete(T object);
}
