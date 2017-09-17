package com.techbuddy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp_Fragment extends Fragment implements OnClickListener {
	private static View view;
	private static EditText fullName, emailId,password;
	private static TextView login;
	private static Button signUpButton;
	private static CheckBox terms_conditions;
	CoordinatorLayout coordinatorLayout;
	public SignUp_Fragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.signup_layout, container, false);
		initViews();
		setListeners();
		return view;
	}

	// Initialize all views
	private void initViews() {
		fullName = (EditText) view.findViewById(R.id.fullName);
		emailId = (EditText) view.findViewById(R.id.userEmailId);
		password = (EditText) view.findViewById(R.id.password);
		signUpButton = (Button) view.findViewById(R.id.signUpBtn);
		login = (TextView) view.findViewById(R.id.already_user);
		terms_conditions = (CheckBox) view.findViewById(R.id.terms_conditions);
		coordinatorLayout = (CoordinatorLayout) view.findViewById(R.id.coordinatorLayout);
		// Setting text selector over textviews

	}

	// Set Listeners
	private void setListeners() {
		signUpButton.setOnClickListener(this);
		login.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.signUpBtn:

			// Call checkValidation method
			checkValidation();
			break;

		case R.id.already_user:

			// Replace login fragment
			new MainActivity().replaceLoginFragment();
			break;
		}

	}

	// Check Validation Method
	private void checkValidation() {

		// Get all edittext texts
		String getFullName = fullName.getText().toString();
		String getEmailId = emailId.getText().toString();
		String getPassword = password.getText().toString();

		// Pattern match for email id
		Pattern p = Pattern.compile(Utils.regEx);
		Matcher m = p.matcher(getEmailId);

		// Check if all strings are null or not
		if (getFullName.equals("") || getFullName.length() == 0
				|| getEmailId.equals("") || getEmailId.length() == 0
				|| getPassword.equals("") || getPassword.length() == 0)

		{
			Snackbar snackbar = Snackbar.make(coordinatorLayout, "Fields are empty", Snackbar.LENGTH_SHORT);
			snackbar.show();
		}
		// Check if email id valid or not
		else if (!m.find())
		{
			Snackbar snackbar = Snackbar.make(coordinatorLayout, "Invalid Email", Snackbar.LENGTH_SHORT);
			snackbar.show();
		}

		// Make sure user should check Terms and Conditions checkbox
		else if (!terms_conditions.isChecked())
		{
			Snackbar snackbar = Snackbar.make(coordinatorLayout, "Please check the Terms and Conditon", Snackbar.LENGTH_SHORT);
			snackbar.show();
		}
		// Else do signup or do your stuff
		else
		{
			Snackbar snackbar = Snackbar.make(coordinatorLayout, "Signup Confirm", Snackbar.LENGTH_SHORT);
			snackbar.show();
		}

	}
}
