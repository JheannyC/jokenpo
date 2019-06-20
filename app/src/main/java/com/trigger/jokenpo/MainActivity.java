package com.trigger.jokenpo;
import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selecionarPedra (View view){
        this.opcaoSelecionada("pedra");
    }
    public void selecionaPapel (View view) {
        this.opcaoSelecionada("papel");
    }
    public void selecionaTesoura (View view) {
        this.opcaoSelecionada("tesoura");
    }
    @SuppressLint("SetTextI18n")
    public void opcaoSelecionada (String escolhaUsuario) {
        ImageView image = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        String [] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random ().nextInt(3);
        String escolhaApp = opcoes[numero];
        switch (escolhaApp) {
            case "pedra":
                image.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                image.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                image.setImageResource(R.drawable.tesoura);
                break;
        }
        if ((escolhaApp.equals("pedra") && escolhaUsuario.equals("tesoura")) ||
            (escolhaApp.equals("papel") && escolhaUsuario.equals("pedra")) ||
            (escolhaApp.equals("tesoura") && escolhaUsuario.equals("papel"))) {
            textResultado.setText("Você perdeu! :( ");
        }
        else if ((escolhaUsuario.equals("pedra") && escolhaApp.equals("tesoura")) ||
                (escolhaUsuario.equals("papel") && escolhaApp.equals("pedra")) ||
                (escolhaUsuario.equals("tesoura") && escolhaApp.equals("papel"))) {
            textResultado.setText("Você ganhou! :D");
        }
        else {
            textResultado.setText("Empate! ;)");
        }

    }
}
