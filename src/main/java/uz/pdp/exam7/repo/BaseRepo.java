package uz.pdp.exam7.repo;

import java.lang.reflect.ParameterizedType;

public class BaseRepo<T> {

    private final Class<T> persistentClass;

    public BaseRepo() {
        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().
                getGenericSuperclass()).getActualTypeArguments()[0];
        this.getClass().getGenericSuperclass();
        this.persistentClass = clazz;
    }

}
