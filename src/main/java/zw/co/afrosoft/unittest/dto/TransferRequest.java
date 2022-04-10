package zw.co.afrosoft.unittest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequest {
    private long senderAccountId;
    private long receiverAccountId;
    private BigDecimal amount;
}
