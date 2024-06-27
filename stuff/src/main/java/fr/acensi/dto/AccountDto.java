package fr.acensi.dto;

import fr.acensi.account.Account;
import lombok.Builder;
import lombok.Data;

/**
 * DTO for {@link Account}
 */
@Data
@Builder
public class AccountDto {
    private Long id;
    private String login;
    private String password;
    private String status;
    private String role;
}
