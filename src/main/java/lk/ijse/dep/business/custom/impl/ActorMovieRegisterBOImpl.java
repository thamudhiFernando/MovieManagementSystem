package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.custom.ActorMovieRegisterBO;
import lk.ijse.dep.dao.custom.ActorDAO;
import lk.ijse.dep.dao.custom.ActorMovieRegisterDAO;
import lk.ijse.dep.dao.custom.MovieDAO;
import lk.ijse.dep.dto.ActorMoiveDTO;
import lk.ijse.dep.entity.Actor;
import lk.ijse.dep.entity.ActorMovie;
import lk.ijse.dep.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class ActorMovieRegisterBOImpl implements ActorMovieRegisterBO {

    @Autowired
    private ActorMovieRegisterDAO actorMovieRegisterDAO;
    @Autowired
    private ActorDAO actorDAO;
    @Autowired
    private MovieDAO movieDAO;


    @Override
    public void registerActorMovie(ActorMoiveDTO dto) throws Exception {
        Actor selectedActor = actorDAO.getOne(dto.getActor_id());
        Movie selectedMovie = movieDAO.getOne(dto.getMovie_id());
        actorMovieRegisterDAO.save(new ActorMovie(dto.getActormovieId(),dto.getRole(),selectedActor,selectedMovie));
    }
}
