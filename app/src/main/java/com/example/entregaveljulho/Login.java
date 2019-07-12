package com.example.entregaveljulho;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.entregaveljulho.model.HomeRestaurantes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    private TextInputEditText emailEditText;
    private TextInputEditText senhaEditText;
    private Button loginButton;
    private TextView registerButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.login_email_edit_text);
        senhaEditText = findViewById(R.id.login_senha_edit_text);
        loginButton = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.buttonRegister);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            botaoClicado(view);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            irParaRegister();
            }
        });
    }

    private void botaoClicado(View view) {


        emailEditText.setError(null);
        senhaEditText.setError(null);

        if (emailEditText.getEditableText().toString().equals("")){
            emailEditText.setError("Informe seu email");
        } else if(!emailInvalido(emailEditText.getEditableText().toString())){
            emailEditText.setError("e-mail não foi digitado corretamente");
        }else if(senhaEditText.getEditableText().toString().equals("")){
            senhaEditText.setError("Informe sua senha");
        }else if (!senhaValida(senhaEditText.getEditableText().toString())){
            senhaEditText.setError("senha deve ter entre 6 e 14 caracteres");
        }else{
            irParaHomeRestaurantes();
        }
    }

    private void logar(){

        String emailDigitado = emailEditText.getEditableText().toString();
        String senhaDigitada = senhaEditText.getEditableText().toString();

        emailEditText.setError(null);
        senhaEditText.setError(null);

        Intent intent = new Intent(this, HomeRestaurantes.class);

        Bundle bundle = new Bundle();

        bundle.putString("EMAIL", emailDigitado);
        bundle.putString("SENHA", senhaDigitada);


        intent.putExtras(bundle);

        startActivity(intent);



    }

    private void irParaRegister (){

        String emailDigitado = emailEditText.getEditableText().toString();
        String senhaDigitada = senhaEditText.getEditableText().toString();

        Intent intent = new Intent(this, RegisterActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("EMAIL", emailDigitado);
        bundle.putString("SENHA", senhaDigitada);


        intent.putExtras(bundle);


        startActivity(intent);



    }

    private void irParaHomeRestaurantes (){

        Intent intent = new Intent(this, HomeRestaurantes.class);
        startActivity(intent);


    }

    private boolean senhaValida(String senha) {
        senha = senha.trim();
        return senha.length() >= 6 && senha.length() < 14 ;
    }

    public static boolean emailInvalido(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
}
