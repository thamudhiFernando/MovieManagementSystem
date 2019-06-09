package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.custom.ActorBO;
import lk.ijse.dep.dao.custom.ActorDAO;
import lk.ijse.dep.dto.ActorDTO;
import lk.ijse.dep.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class ActorBOImpl implements ActorBO {

    @Autowired
    private ActorDAO actorDAO;

    @Override
    public void save(ActorDTO dto) throws Exception {
        actorDAO.save(new Actor(dto.getActor_id(),dto.getActor_name(),dto.getActor_age()));
    }

    @Override
    public void remove(Integer id) throws Exception {
        actorDAO.deleteById(id);
    }

    @Override
    public List<ActorDTO> getAlls() throws Exception {
        List<ActorDTO> actorDTOList = actorDAO.findAll().stream().map(actor -> new ActorDTO(actor.getActor_id(), actor.getActor_name(), actor.getActor_age())).collect(Collectors.toList());
        return actorDTOList;
    }

    @Override
    public ActorDTO getById(Integer id) throws Exception {
        Actor actor = actorDAO.getOne(id);
        ActorDTO actorDTO = new ActorDTO(actor.getActor_id(), actor.getActor_name(), actor.getActor_age());
        return actorDTO;
    }
}
