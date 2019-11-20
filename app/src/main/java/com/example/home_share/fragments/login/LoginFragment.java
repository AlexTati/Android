package com.example.home_share.fragments.login;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.home_share.R;
import com.example.home_share.services.api;
import com.example.home_share.services.auth;

public class LoginFragment extends Fragment {

    //region Singleton
    private static LoginFragment instance;

    public static LoginFragment getInstance() {
        return (instance != null) ? instance : (instance = new LoginFragment()) ;
    }
    //endregion

    //region Callback
    public interface ActionCallback {
        void onAction(String text);
    }

    private ActionCallback callback;

    public void setCallback(ActionCallback callback) {
        this.callback = callback;
    }
    //endregion

    public LoginFragment() {
        // Required empty public constructor
    }

    private Button btnAction;

    private EditText eEmail;
    private EditText ePwd;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login, container, false);

        btnAction = v.findViewById(R.id.btnSubmitConnexion);
        eEmail = v.findViewById(R.id.input_email);
        ePwd = v.findViewById(R.id.input_pswd);
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });

        return v;

    }

    public void doLogin(){
        api.Login(eEmail.getText().toString(), ePwd.getText().toString(), new api.LoginCallBackInterface() {
            @Override
            public void onSuccess() {
                Log.d("sam", "Logged user : " + auth.localUser.Firstname);
            }

            @Override
            public void onFailure(String message) {
                Log.d("sam",message);

            }

        });
    }
}