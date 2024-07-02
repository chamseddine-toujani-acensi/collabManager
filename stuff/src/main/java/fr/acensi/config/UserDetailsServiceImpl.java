package fr.acensi.config;

import fr.acensi.account.Account;
import fr.acensi.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final AccountRepository repository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    Account user = repository.findByLogin(login)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with login: " + login));

    return UserDetailsImpl.build(user);
  }
}