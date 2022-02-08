package repository;

import java.util.List;

public interface ObjectMappingRepository<Key, Value> {
    void add(final Key key, final Value value);
    List<Value> getAll(final Key key);
}
