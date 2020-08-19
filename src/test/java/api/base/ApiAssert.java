package api.base;

import api.models.User;

public class ApiAssert {

    public static boolean createdUsersEquals(User actualUser, User expectedUser) {
        return actualUser.getName().equals(expectedUser.getName()) &&
                actualUser.getJob().equals(expectedUser.getJob());
    }

    public static boolean existedUsersEquals(User actualUser, User expectedUser) {
        return actualUser.getId() == (expectedUser.getId()) &&
                actualUser.getEmail().equals(expectedUser.getEmail()) &&
                actualUser.getAvatar().equals(expectedUser.getAvatar());

    }
}
