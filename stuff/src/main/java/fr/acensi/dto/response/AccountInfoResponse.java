package fr.acensi.dto.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountInfoResponse {
    private Long id;
    private String login;
    private String email;
    private List<String> roles;
}
