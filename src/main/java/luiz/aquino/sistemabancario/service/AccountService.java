package luiz.aquino.sistemabancario.service;

import luiz.aquino.sistemabancario.entity.account.Account;
import luiz.aquino.sistemabancario.entity.account.AccountDTO;
import luiz.aquino.sistemabancario.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAcoount(AccountDTO accountDTO) {
        Account newAccount = new Account(accountDTO);
        newAccount.setAccountNumber(accountNumber());
        this.accountRepository.save(newAccount);
        return newAccount;
    }

    public List<Account> getAll() {
        return this.accountRepository.findAll();
    }

    public Optional<Account> findById(String id) {
        return this.accountRepository.findById(id);
    }

    private Long accountNumber() {
        var intSize = this.accountRepository.findAll().size();
        return (long) intSize+1;
    }
}
