package api.impl;

import api.dao.AccountRepository;
import api.dao.ClientRepository;
import api.dao.MovementRepository;
import api.dao.entity.Account;
import api.dao.entity.Client;
import api.dao.entity.Movement;
import api.data.AccountData;
import api.mapper.AccountMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ApplicationScoped
public class AccountImpl {

    @Inject
    AccountRepository accountRepository;
    @Inject
    MovementRepository movementRepository;
    @Inject
    ClientRepository clientRepository;

    public AccountData save(AccountData account){
        Account entity = AccountMapper.mapperToAccount(account);
        Client client =  clientRepository.findById(account.getClientId());
        entity.setClient(client);
        entity.setAmount(new BigDecimal(0));
        entity.setDateCreate(new Date().toString());
        accountRepository.persist(entity);

        return AccountMapper.mapperToAccountData(entity);
    }
    public List<AccountData> listAccountsByClient(Client data){
        Client client = clientRepository.findById(data.getId());
        Map<String, Object> params = new HashMap<>();
        params.put("client", client);

        List<Account> acountsList = accountRepository.find(
                "SELECT o FROM  Account o WHERE o.client=:client",params
        ).stream().toList();

        return AccountMapper.mapperToListAccountData(acountsList);
    }

    public AccountData update(AccountData data){
        Account entity = accountRepository.findById(data.getId());
        entity.setCurrencyType(data.getCurrencyType());
        entity.setProductType(data.getProductType());
        entity.setBranchs(data.getBranchs());
        entity.setNumberAccount(data.getNumberAccount());

       return AccountMapper.mapperToAccountData(entity);
    }

    public boolean delete(AccountData data){
        Account entity = accountRepository.findById(data.getId());
        if(entity.getAmount().compareTo(BigDecimal.ZERO)==0){
            List<Movement> movementList = movementRepository.listAll();
            for(Movement mov : movementList){
                if(mov.getAccount().getId().equals(entity.getId())){
                    movementRepository.delete(mov);
                }
            }
            return accountRepository.deleteById(data.getId());
        }
        return false;
    }
}
