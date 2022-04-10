package zw.co.afrosoft.unittest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.afrosoft.unittest.domain.Account;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    private Long id;
    private String name;
    private BigDecimal amount;

    public static AccountResponse createAccountResponseDto(Account account){
        return new AccountResponse(account.getId(), account.getName(), account.getAmount());
    }
}
