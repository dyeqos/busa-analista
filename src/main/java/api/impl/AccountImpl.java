package api.impl;

import api.dao.AccountRepository;
import api.dao.ClientRepository;
import api.dao.ProductRepository;
import api.dao.entity.Account;
import api.dao.entity.Client;
import api.dao.entity.Product;
import api.data.AccountData;
import api.mapper.AccountMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class AccountImpl {

    @Inject
    AccountRepository accountRepository;
    @Inject
    ClientRepository clientRepository;
    @Inject
    ProductRepository productRepository;

    public List<Account> listProducts(){
        return accountRepository.listAll();
    }
    public Account save(AccountData account){
        Account entity = AccountMapper.mapperToAccount(account);
        Client client =  clientRepository.findById(account.getClientId());
        Product product = productRepository.findById(account.getProductId());
        entity.setClient(client);
        entity.setProduct(product);
        accountRepository.persist(entity);
        return entity;
    }
}
