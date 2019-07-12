package com.example.entregaveljulho;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.entregaveljulho.model.HomeRestaurantes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Perfil extends AppCompatActivity  {





    private Button salvarPerfil;
    private TextInputEditText nomePf;
    private TextInputEditText emailPf;
    private TextInputEditText senhaPf;
    private TextInputEditText senhaConfirmacaoPf;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nomePf =  findViewById(R.id.nome_perfil);
        emailPf = findViewById(R.id.email_perfil);
        senhaPf = findViewById(R.id.password_perfil);
        senhaConfirmacaoPf = findViewById(R.id.confirm_password_perfil);








        salvarPerfil = findViewById(R.id.save_perfil_id);

        salvarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             botaoClicado(view);
            }
        });


    }

    private void botaoClicado(View view) {


        emailPf.setError(null);
        senhaPf.setError(null);

        if (emailPf.getEditableText().toString().equals("")) {
            emailPf.setError("Informe seu email");

        }else if(!senhaPf.getEditableText().toString().equals(senhaConfirmacaoPf.getEditableText().toString())) {
            senhaPf.setError("senhas digitadas estão divergindo");
            senhaConfirmacaoPf.setError("senhas digitadas estão divergindo");
        } else if(!emailInvalido(emailPf.getEditableText().toString())){
            emailPf.setError("e-mail não foi digitado corretamente");
        }else if(senhaPf.getEditableText().toString().equals("")){
            senhaPf.setError("Informe sua senha");
        }else if (!senhaValida(senhaPf.getEditableText().toString())){
            senhaPf.setError("senha deve ter entre 6 e 14 caracteres");
        }else if (!senhaValida(senhaConfirmacaoPf.getEditableText().toString())){
            senhaConfirmacaoPf.setError("senha deve ter entre 6 e 14 caracteres");
        }else{
            irParaHomeRestaurantes();
        }
    }

    private boolean senhaValida(String senha) {
        senha = senha.trim();
        return senha.length() >= 6 && senha.length() < 14;
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

    private void irParaHomeRestaurantes (){

        Intent intent = new Intent(this, HomeRestaurantes.class);
        startActivity(intent);


    }


}
