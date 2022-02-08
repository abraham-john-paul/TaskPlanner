package repository;

import java.util.List;

public interface ObjectRepository<Key, Value> {
    void add(final Key key, final Value value);
    Value get(final Key key);
}
