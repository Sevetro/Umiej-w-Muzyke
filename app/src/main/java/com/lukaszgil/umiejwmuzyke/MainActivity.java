package com.lukaszgil.umiejwmuzyke;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button chordBookActivityBtn;
    private Button virtualGuitarActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //CHORD BOOK
        chordBookActivityBtn = findViewById(R.id.chordBookActivityBtn);
        chordBookActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openChordBookActivity();
            }
        });


        //VIRTUAL GUITAR
        virtualGuitarActivityBtn = findViewById(R.id.virtualGuitarActivityBtn);
        virtualGuitarActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVirtualGuitarActivity();
            }
        });




    }//END onCreate



    public void openChordBookActivity(){
        Intent intent = new Intent(this, ChordBookActivity.class);
        startActivity(intent);
    }

    public void openVirtualGuitarActivity(){
        Intent intent = new Intent(this, VirtualGuitarActivity.class);
        startActivity(intent);
    }

}
