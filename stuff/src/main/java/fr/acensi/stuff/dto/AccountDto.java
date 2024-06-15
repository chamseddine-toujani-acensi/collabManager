package fr.acensi.stuff.dto;

import fr.acensi.stuff.account.Account;
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
