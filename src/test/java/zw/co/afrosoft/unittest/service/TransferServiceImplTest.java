package zw.co.afrosoft.unittest.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import zw.co.afrosoft.unittest.domain.Account;
import zw.co.afrosoft.unittest.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TransferServiceImplTest {
    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private TransferServiceImpl transferService;

    @Test
    @DisplayName("Test the amount is transferred if no errors occurred")
    void transferMoneyHappyFlow() {
        Account sender = new Account();
        sender.setId(1L);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2L);
        receiver.setAmount(new BigDecimal(500));

        given(accountRepository.findById(sender.getId()))
                .willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId()))
                .willReturn(Optional.of(receiver));

        transferService.transferMoney(sender.getId(),receiver.getId(),
                new BigDecimal(100));
        verify(accountRepository)
                .changeAmount(1,new BigDecimal(900));
        verify(accountRepository)
                .changeAmount(2,new BigDecimal(600));
    }

    @Test
    void getAllAccounts() {
    }

    @Test
    void getAccountsByName() {
    }

    @Test
    void createAccount() {
    }
}