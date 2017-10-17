package com.anncode.mediumapi.user.view;

import android.view.View;

import com.anncode.mediumapi.user.model.User;

/**
 * Created by davcode on 20/06/17.
 */

public interface UserView {

        void getDataUser();
        void showDataUser(User user);
        void goPostList(View view
        );
}
