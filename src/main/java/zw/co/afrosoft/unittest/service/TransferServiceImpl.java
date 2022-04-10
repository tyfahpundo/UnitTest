package zw.co.afrosoft.unittest.service;

import org.springframework.stereotype.Service;
import zw.co.afrosoft.unittest.domain.Account;
import zw.co.afrosoft.unittest.dto.AccountRequest;
import zw.co.afrosoft.unittest.dto.AccountResponse;
import zw.co.afrosoft.unittest.exceptions.AccountNotFoundException;
import zw.co.afrosoft.unittest.repository.AccountRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService{
    private final AccountRepository accountRepository;

    public TransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) throws AccountNotFoundException {
        Account sender = accountRepository.findById(idSender)
                .orElseThrow(AccountNotFoundException::new);

        Account receiver = accountRepository.findById(idReceiver)
                .orElseThrow(AccountNotFoundException::new);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender,senderNewAmount);
        accountRepository.changeAmount(idReceiver,receiverNewAmount);
    }
    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    public List<Account> getAccountsByName(String name){
        return accountRepository.findAccountsByName(name);
    }

    @Override
    public AccountResponse createAccount(AccountRequest request) {
        Account account = new Account();
        account.setName(request.getName());
        account.setAmount(request.getAmount());
        accountRepository.save(account);
        return AccountResponse.createAccountResponseDto(account);
    }
}
