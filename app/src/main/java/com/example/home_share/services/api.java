package com.example.home_share.services;


import android.util.Log;


import com.example.home_share.models.membre;
import com.loopj.android.http.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Member;

import cz.msebera.android.httpclient.Header;

public class api {

    public interface LoginCallBackInterface {
        void onSuccess();
        void onFailure(String message);
    }

    private static final String BASE_URL = "http://sam.ovh:3000";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void GetCountries() throws JSONException {
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(BASE_URL + "/countries", new JsonHttpResponseHandler() {

            @Override
            public void onStart() {
                Log.d("SAMY", "START");

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("SAMY", response.toString());

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response){
                Log.d("SAMY", response.toString());

            }


            public void onFailure(int statusCode, Header[] headers, JSONObject errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Log.d("SAMY",errorResponse.toString());

            }

            @Override
            public void onRetry(int retryNo) {
                Log.d("SAMY", "RETRY");
            }
        });

    }

    public static void Login(String email, String password, final LoginCallBackInterface callback ){
        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams params = new RequestParams();
        params.setForceMultipartEntityContentType(true);
        params.put("email", email);
        params.put("password", password);

        client.post( BASE_URL + "/auth/login", params , new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try{
                    auth.setCurrentUser(new membre(response));
                    callback.onSuccess();
                }catch (Exception e){

                }

            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                callback.onFailure(responseString);
            }
        });
    }



}