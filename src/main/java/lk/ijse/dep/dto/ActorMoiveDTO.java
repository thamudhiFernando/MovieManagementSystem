package lk.ijse.dep.dto;

public class ActorMoiveDTO {
    private int actormovieId;
    private int actor_id;
    private int movie_id;
    private String role;

    public ActorMoiveDTO() {

    }

    public ActorMoiveDTO(int actormovieId, int actor_id, int movie_id, String role) {
        this.actormovieId = actormovieId;
        this.actor_id = actor_id;
        this.movie_id = movie_id;
        this.role = role;
    }

    public int getActormovieId() {
        return actormovieId;
    }

    public void setActormovieId(int actormovieId) {
        this.actormovieId = actormovieId;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "ActorMoiveDTO{" +
                "actormovieId=" + actormovieId +
                ", actor_id='" + actor_id + '\'' +
                ", movie_id='" + movie_id + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
