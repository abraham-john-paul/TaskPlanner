package command;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SimpleInputTokenizer implements InputTokenizer {
    @Override
    public CommandTypeParamData getCommandTypeParamsMap(String input) {
        var tokens = Arrays.stream(input.split(" ")).toList();
        CommandType commandType = CommandType.valueOf(tokens.get(0));
        tokens.remove(0);
        return new CommandTypeParamData(commandType, tokens);
    }
}
