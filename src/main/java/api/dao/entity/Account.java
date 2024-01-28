package api.dao.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Account {

    @Id
    @GeneratedValue
    Long id;
    Long numberAccount;
    BigDecimal amount;
    String dateCreate;
    Long branchs;
    Long productType;
    Long currencyType;

    public Long getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Long currencyType) {
        this.currencyType = currencyType;
    }

    @ManyToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    Client client;

    public Long getProductType() {
        return productType;
    }

    public void setProductType(Long productType) {
        this.productType = productType;
    }

    public Client getClient() {return client;}

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(Long numberAccount) {
        this.numberAccount = numberAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Long getBranchs() {return branchs;}

    public void setBranchs(Long branchs) {this.branchs = branchs;}
}
