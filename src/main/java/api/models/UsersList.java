package api.models;

import java.util.ArrayList;

//TODO Add lombok plugin for getters & setters generating
public class UsersList {

    private ArrayList<User> data;

    public ArrayList<User> getUsers() {
        return data;
    }
}
