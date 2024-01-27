package api.mapper;

import api.dao.entity.Account;
import api.data.AccountData;

public class AccountMapper {

    private static void mapperToAccount(AccountData from, Account to){
        to.setAmount(from.getAmount());
        to.setNumberAccount(from.getNumberAccount());
        to.setBranch(from.getBranch());
        to.setDateCreate(from.getDateCreate());
        to.setId(from.getId());
    }


    public static Account mapperToAccount(AccountData from){
        if(from==null)
            return null;
        Account to = new Account();
        mapperToAccount(from,to);
        return to;
    }
}
