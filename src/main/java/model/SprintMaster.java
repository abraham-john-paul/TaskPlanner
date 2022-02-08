package model;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Getter
public class SprintMaster extends User {
    private final List<Sprint> sprints;
}
