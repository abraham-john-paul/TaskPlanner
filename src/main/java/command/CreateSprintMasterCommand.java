package command;

import command.exception.InvalidCommandParameterException;
import controller.UserController;
import model.User;

import java.util.List;

public class CreateSprintMasterCommand implements Command<User> {
    private final UserController userController = new UserController();
    @Override
    public boolean validate(List<String> params) {
        return params.size() == 1;
    }

    @Override
    public User execute(List<String> params) {
        if (validate(params)) {
            return userController.addSprintMaster(params.get(1));
        }
        throw new InvalidCommandParameterException();
    }
}
