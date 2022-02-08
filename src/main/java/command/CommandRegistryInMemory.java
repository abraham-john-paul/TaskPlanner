package command;

import command.exception.CommandAlreadyExistsException;
import command.exception.InvalidCommandTypeException;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistryInMemory implements CommandRegistry {
    Map<CommandType, Command> commandMap = new HashMap<>();
    @Override
    public void addCommand(CommandType commandType, Command command) {
        if (commandMap.containsKey(commandType)) {
            throw new CommandAlreadyExistsException();
        }
        commandMap.put(commandType, command);
    }

    @Override
    public Command getCommand(CommandType commandType) {
        if (commandMap.containsKey(commandType)) {
            return commandMap.get(commandType);
        }
        throw new InvalidCommandTypeException();
    }
}
