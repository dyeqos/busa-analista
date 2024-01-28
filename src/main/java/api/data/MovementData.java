package api.data;

import java.math.BigDecimal;

public class MovementData {

    Long id;
    Long movementType;//egreso ingreso
    BigDecimal amount;
    String dateTime;
    Long currencyType;
    Long accountId;

    Long numberAccount;

    public Long getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(Long numberAccount) {
        this.numberAccount = numberAccount;
    }

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

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
