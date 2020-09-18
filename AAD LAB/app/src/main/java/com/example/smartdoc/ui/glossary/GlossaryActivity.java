package com.example.smartdoc.ui.glossary;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartdoc.R;
import androidx.appcompat.app.AppCompatActivity;

public class GlossaryActivity extends AppCompatActivity {
    View view;
    ImageButton click_map;


    private TextView showDef;
    private EditText enterWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_glossary);

        showDef = findViewById(R.id.showDef);
        enterWord = findViewById(R.id.enterWord);


    }
    public void onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);


        showDef = findViewById(R.id.showDef);
        enterWord = findViewById(R.id.enterWord);

        view = inflater.inflate(R.layout.fragment_glossary, container, false);

        click_map = view.findViewById(R.id.map_icon_button);
        click_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String language = "en-gb";
                final String word = enterWord.getText().toString(); // now we will get the meaning of the word entered in edittext
                final String fields = "definitions"; // this can be replaced with whatever field you want
                final String strictMatch = "false";
                final String word_id = word.toLowerCase();

              String a= "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;

                Toast toast = Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT);
                toast.show();
            }

        });


    }}