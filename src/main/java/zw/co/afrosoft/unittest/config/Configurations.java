package zw.co.afrosoft.unittest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zw.co.afrosoft.unittest.repository.AccountRepository;
import zw.co.afrosoft.unittest.service.TransferService;
import zw.co.afrosoft.unittest.service.TransferServiceImpl;

@Configuration
public class Configurations {
    @Bean
    public TransferService transferService(AccountRepository accountRepository){
        return new TransferServiceImpl(accountRepository);
    }
}
