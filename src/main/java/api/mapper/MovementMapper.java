package api.mapper;

import api.dao.entity.Movement;
import api.data.MovementData;

import java.util.ArrayList;
import java.util.List;

public class MovementMapper {

    private static void mapperToMovement(MovementData from, Movement to){
        to.setAmount(from.getAmount());
        to.setCurrencyType(from.getCurrencyType());
        to.setMovementType(from.getMovementType());
        to.setId(from.getId());
    }

    private static void mapperToMovementData(Movement from, MovementData to){
        to.setAmount(from.getAmount());
        to.setCurrencyType(from.getCurrencyType());
        to.setMovementType(from.getMovementType());
        to.setDateTime(from.getDateTime());
        to.setId(from.getId());
        to.setAccountId(from.getAccount().getId());
        to.setNumberAccount(from.getAccount().getNumberAccount());
    }


    public static Movement mapperToMovement(MovementData from){
        if(from==null)
            return null;
        Movement to = new Movement();
        mapperToMovement(from,to);
        return to;
    }

    public static MovementData mapperToMovementData(Movement from){
        if(from==null)
            return null;
        MovementData to = new MovementData();
        mapperToMovementData(from,to);
        return to;
    }

    public static List<MovementData> mapperToListMovementData(List<Movement> from){
        if(from==null)
            return null;
        List<MovementData> to = new ArrayList<>();

        from.forEach(account -> {
            MovementData aux = new MovementData();
            aux = mapperToMovementData(account);
            to.add(aux);
        });
        return to;
    }
}
