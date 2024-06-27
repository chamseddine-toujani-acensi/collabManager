package fr.acensi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AbstractEntity {
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
}
