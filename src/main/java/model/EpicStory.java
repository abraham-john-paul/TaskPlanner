package model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class EpicStory extends Story {
    @NonNull private final Epic epic;
}
