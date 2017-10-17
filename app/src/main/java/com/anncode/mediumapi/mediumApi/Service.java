package com.anncode.mediumapi.mediumApi;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Clase que concentra los endpoints a concentrar
 */

public interface Service {
    @GET(Constants.URL_GET_USER) // endpoint de acceso
    Call<JsonObject> getDataUser(); // método a ejecutar para obtener la data de el user

}
