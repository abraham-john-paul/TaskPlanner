package repository;

import model.User;
import repository.exception.InvalidIdInRepoException;
import repository.exception.UserAlreadyExistsException;

import java.util.HashMap;
import java.util.Map;

public class UserObjectRepository implements ObjectRepository<String, User> {
    private final Map<String, User> userMap = new HashMap<>();


    @Override
    public void add(String userId, User user) {
        if (userMap.containsKey(user)) {
            throw new UserAlreadyExistsException();
        }
        userMap.put(userId, user);
    }

    @Override
    public User get(String userId) {
        if (userMap.containsKey(userId)) {
            return userMap.get(userId);
        }
        throw new InvalidIdInRepoException();
    }
}
