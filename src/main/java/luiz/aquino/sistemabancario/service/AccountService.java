package luiz.aquino.sistemabancario.service;

import luiz.aquino.sistemabancario.entity.account.Account;
import luiz.aquino.sistemabancario.entity.account.AccountDTO;
import luiz.aquino.sistemabancario.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private Long accountNumber() {
        var intSize = this.accountRepository.findAll().size();
        return (long) intSize+1;
    }
}
