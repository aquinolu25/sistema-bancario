package luiz.aquino.sistemabancario.entity.account;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import luiz.aquino.sistemabancario.entity.account.enums.StatusAccount;
import org.springframework.data.mongodb.core.mapping.Document;

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
}
