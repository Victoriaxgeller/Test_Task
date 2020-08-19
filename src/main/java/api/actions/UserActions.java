package api.actions;

import api.Endpoints;
import api.models.User;
import api.models.UsersList;
import io.qameta.allure.Step;

import java.io.IOException;
import java.util.List;

public class UserActions {
    private final Endpoints call;

    public UserActions(Endpoints call) {
        this.call = call;
    }

    @Step("Create new user")
    public User createUser(User user) throws IOException {
        return call.createUser(user).execute().body();
    }

    @Step("Get user by ID: {0}")
    public User getUserById(int id) throws IOException {
        return call.getSingleUser(id).execute().body();
    }

    @Step("Request for deleted user by ID:")
    public int getDeletedUserById(int id) throws IOException {
        return call.getSingleUser(id).execute().code();
    }

    @Step("Get users list by page ID: {0}")
    public UsersList getUsersListOnThePage(int pageId) throws IOException {
        return call.getUsersList(pageId).execute().body();
    }

    @Step("Update user by ID: {0}")
    public User updateUserById(int id, User user) throws IOException {
        return call.updateUser(id, user).execute().body();
    }

    @Step("Delete user by ID: {0}")
    public User deleteUserById(int id) throws IOException {
        return call.deleteUser(id).execute().body();
    }
}
