import command.*;
import model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private CommandRegistry commandRegistry;
    private InputTokenizer inputTokenizer;
    @Before
    void setUp() {
        commandRegistry = new CommandRegistryInMemory();
        Command createSprintMasterCommand = new CreateSprintMasterCommand();
        commandRegistry.addCommand(CommandType.CREATE_SPPINT_MASTER, createSprintMasterCommand);
        inputTokenizer = new SimpleInputTokenizer();
    }
    @Test
    public void createSprintMasterTest() {
        String name = "Abraham";
        String input = "CREATE_SPPINT_MASTER " + name;
        var commandParamData = inputTokenizer.getCommandTypeParamsMap(input);
        Command command = commandRegistry.getCommand(commandParamData.getCommandType());
        User user = (User) command.execute(commandParamData.getParams());

        assertEquals(name,
                user.getName(), "Sprint master has wrong name");
    }
}
