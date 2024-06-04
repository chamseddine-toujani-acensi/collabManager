package fr.acensi.mission.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MissionNotFoundException extends RuntimeException{
    private final String msg;
}
