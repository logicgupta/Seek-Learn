package com.logic.android.onetoone.basic_video_chat.login;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.logic.android.onetoone.basic_video_chat.dashboard.DashBoardActivity;
import com.logic.android.onetoone.basicvideochat.R;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText edit_email,edit_password;
    TextInputLayout layout_email,layout_password;
    TextView login;
    String username,password;
    TextView signup;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_video);
        init();

        edit_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.length()<0){
                       layout_email.setError("Can't be Empty");
                }
                else{
                    username=editable.toString();
                }

            }
        });

        edit_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if (editable.length()<0){
                    layout_password.setError("Can't be Empty");
                }
                else{
                    password=editable.toString();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username!=null&&password!=null){

                    FirebaseAuth
                            .getInstance()
                            .signInWithEmailAndPassword(username,password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()){
                                    startActivity(new Intent(LoginActivity.this, DashBoardActivity.class));
                                    progressDialog.dismiss();
                                   finish();
                                    }
                                    else{
                                        progressDialog.dismiss();
                                        Toast.makeText(LoginActivity.this, "Please Enter Valid Credentials", Toast.LENGTH_SHORT).show();
                                    }


                                }
                            });
                }
                else if (username==null){

                    layout_email.setError("Can't be Empty");
                }
                else{
                    layout_password.setError("Can't be Empty");
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });
    }

    public void init(){
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        edit_email=findViewById(R.id.edit_email);
        edit_password=findViewById(R.id.edit_password);
        layout_email=findViewById(R.id.email_layout);
        layout_password=findViewById(R.id.password_layout);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.text_signUp);


    }
}
