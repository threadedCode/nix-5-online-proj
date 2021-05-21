package ua.com.threadedcode.lib;

import java.util.Collection;

public interface ICrudProcess<E extends BaseEntity> {
    void create(E e);
    void update(E e);
    void delete(String id);
    Collection<E> read();
    E read(String id);
}
