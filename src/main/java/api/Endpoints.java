package api;

import api.models.User;
import api.models.UsersList;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface Endpoints {

    String USER = "/api/users";
    String USER_BY_ID = "/api/users/{id}";
//    String USERS_LIST = "/api/users";

    @POST(USER)
    Call<User> createUser(@Body User user);

    @GET(USER_BY_ID)
    Call<User> getSingleUser(@Path("id") int id);

    @GET(USER)
    Call<UsersList> getUsersList(@Query("page") int page);

    @PUT(USER_BY_ID)
    Call<User> updateUser(@Path("id") int id, @Body User user);

    @DELETE(USER_BY_ID)
    Call<User> deleteUser(@Path("id") int id);
}
