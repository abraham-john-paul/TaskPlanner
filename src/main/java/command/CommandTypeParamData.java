package command;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CommandTypeParamData {
    private final CommandType commandType;
    private final List<String> params;
}
