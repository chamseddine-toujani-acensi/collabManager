package fr.acensi.activity.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ActivityNotFoundException extends RuntimeException {
    private final String msg;
}
