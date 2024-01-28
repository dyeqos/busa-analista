package api.impl;

import api.dao.AccountRepository;
import api.dao.ClientRepository;
import api.dao.MovementRepository;
import api.dao.entity.Account;
import api.dao.entity.Client;
import api.dao.entity.Movement;
import api.data.MovementData;
import api.mapper.MovementMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class MovementImpl {

    @Inject
    AccountRepository accountRepository;
    @Inject
    MovementRepository movementRepository;
    @Inject
    ClientRepository clientRepository;

    public MovementData save(MovementData movement){
        Movement entity = MovementMapper.mapperToMovement(movement);
        Account account =  accountRepository.findById(movement.getAccountId());
        entity.setAccount(account);
        entity.setDateTime(new Date().toString());
        movementRepository.persist(entity);
        return MovementMapper.mapperToMovementData(entity);
    }

    public List<MovementData> listClient(Client client){
        Client clientEntity = clientRepository.findById(client.getId());
        Map<String, Object> params = new HashMap<>();
        params.put("client", clientEntity);

        List<Movement> movementList = movementRepository.find(
                "SELECT o FROM  Movement o WHERE o.account.client=:client ORDER BY o.id DESC",params
        ).stream().toList();

        return MovementMapper.mapperToListMovementData(movementList);
    }

}
