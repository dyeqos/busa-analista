package api.mapper;

import api.dao.entity.Account;
import api.data.AccountData;

import java.util.ArrayList;
import java.util.List;

public class AccountMapper {

    private static void mapperToAccount(AccountData from, Account to){
        to.setAmount(from.getAmount());
        to.setNumberAccount(from.getNumberAccount());
        to.setBranchs(from.getBranchs());
        to.setDateCreate(from.getCreateDate());
        to.setProductType(from.getProductType());
        to.setCurrencyType(from.getCurrencyType());
        to.setId(from.getId());
    }

    private static void mapperToAccountData(Account from, AccountData to){
        to.setAmount(from.getAmount());
        to.setNumberAccount(from.getNumberAccount());
        to.setBranchs(from.getBranchs());
        to.setCreateDate(from.getDateCreate());
        to.setProductType(from.getProductType());
        to.setCurrencyType(from.getCurrencyType());
        to.setClientId(from.getClient().getId());
        to.setId(from.getId());
    }


    public static Account mapperToAccount(AccountData from){
        if(from==null)
            return null;
        Account to = new Account();
        mapperToAccount(from,to);
        return to;
    }

    public static AccountData mapperToAccountData(Account from){
        if(from==null)
            return null;
        AccountData to = new AccountData();
        mapperToAccountData(from,to);
        return to;
    }

    public static List<AccountData> mapperToListAccountData(List<Account> from){
        if(from==null)
            return null;
        List<AccountData> to = new ArrayList<>();

        from.forEach(account -> {
            AccountData aux = new AccountData();
            aux = mapperToAccountData(account);
            to.add(aux);
        });
        return to;
    }
}
