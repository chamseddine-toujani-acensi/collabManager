package fr.acensi.stuff.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ActivityNotFoundException extends RuntimeException {
    private final String msg;
}
