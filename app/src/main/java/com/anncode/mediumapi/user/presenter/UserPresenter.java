package com.anncode.mediumapi.user.presenter;

import com.anncode.mediumapi.user.model.User;

/**
 * Created by anahisalgado on 20/06/17.
 */

public interface UserPresenter {
    /*Obtiene la data del repositorio*/
    void getDataUser();
    /*Muestra la información del usuario*/
    void showDataUser(User user);
}
