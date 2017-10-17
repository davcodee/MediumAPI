package com.anncode.mediumapi.user.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anncode.mediumapi.R;
import com.anncode.mediumapi.user.model.User;
import com.anncode.mediumapi.user.presenter.UserPresenter;
import com.anncode.mediumapi.user.presenter.UserPresenterImpl;
import com.squareup.picasso.Picasso;

public class UserActivity extends AppCompatActivity implements UserView {

    private TextView tvName;
    private TextView tvUserName;
    private ImageView imgProfileImage;

    /*Objeto de user presenter*/
    private UserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = (TextView) findViewById(R.id.tvName);
        tvUserName = (TextView) findViewById(R.id.tvUserName);
        imgProfileImage = (ImageView) findViewById(R.id.profileImage);

        userPresenter = new UserPresenterImpl(this);
        /*LLamamos al método al ejecutar la actividad*/
        getDataUser();
    }

    @Override
    public void getDataUser() {
        userPresenter.getDataUser();
    }

    @Override
    public void showDataUser(User user) {
        tvName.setText(user.getName());
        tvUserName.setText(user.getUserName());
        Picasso.with(this).load(user.getImageUrl()).into(imgProfileImage);
    }


    @Override
    public void goPostList(View view) {
        Toast.makeText(this, "Disabled", Toast.LENGTH_SHORT).show();
    }
}
