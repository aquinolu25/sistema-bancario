package luiz.aquino.sistemabancario.entity.account;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import luiz.aquino.sistemabancario.entity.account.enums.StatusAccount;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "accounts")
public class Account {

    @Id
    private String id;
    private Long accountNumber;
    private BigDecimal balance;
    private String accountHolder;
    private String password;
    private LocalDateTime openingDate;
    private StatusAccount accountStatus;

    public Account(AccountDTO accountDTO) {
        this.balance = BigDecimal.ZERO;
        this.accountHolder = accountDTO.accountHolder();
        this.openingDate = LocalDateTime.now();
        this.password = encryptPassword(accountDTO.password());
        this.accountStatus = StatusAccount.ACTIVE;
    }

    public String encryptPassword(String rawPassword) {
        return new BCryptPasswordEncoder().encode(rawPassword);
    }
}
