package ua.com.threadedcode.lib;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class CrudProcessFactory {

    private static CrudProcessFactory instance;
    private Reflections reflections;
    private Set<Class<? extends ICrudProcess>> crudProcessSet;

    private CrudProcessFactory() {
        reflections = new Reflections("ua.com.threadedcode.lib");
        crudProcessSet = reflections.getSubTypesOf(ICrudProcess.class);

    }

    public static CrudProcessFactory getInstance() {
        if (instance == null) {
            instance = new CrudProcessFactory();
        }
        return instance;
    }

    public ICrudProcess getCrudProcess() {
        for(Class<? extends ICrudProcess> crudProcessImpl: crudProcessSet){

            if(!crudProcessImpl.isAnnotationPresent(Ignore.class)){
                try {
                    return (ICrudProcess) crudProcessImpl.getDeclaredConstructor().newInstance();
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    throw new RuntimeException("can't create impl");
                }
            }
        }

        throw new RuntimeException("can't create impl");
    }
}
