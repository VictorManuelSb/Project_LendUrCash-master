package com.canaveral.ies.lendurcash.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.canaveral.ies.lendurcash.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etMail, etPass;
    Button btLogin;
    TextView tvRegister;
    FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        declareVar();

        btLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(this);

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Log.i("SESSION","session started with mail: " + user.getEmail());
                    //INTENT PARA QUE SE SALTE EL LOGIN SI YA ESTA INICIADO
                }else{
                    Log.i("SESSION", "session closed");
                }
            }
        };
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(authListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        FirebaseAuth.getInstance().removeAuthStateListener(authListener);
    }

    private void login(String mail, String pass){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.i("SESSION","User started successful");
                    Toast.makeText(LoginActivity.this,"Session started succesful.", Toast.LENGTH_SHORT).show();
                    Intent iLogin = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(iLogin);
                }else{
                    Toast.makeText(LoginActivity.this,task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    Log.e("SESSION",task.getException().getMessage() + "");
                }
            }
        });
    }





    protected void declareVar(){
        btLogin = (Button) findViewById(R.id.btLGLogin);
        etMail = (EditText) findViewById(R.id.etLGMail);
        etPass = (EditText) findViewById(R.id.etLGPass);
        tvRegister = (TextView) findViewById(R.id.tvLGRegister);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == this.btLogin.getId()){
            login(etMail.getText().toString(), etPass.getText().toString());
        }else if(v.getId() == this.tvRegister.getId()){
            Intent iRegister = new Intent(this, RegisterActivity.class);
            startActivity(iRegister);
        }
    }
}