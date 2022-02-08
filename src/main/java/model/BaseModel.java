package model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Getter
@SuperBuilder
public abstract class BaseModel {
    final private String id;
    final private Date createdAt;
    @Setter
    private Date modifiedAt;

    public BaseModel() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = Date.from(Instant.now());
    }
}
