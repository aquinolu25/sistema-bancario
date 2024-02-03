package luiz.aquino.sistemabancario.service;

import luiz.aquino.sistemabancario.entity.account.Account;
import luiz.aquino.sistemabancario.entity.account.AccountDTO;
import luiz.aquino.sistemabancario.entity.account.enums.StatusAccount;
import luiz.aquino.sistemabancario.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import luiz.aquino.sistemabancario.entity.account.exceptions.AccountNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Account findById(String id) {
        Account account = this.accountRepository.findById(id)
                .orElseThrow(AccountNotFoundException::new);
        return account;
    }

    public void deleteAccount(String id) {
        Account account = this.accountRepository.findById(id)
                .orElseThrow(AccountNotFoundException::new);
        this.accountRepository.delete(account);
    }

    private Long accountNumber() {
        var intSize = this.accountRepository.findAll().size();
        return (long) intSize+1;
    }
}
