package fr.acensi.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CollaboratorNotFoundException extends RuntimeException {
    private final String msg;
}
