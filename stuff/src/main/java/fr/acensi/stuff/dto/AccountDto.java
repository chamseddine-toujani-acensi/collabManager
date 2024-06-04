package fr.acensi.stuff.dto;

import fr.acensi.stuff.account.Account;
import fr.acensi.stuff.account.Status;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * DTO for {@link Account}
 */
@Data
@Builder
public class AccountDto implements Serializable, UserDetails, Comparable<AccountDto> {
    private Long id;
    private String login;
    private String password;
    private String status;
    private String role;

    /**
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    /**
     * @return
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * @return
     */
    @Override
    public String getUsername() {
        return login;
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return !Status.EXPIRED.equals(Status.valueOf(status));
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return !Status.LOCKED.equals(Status.valueOf(status));
    }

    /**
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return !Status.EXPIRED.equals(Status.valueOf(status));
    }

    /**
     * @return
     */
    @Override
    public boolean isEnabled() {
        return Status.ACTIVE.equals(Status.valueOf(status));
    }

    @Override
    public int compareTo(AccountDto o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.login, o.login);
    }
}