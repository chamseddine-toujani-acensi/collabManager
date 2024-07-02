package fr.acensi.dto;

import fr.acensi.account.Account;
import lombok.Builder;
import lombok.Data;

import java.util.List;

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
    private List<String> role;
}
