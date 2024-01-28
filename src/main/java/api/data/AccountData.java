package api.data;
import java.math.BigDecimal;

public class AccountData {
    Long id;
    Long productType;
    Long numberAccount;
    Long currencyType;
    BigDecimal amount;
    String createDate;
    Long branchs;

    Long clientId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductType() {
        return productType;
    }

    public void setProductType(Long productType) {
        this.productType = productType;
    }

    public Long getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(Long numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Long getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Long currencyType) {
        this.currencyType = currencyType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Long getBranchs() {
        return branchs;
    }

    public void setBranchs(Long branchs) {
        this.branchs = branchs;
    }
}
