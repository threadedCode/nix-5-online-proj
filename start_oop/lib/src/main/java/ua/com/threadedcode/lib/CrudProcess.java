package ua.com.threadedcode.lib;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Ignore
public class CrudProcess<E extends BaseEntity> implements ICrudProcess<E> {
    private final List<E> list = new ArrayList<>();

    public CrudProcess() {
        System.out.println("CrudProcess");
    }

    public void create(E e) {
        e.setId(generateId(UUID.randomUUID().toString()));
        list.add(e);
    }

    public void update(E e) {
        if (StringUtils.isNoneBlank(e.getId())) {
            E current = getById(e.getId());
            if (current == null) {
                throw new RuntimeException("entity is not exist");
            }
            try {
                BeanUtils.copyProperties(current, e);
            } catch (IllegalAccessException | InvocationTargetException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
        } else {
            throw new RuntimeException("entity is not exist");
        }
    }

    public void delete(String id) {
        if (StringUtils.isNoneBlank(id)) {
            E current = getById(id);
            if (current == null) {
                throw new RuntimeException("entity is not exist");
            }
            list.removeIf(e -> e.getId().equals(id));
        } else {
            throw new RuntimeException("entity is not exist");
        }
    }


    public List<E> read() {
        return list;
    }

    public E read(String id) {
        if (StringUtils.isNoneBlank(id)) {
            E current = getById(id);
            if (current == null) {
                throw new RuntimeException("entity is not exist");
            }
            return current;
        }else {
            throw new RuntimeException("entity is not exist");
        }
    }

    public E getById(String id) {
        return list.stream().filter(e -> id.equals(e.getId())).findAny().orElse(null);
    }

    private String generateId(String id) {
        if (list.stream().anyMatch(e -> e.getId().equals(id))) {
            return generateId(UUID.randomUUID().toString());
        }
        return id;
    }
}
