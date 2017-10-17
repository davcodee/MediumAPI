package com.anncode.mediumapi.user.repository;

import com.anncode.mediumapi.mediumApi.RestApiAdapter;
import com.anncode.mediumapi.mediumApi.Service;
import com.anncode.mediumapi.user.model.User;
import com.anncode.mediumapi.user.presenter.UserPresenter;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by davcode on 20/06/17.
 */

public class UserRepositoryImpl implements UserRepository {

    private UserPresenter userPresenter;

    public UserRepositoryImpl(UserPresenter userPresenter) {
        this.userPresenter = userPresenter;
    }


    /**
     * Implementacion de la aPI
     */

    @Override
    public void getDataUser() {
        /**
         * RestApi adapter sirve para poder realizar una conexión
         * con un
         */
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Service service = restApiAdapter.getClientService(); //trae nuestro servicio

        // ejecuta la llamada
        Call<JsonObject> call =  service.getDataUser(); //obtenemos la información de nuestro endPoint

        //llamamoes a nuestro endPoint
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject userJson = response.body().getAsJsonObject("data");//obtnemos e objec
                User user = new User(
                        userJson.get("id").getAsString(),
                        userJson.get("name").getAsString(),
                        userJson.get("username").getAsString(),
                        userJson.get("url").getAsString(),
                        userJson.get("imageUrl").getAsString()
                );

                userPresenter.showDataUser(user);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

    }
}
