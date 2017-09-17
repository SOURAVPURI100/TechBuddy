package com.techBuddy;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sourav on 9/16/17.
 */

public class Send_Data extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {

        return postData(urls[0]);
    }

    @Override
    protected void onPostExecute(String result) {
        try {

        } catch (Exception j) {
            j.printStackTrace();
        }
    }

    public String postData(String url){
//
        try{
            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("email", email);
//            jsonObject.put("name", name);
//            jsonObject.put("password", password);
//            jsonObject.put("image", image);
//            jsonObject.put("phone",phone);

            //instantiates httpclient to make request
            DefaultHttpClient httpclient = new DefaultHttpClient();

            //url with the post data
            HttpPost httpost = new HttpPost(url);

            //convert parameters into JSON object
//            JSONObject holder = getJsonObjectFromMap(params);

            //passes the results to a string builder/entity
            StringEntity se = new StringEntity(jsonObject.toString());

            //sets the post request as the resulting string
            httpost.setEntity(se);
            //sets a request header so the page receving the request
            //will know what to do with it
            httpost.setHeader("Accept", "application/json");
            httpost.setHeader("Content-type", "application/json");

            //Handles what is returned from the page
            ResponseHandler responseHandler = new BasicResponseHandler();
            httpclient.execute(httpost, responseHandler);
        }

        catch (Exception e){
            e.printStackTrace();

        }

        return  "";

    }
}