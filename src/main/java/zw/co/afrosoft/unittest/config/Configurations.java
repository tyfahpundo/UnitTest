package zw.co.afrosoft.unittest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.afrosoft.unittest.repository.AccountRepository;
import zw.co.afrosoft.unittest.service.AccountService;
import zw.co.afrosoft.unittest.service.AccountServiceImpl;

@Configuration
public class Configurations {
    @Bean
    public AccountService transferService(AccountRepository accountRepository){
        return new AccountServiceImpl(accountRepository);
    }
}
