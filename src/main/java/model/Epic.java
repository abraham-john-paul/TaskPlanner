package model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class Epic extends BaseModel {
    @NonNull private final Feature feature;
}
