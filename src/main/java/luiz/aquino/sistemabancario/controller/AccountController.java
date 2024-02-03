package luiz.aquino.sistemabancario.controller;

import luiz.aquino.sistemabancario.entity.account.Account;
import luiz.aquino.sistemabancario.entity.account.AccountDTO;
import luiz.aquino.sistemabancario.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        List<Account> accounts = this.accountService.getAll();
        return ResponseEntity.ok().body(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Account>> findById(@PathVariable String id) {
        Optional<Account> newAccount = this.accountService.findById(id);
        return ResponseEntity.ok().body(newAccount);
    }
}
