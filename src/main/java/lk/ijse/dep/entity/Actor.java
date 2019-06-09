package lk.ijse.dep.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Actor implements Serializable {
    @Id
    private int actor_id;
    private String actor_name;
    private int actor_age;

    @OneToMany(mappedBy = "actor",cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<ActorMovie> actorMovieList = new ArrayList<>();


    public Actor() {

    }

    public Actor(int actor_id, String actor_name, int actor_age) {
        this.actor_id = actor_id;
        this.actor_name = actor_name;
        this.actor_age = actor_age;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public String getActor_name() {
        return actor_name;
    }

    public void setActor_name(String actor_name) {
        this.actor_name = actor_name;
    }

    public int getActor_age() {
        return actor_age;
    }

    public void setActor_age(int actor_age) {
        this.actor_age = actor_age;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actor_id='" + actor_id + '\'' +
                ", actor_name='" + actor_name + '\'' +
                ", actor_age=" + actor_age +
                '}';
    }
}
