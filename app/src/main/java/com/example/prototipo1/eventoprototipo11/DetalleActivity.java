package com.example.prototipo1.eventoprototipo11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.prototipo1.eventoprototipo11.centro.extra_lugar;
import static com.example.prototipo1.eventoprototipo11.centro.extra_titulo;
import static com.example.prototipo1.eventoprototipo11.centro.extra_url;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Intent intent =getIntent();
        String imageurl= intent.getStringExtra(extra_url);
        String title=intent.getStringExtra(extra_titulo);
        String lugar= intent.getStringExtra(extra_lugar);

        ImageView imageview = findViewById(R.id.image_view_deta);
        TextView texttitulo =findViewById(R.id.text_title_deta);
        TextView textlugar = findViewById(R.id.text_lugar_deta);


        Picasso.get()
                .load(imageurl)
                .fit()
                .centerInside()
                .into(imageview);

        texttitulo.setText(title);
        textlugar.setText("lugar: "+lugar);

    }
}
