package fr.acensi.hrmanager.dto;

import fr.acensi.hrmanager.model.AccountStatus;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link fr.acensi.hrmanager.model.Account}
 */
public record AccountDto(Long id, String login, AccountStatus status) implements Serializable {
}