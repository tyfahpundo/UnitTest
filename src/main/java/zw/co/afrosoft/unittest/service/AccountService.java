package zw.co.afrosoft.unittest.service;

import zw.co.afrosoft.unittest.domain.Account;
import zw.co.afrosoft.unittest.dto.AccountRequest;
import zw.co.afrosoft.unittest.dto.AccountResponse;
import zw.co.afrosoft.unittest.exceptions.AccountNotFoundException;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    void transferMoney(long idSender, long idReceiver, BigDecimal amount) throws AccountNotFoundException;
    Iterable<Account> getAllAccounts();
    List<Account> getAccountsByName(String name);

    AccountResponse createAccount(AccountRequest request);
}
