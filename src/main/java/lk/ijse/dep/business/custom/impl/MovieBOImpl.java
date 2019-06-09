package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.custom.MovieBO;
import lk.ijse.dep.dao.custom.MovieDAO;
import lk.ijse.dep.dto.MovieDTO;
import lk.ijse.dep.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class MovieBOImpl implements MovieBO {

    @Autowired
    private MovieDAO movieDAO;

    @Override
    public void save(MovieDTO dto) throws Exception {
        movieDAO.save(new Movie(dto.getMovie_id(),dto.getMovie_name()));
    }

    @Override
    public void remove(Integer id) throws Exception {
        movieDAO.deleteById(id);
    }

    @Override
    public List<MovieDTO> getAlls() throws Exception {
        List<MovieDTO> movieDTOList = movieDAO.findAll().stream().map(movie -> new MovieDTO(movie.getMovie_id(), movie.getMovie_name())).collect(Collectors.toList());
        return movieDTOList;
    }

    @Override
    public MovieDTO getById(Integer id) throws Exception {
        Movie movie = movieDAO.getOne(id);
        MovieDTO movieDTO = new MovieDTO(movie.getMovie_id(), movie.getMovie_name());
        return movieDTO;
    }
}
