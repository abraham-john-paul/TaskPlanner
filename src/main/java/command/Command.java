package command;

import java.util.List;

public interface Command<T> {
    boolean validate(List<String> params);
    T execute(List<String> params);
}
