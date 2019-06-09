package lk.ijse.dep.dao.custom;

import lk.ijse.dep.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDAO extends JpaRepository<Movie,Integer> {
}
