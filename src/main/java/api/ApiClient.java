package api;

import api.actions.UserActions;

public class ApiClient {
    private Endpoints endpoints;

    public ApiClient(final RetrofitSetup retrofitSetup) {
        this.endpoints = retrofitSetup.endpoints();
    }

    public UserActions userActions(){
        return new UserActions(endpoints);
    }
}
