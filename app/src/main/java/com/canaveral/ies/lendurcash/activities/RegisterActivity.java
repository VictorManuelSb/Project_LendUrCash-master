package com.canaveral.ies.lendurcash.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.canaveral.ies.lendurcash.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    EditText etUser, etMail, etPass1, etPass2;
    Button btRegister;
    FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        declareVar();

        btRegister.setOnClickListener(this);

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Log.i("SESSION","session started with mail: " + user.getEmail());
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


    private void register(String mail, String pass){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Log.i("SESSION","User register successful");
                    Toast.makeText(RegisterActivity.this,"Register successful", Toast.LENGTH_SHORT).show();
                    RegisterActivity.this.finish();
                }else{
                    Toast.makeText(RegisterActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    Log.e("SESSION",task.getException().getMessage() + "");
                }
            }
        });
    }



    private void declareVar(){
        etUser = (EditText) findViewById(R.id.etRGUser);
        etMail = (EditText) findViewById(R.id.etRGMail);
        etPass1 = (EditText) findViewById(R.id.etRGPass1);
        etPass2 = (EditText) findViewById(R.id.etRGPass2);
        btRegister = (Button) findViewById(R.id.btRGRegister);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == this.btRegister.getId()){
            //COMPROBANTE DE NO REPETIR CONTRASEÑAS DE QUE NO EXISTA USUARIO...
            register(etMail.getText().toString(), etPass1.getText().toString());
        }
    }
}
