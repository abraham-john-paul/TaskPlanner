package command;

import java.util.List;
import java.util.Map;

public interface InputTokenizer {
    CommandTypeParamData getCommandTypeParamsMap(String input);
}
