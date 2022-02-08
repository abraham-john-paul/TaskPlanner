package controller;

import lombok.NonNull;
import model.User;
import service.UserService;

public class UserController {
    private final UserService userService = new UserService();

    public User addDeveloper(@NonNull final String name) {
        return userService.addDeveloper(name);
    }

    public User addSprintMaster(@NonNull final String name) {
        return userService.addSprintMaster(name);
    }
}
