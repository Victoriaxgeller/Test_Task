package api;

import api.models.User;
import api.base.ApiBaseTest;
import api.base.ApiAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.base.ApiAssert.*;
import static org.testng.Assert.*;

public class UserTests extends ApiBaseTest {

    private final ApiClient client = createApiClient();
    private final String TEST_NAME = generateRandomTestData();
    private final String TEST_JOB = generateRandomTestData();
    private final String UPDATED_NAME = generateRandomTestData();
    private final String UPDATED_JOB = generateRandomTestData();
    private final int EXPECTED_CODE = 404;


    @Test(description = "New user is created")
    public void checkNewUserIsCreated() throws IOException {
        User testUser = new User(TEST_NAME, TEST_JOB);
        User createdUser = client.userActions().createUser(testUser);
        assertTrue(createdUsersEquals(createdUser, testUser));
    }

    @Test(description = "A single user is requested")
    public void checkGetSingleUser() throws IOException {
        /*  Get all users list to find id for 'single user request' */
        User userForSingleRequest = client.userActions()
                .getUsersListOnThePage(2)
                .getUsers().get(0);
        User user = client.userActions()
                .getUserById(userForSingleRequest.getId())
                .singleUser();
        assertTrue(existedUsersEquals(user, userForSingleRequest));
    }

    @Test(description = "User info is updated")
    public void checkUpdateUser() throws IOException {
        /*  As tests have to be run parallel, there is a need
           to create a new user and always to be sure user exists */
        User userInfoToCreate = new User(TEST_NAME, TEST_JOB);
        User userInfoToUpdate = new User(UPDATED_NAME, UPDATED_JOB);

        User createdUser = client.userActions().createUser(userInfoToCreate);
        User updatedUser = client.userActions().updateUserById(
                createdUser.getId(), userInfoToUpdate);

        assertFalse(ApiAssert.createdUsersEquals(updatedUser, createdUser));
    }

    @Test(description = "User is deleted")
    public void checkDeleteUser() throws IOException {
        /*  As tests have to be run parallel, there is a need
           to create a new user and always to be sure user exists */
        User userInfoToCreate = new User(TEST_NAME, TEST_JOB);
        User createdUser = client.userActions().createUser(userInfoToCreate);

        client.userActions().deleteUserById(userInfoToCreate.getId());
        int code = client.userActions().getDeletedUserById(createdUser.getId());

        assertEquals(code, EXPECTED_CODE);
    }


    @BeforeClass
    private void prepareTestData() throws IOException {

    }
}
