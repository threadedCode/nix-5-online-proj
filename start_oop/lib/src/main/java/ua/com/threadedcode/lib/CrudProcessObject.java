package ua.com.threadedcode.lib;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

public class CrudProcessObject<E extends BaseEntity> implements ICrudProcess<E> {

    private int size = 10;
    private Object[] objects = new Object[size];

//    public CrudProcessObject() {
//        System.out.println("CrudProcessObject");
//    }

    @Override
    public void create(E e) {
        e.setId(generateId(UUID.randomUUID().toString()));

        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                objects[i] = e;
                break;
            }
        }
    }

    @Override
    public void update(E e) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List read() {
        return Arrays.stream(objects).filter(e -> Objects.nonNull(e)).collect(Collectors.toList());
    }

    @Override
    public E read(String id) {
        return null;
    }

    public E getById(String id) throws NoSuchFieldException {

        for (Object e : objects) {
                if (Objects.equals((e.getClass().getDeclaredField(id)),id)) {
                    return (E) e;
                }
        }
        return (E) null;
    }

    private String generateId(String id) {
        if(Arrays.stream(objects).filter(e -> Objects.nonNull(e)).anyMatch(e -> ((E)e).getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }
}
