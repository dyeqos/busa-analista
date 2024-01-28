package api.dao.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Movement {

    @Id
    @GeneratedValue
    Long id;
    Long movementType;//egreso ingreso
    BigDecimal amount;
    String dateTime;
    Long currencyType;

    @ManyToOne(targetEntity = Account.class, fetch = FetchType.LAZY)
    Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovementType() {
        return movementType;
    }

    public void setMovementType(Long movementType) {
        this.movementType = movementType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Long getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Long currencyType) {
        this.currencyType = currencyType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
