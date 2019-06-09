package lk.ijse.dep.tableModel;

public class ActorTM {
    private int actorID;
    private String actorName;
    private int age;

    public ActorTM() {

    }

    public ActorTM(int actorID, String actorName, int age) {
        this.actorID = actorID;
        this.actorName = actorName;
        this.age = age;
    }

    public int getActorID() {
        return actorID;
    }

    public void setActorID(int actorID) {
        this.actorID = actorID;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
