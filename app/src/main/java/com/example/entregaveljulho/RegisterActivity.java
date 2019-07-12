package com.example.entregaveljulho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.entregaveljulho.model.HomeRestaurantes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity  {

    private EditText nome;
    private EditText email;
    private EditText senha;
    private EditText confirmacaoSenha;
    private Button registroBotao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nome = findViewById(R.id.edit_text_nome);
        email = findViewById(R.id.edit_text_email);
        senha = findViewById(R.id.edit_text_password);
        confirmacaoSenha = findViewById(R.id.edit_text_confirm_password);
        registroBotao = findViewById(R.id.register_registro);

        registroBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               botaoClicado(view);

            }
        });




    }



    private void botaoClicado(View view) {


        email.setError(null);
        senha.setError(null);

        if (email.getEditableText().toString().equals("")) {
            email.setError("Informe seu email");

        }else if(!senha.getEditableText().toString().equals(confirmacaoSenha.getEditableText().toString())) {
              senha.setError("senhas digitadas estão divergindo");
              confirmacaoSenha.setError("senhas digitadas estão divergindo");
        } else if(!emailInvalido(email.getEditableText().toString())){
            email.setError("e-mail não foi digitado corretamente");
        }else if(senha.getEditableText().toString().equals("")){
            senha.setError("Informe sua senha");
        }else if (!senhaValida(senha.getEditableText().toString())){
            senha.setError("senha deve ter entre 6 e 14 caracteres");
        }else if (!senhaValida(confirmacaoSenha.getEditableText().toString())){
            confirmacaoSenha.setError("senha deve ter entre 6 e 14 caracteres");
        }else{
            irParaHomeRestaurantes();
        }
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
