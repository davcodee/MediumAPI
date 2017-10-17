package com.anncode.mediumapi.mediumApi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Clase que gestiona la conexión a meadium
 */

public class RestApiAdapter {

    public Service getClientService(){

        /*Crea nuestro cliente para poder  ejecutar la conexión*/
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + Constants.BEARER)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();

        /*Ejecuta la conexion a nuestro endpoint*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.ROOT_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Service.class);
    }

}
