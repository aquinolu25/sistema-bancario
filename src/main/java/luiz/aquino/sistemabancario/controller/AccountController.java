package luiz.aquino.sistemabancario.controller;

import luiz.aquino.sistemabancario.entity.account.Account;
import luiz.aquino.sistemabancario.entity.account.AccountDTO;
import luiz.aquino.sistemabancario.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> create(@RequestBody AccountDTO accountDTO) {
        Account newAccount = this.accountService.createAcoount(accountDTO);
        return ResponseEntity.ok().body(newAccount);
    }
}
