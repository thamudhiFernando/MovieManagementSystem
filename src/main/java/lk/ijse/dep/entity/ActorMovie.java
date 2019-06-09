package lk.ijse.dep.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ActorMovie implements Serializable {

    @Id
    private int actormovieId;
    private String role;

    @ManyToOne
    @JoinColumn(name = "actorId",referencedColumnName = "actor_id")
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "movieId",referencedColumnName = "movie_id")
    private Movie movie;

    public ActorMovie() {

    }

    public ActorMovie(int actormovieId, String role, Actor actor, Movie movie) {
        this.actormovieId = actormovieId;
        this.role = role;
        this.actor = actor;
        this.movie = movie;
    }

    public int getActormovieId() {
        return actormovieId;
    }

    public void setActormovieId(int actormovieId) {
        this.actormovieId = actormovieId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "ActorMovie{" +
                "actormovieId=" + actormovieId +
                ", role='" + role + '\'' +
                ", actor=" + actor +
                ", movie=" + movie +
                '}';
    }
}
