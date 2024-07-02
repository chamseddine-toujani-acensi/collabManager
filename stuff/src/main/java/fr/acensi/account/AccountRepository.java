package fr.acensi.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByLogin(String login);
    Boolean existsByLogin(String username);
    Boolean existsByEmail(String email);
}
