package zw.co.afrosoft.unittest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import zw.co.afrosoft.unittest.domain.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findAccountsByName(String name);

    @Modifying
    @Query(value = "UPDATE account SET amount = :amount WHERE id = :id",nativeQuery = true)
    void changeAmount(long id, BigDecimal amount);
}
