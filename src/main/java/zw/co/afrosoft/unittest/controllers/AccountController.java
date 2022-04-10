package zw.co.afrosoft.unittest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.unittest.domain.Account;
import zw.co.afrosoft.unittest.dto.AccountRequest;
import zw.co.afrosoft.unittest.dto.AccountResponse;
import zw.co.afrosoft.unittest.dto.TransferRequest;
import zw.co.afrosoft.unittest.service.TransferService;

@RestController
@RequestMapping("/api/")
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }
    @PostMapping("transfer")
    public void transferMoney(@RequestBody TransferRequest request){
        transferService.transferMoney(request.getSenderAccountId(),
                request.getReceiverAccountId(), request.getAmount());
    }
    @GetMapping("accounts")
    public Iterable<Account> getAllAccounts(@RequestParam(required = false) String name){
        if(name==null){
           return transferService.getAllAccounts();
        }else{
           return transferService.getAccountsByName(name);
        }
    }
    @PostMapping("save")
    public ResponseEntity<AccountResponse>  createAccount(@RequestBody AccountRequest request){
        AccountResponse response = transferService.createAccount(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
