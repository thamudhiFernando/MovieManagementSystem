package lk.ijse.dep.dto;

public class ActorDTO {
    private int actor_id;
    private String actor_name;
    private int actor_age;

    public ActorDTO() {

    }

    public ActorDTO(int actor_id, String actor_name, int actor_age) {
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
        return "ActorDTO{" +
                "actor_id='" + actor_id + '\'' +
                ", actor_name='" + actor_name + '\'' +
                ", actor_age='" + actor_age + '\'' +
                '}';
    }
}
