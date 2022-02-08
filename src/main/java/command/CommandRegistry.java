package command;

public interface CommandRegistry {
    void addCommand(CommandType commandType, Command command);

    Command getCommand(CommandType commandType);
}
