package com.techBuddy;



import android.os.AsyncTask;
import android.widget.Toast;

import com.google.firebase.database.*;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sourav on 9/16/17.
 */

public class RegisterUserData {
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;


    public void fillData(RegisterUser registerUser){
        mFirebaseInstance = FirebaseDatabase.getInstance();

        DatabaseReference myRef = mFirebaseInstance.getReference("users");

        String hashedEmail = "";
        try {
            hashedEmail = new Utils().md5(registerUser.email);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println("*************************************************************"+hashedEmail);
        DatabaseReference usersRef = myRef.child(hashedEmail);

        Map<String, String> users = new HashMap<String, String>();
        users.put("Email", registerUser.email);
        users.put("Name", registerUser.name);
        users.put("Password", registerUser.password);
        users.put("Image", registerUser.image);
        users.put("Phone", registerUser.phone);

        usersRef.setValue(users);

    }
}
