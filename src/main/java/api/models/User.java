package api.models;

import com.google.gson.annotations.SerializedName;
import jdk.nashorn.internal.ir.annotations.Ignore;

//TODO Add lombok plugin for getters & setters generating
public class User {
    private String name;
    private String job;
    private String email;
    private int id;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("lastName")
    private String lastName;
    private String avatar;

    private User data;

    public User() {

    }

    public User(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    public User singleUser() {
        return data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
