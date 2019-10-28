package com.lukaszgil.umiejwmuzyke;


import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class VirtualGuitarActivity extends AppCompatActivity {


    private SoundPool soundPool;
    private int E0, F1, Fis2, G3, Gis4, A5, Ais6, B7, C8, Cis9, D10, Dis11;
    private int E12, F13, Fis14, G15, Gis16, A17, Ais18, B19, C20, Cis21, D22, Dis23;
    private int E24, F25, Fis26, G27, Gis28, A29, Ais30, B31, C32, Cis33, D34, Dis35, E36;


    private int[][] guitarStringFret = new int[6][13];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virtual_guitar);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //Nowy typ tworzenia
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(4)
                    .setAudioAttributes(audioAttributes)
                    .build();

        } else {
            //Stary typ tworzenia
            soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);

        }


//        E0 = soundPool.load(this, R.raw.n0e, 1);
//        F1 = soundPool.load(this, R.raw.n1f, 1);
//        Fis2 = soundPool.load(this, R.raw.n2fis, 1);
//        G3 = soundPool.load(this, R.raw.n3g, 1);
//        Gis4 = soundPool.load(this, R.raw.n4gis, 1);
//        A5 = soundPool.load(this, R.raw.n5a, 1);
//        Ais6 = soundPool.load(this, R.raw.n6ais, 1);
//        B7 = soundPool.load(this, R.raw.n7b, 1);
//        C8 = soundPool.load(this, R.raw.n8c, 1);
//        Cis9 = soundPool.load(this, R.raw.n9cis, 1);
//        D10 = soundPool.load(this, R.raw.n10d, 1);
//        Dis11 = soundPool.load(this, R.raw.n11dis, 1);
//
//        E12 = soundPool.load(this, R.raw.n12e, 1);
//        F13 = soundPool.load(this, R.raw.n13f, 1);
//        Fis14 = soundPool.load(this, R.raw.n14fis, 1);
//        G15 = soundPool.load(this, R.raw.n15g, 1);
//        Gis16 = soundPool.load(this, R.raw.n16gis, 1);
//        A17 = soundPool.load(this, R.raw.n17a, 1);
//        Ais18 = soundPool.load(this, R.raw.n18ais, 1);
//        B19 = soundPool.load(this, R.raw.n19b, 1);
//        C20 = soundPool.load(this, R.raw.n20c, 1);
//        Cis21 = soundPool.load(this, R.raw.n21cis, 1);
//        D22 = soundPool.load(this, R.raw.n22d, 1);
//        Dis23 = soundPool.load(this, R.raw.n23dis, 1);
//
//        E24 = soundPool.load(this, R.raw.n24e, 1);
//        F25 = soundPool.load(this, R.raw.n25f, 1);
//        Fis26 = soundPool.load(this, R.raw.n26fis, 1);
//        G27 = soundPool.load(this, R.raw.n27g, 1);
//        Gis28 = soundPool.load(this, R.raw.n28gis, 1);
//        A29 = soundPool.load(this, R.raw.n29a, 1);
//        Ais30 = soundPool.load(this, R.raw.n30ais, 1);
//        B31 = soundPool.load(this, R.raw.n31b, 1);
//        C32 = soundPool.load(this, R.raw.n32c, 1);
//        Cis33 = soundPool.load(this, R.raw.n33cis, 1);
//        D34 = soundPool.load(this, R.raw.n34d, 1);
//        Dis35 = soundPool.load(this, R.raw.n35dis, 1);
//        E36 = soundPool.load(this, R.raw.n36e, 1);


        for (int j = 5; j >= 0; j--) {
            int[] odstepStrun = {0, 5, 10, 15, 19, 24};
            for (int i = 0; i < 13; i++) {
                guitarStringFret[j][i] = soundPool.load(this, getResources().getIdentifier("n" + (i + odstepStrun[5 - j]), "raw",
                        getApplicationContext().getPackageName()), 1);
            }
        }


    }

    public void playNote(View view) {
        switch (view.getId()) {

            //struna 5
            case R.id.string5fret0E:
                soundPool.play(guitarStringFret[5][0], 1, 1, 0, 0, 1);
                break;
            case R.id.string5fret1F:
                soundPool.play(guitarStringFret[5][1], 1, 1, 0, 0, 1);
                break;
            case R.id.string5fret2Fis:
                soundPool.play(guitarStringFret[5][2], 1, 1, 0, 0, 1);
                break;
            case R.id.string5fret3G:
                soundPool.play(guitarStringFret[5][3], 1, 1, 0, 0, 1);
                break;
            case R.id.string5fret4Gis:
                soundPool.play(guitarStringFret[5][4], 1, 1, 0, 0, 1);
                break;
            case R.id.string5fret5A:
                soundPool.play(guitarStringFret[5][5], 1, 1, 0, 0, 1);
                break;
            case R.id.string5fret6Ais:
                soundPool.play(guitarStringFret[5][6], 1, 1, 0, 0, 1);
                break;
            case R.id.string5fret7B:
                soundPool.play(guitarStringFret[5][7], 1, 1, 0, 0, 1);
                break;
            case R.id.string5fret8C:
                soundPool.play(guitarStringFret[5][8], 1, 1, 0, 0, 1);
                break;
            case R.id.string5fret9Cis:
                soundPool.play(guitarStringFret[5][9], 1, 1, 0, 0, 1);
                break;
            case R.id.string5fret10D:
                soundPool.play(guitarStringFret[5][10], 1, 1, 0, 0, 1);
                break;
            case R.id.string5fret11Dis:
                soundPool.play(guitarStringFret[5][11], 1, 1, 0, 0, 1);
                break;
            case R.id.string5fret12E:
                soundPool.play(guitarStringFret[5][12], 1, 1, 0, 0, 1);
                break;

            //Struna 4
            case R.id.string4fret0A:
                soundPool.play(guitarStringFret[4][0], 1, 1, 0, 0, 1);
                break;
            case R.id.string4fret1Ais:
                soundPool.play(guitarStringFret[4][1], 1, 1, 0, 0, 1);
                break;
            case R.id.string4fret2B:
                soundPool.play(guitarStringFret[4][2], 1, 1, 0, 0, 1);
                break;
            case R.id.string4fret3C:
                soundPool.play(guitarStringFret[4][3], 1, 1, 0, 0, 1);
                break;
            case R.id.string4fret4Cis:
                soundPool.play(guitarStringFret[4][4], 1, 1, 0, 0, 1);
                break;
            case R.id.string4fret5D:
                soundPool.play(guitarStringFret[4][5], 1, 1, 0, 0, 1);
                break;
            case R.id.string4fret6Dis:
                soundPool.play(guitarStringFret[4][6], 1, 1, 0, 0, 1);
                break;
            case R.id.string4fret7E:
                soundPool.play(guitarStringFret[4][7], 1, 1, 0, 0, 1);
                break;
            case R.id.string4fret8F:
                soundPool.play(guitarStringFret[4][8], 1, 1, 0, 0, 1);
                break;
            case R.id.string4fret9Fis:
                soundPool.play(guitarStringFret[4][9], 1, 1, 0, 0, 1);
                break;
            case R.id.string4fret10G:
                soundPool.play(guitarStringFret[4][10], 1, 1, 0, 0, 1);
                break;
            case R.id.string4fret11Gis:
                soundPool.play(guitarStringFret[4][11], 1, 1, 0, 0, 1);
                break;
            case R.id.string4fret12A:
                soundPool.play(guitarStringFret[4][12], 1, 1, 0, 0, 1);
                break;

            // struna 3
            case R.id.string3fret0D:
                soundPool.play(guitarStringFret[3][0], 1, 1, 0, 0, 1);
                break;
            case R.id.string3fret1Dis:
                soundPool.play(guitarStringFret[3][1], 1, 1, 0, 0, 1);
                break;
            case R.id.string3fret2E:
                soundPool.play(guitarStringFret[3][2], 1, 1, 0, 0, 1);
                break;
            case R.id.string3fret3F:
                soundPool.play(guitarStringFret[3][3], 1, 1, 0, 0, 1);
                break;
            case R.id.string3fret4Fis:
                soundPool.play(guitarStringFret[3][4], 1, 1, 0, 0, 1);
                break;
            case R.id.string3fret5G:
                soundPool.play(guitarStringFret[3][5], 1, 1, 0, 0, 1);
                break;
            case R.id.string3fret6Gis:
                soundPool.play(guitarStringFret[3][6], 1, 1, 0, 0, 1);
                break;
            case R.id.string3fret7A:
                soundPool.play(guitarStringFret[3][7], 1, 1, 0, 0, 1);
                break;
            case R.id.string3fret8Ais:
                soundPool.play(guitarStringFret[3][8], 1, 1, 0, 0, 1);
                break;
            case R.id.string3fret9B:
                soundPool.play(guitarStringFret[3][9], 1, 1, 0, 0, 1);
                break;
            case R.id.string3fret10C:
                soundPool.play(guitarStringFret[3][10], 1, 1, 0, 0, 1);
                break;
            case R.id.string3fret11Cis:
                soundPool.play(guitarStringFret[3][11], 1, 1, 0, 0, 1);
                break;
            case R.id.string3fret12D:
                soundPool.play(guitarStringFret[3][12], 1, 1, 0, 0, 1);
                break;

            //struna 2
            case R.id.string2fret0G:
                soundPool.play(guitarStringFret[2][0], 1, 1, 0, 0, 1);
                break;
            case R.id.string2fret1Gis:
                soundPool.play(guitarStringFret[2][1], 1, 1, 0, 0, 1);
                break;
            case R.id.string2fret2A:
                soundPool.play(guitarStringFret[2][2], 1, 1, 0, 0, 1);
                break;
            case R.id.string2fret3Ais:
                soundPool.play(guitarStringFret[2][3], 1, 1, 0, 0, 1);
                break;
            case R.id.string2fret4B:
                soundPool.play(guitarStringFret[2][4], 1, 1, 0, 0, 1);
                break;
            case R.id.string2fret5C:
                soundPool.play(guitarStringFret[2][5], 1, 1, 0, 0, 1);
                break;
            case R.id.string2fret6Cis:
                soundPool.play(guitarStringFret[2][6], 1, 1, 0, 0, 1);
                break;
            case R.id.string2fre7D:
                soundPool.play(guitarStringFret[2][7], 1, 1, 0, 0, 1);
                break;
            case R.id.string2fret8Dis:
                soundPool.play(guitarStringFret[2][8], 1, 1, 0, 0, 1);
                break;
            case R.id.string2fret9E:
                soundPool.play(guitarStringFret[2][9], 1, 1, 0, 0, 1);
                break;
            case R.id.string2fret10F:
                soundPool.play(guitarStringFret[2][10], 1, 1, 0, 0, 1);
                break;
            case R.id.string2fret11Fis:
                soundPool.play(guitarStringFret[2][11], 1, 1, 0, 0, 1);
                break;
            case R.id.string2fret12G:
                soundPool.play(guitarStringFret[2][12], 1, 1, 0, 0, 1);
                break;

            //struna 1
            case R.id.string1fret0B:
                soundPool.play(guitarStringFret[1][0], 1, 1, 0, 0, 1);
                break;
            case R.id.string1fret1C:
                soundPool.play(guitarStringFret[1][1], 1, 1, 0, 0, 1);
                break;
            case R.id.string1fret2Cis:
                soundPool.play(guitarStringFret[1][2], 1, 1, 0, 0, 1);
                break;
            case R.id.string1fre3D:
                soundPool.play(guitarStringFret[1][3], 1, 1, 0, 0, 1);
                break;
            case R.id.string1fret4Dis:
                soundPool.play(guitarStringFret[1][4], 1, 1, 0, 0, 1);
                break;
            case R.id.string1fret5E:
                soundPool.play(guitarStringFret[1][5], 1, 1, 0, 0, 1);
                break;
            case R.id.string1fret6F:
                soundPool.play(guitarStringFret[1][6], 1, 1, 0, 0, 1);
                break;
            case R.id.string1fret7Fis:
                soundPool.play(guitarStringFret[1][7], 1, 1, 0, 0, 1);
                break;
            case R.id.string1fret8G:
                soundPool.play(guitarStringFret[1][8], 1, 1, 0, 0, 1);
                break;
            case R.id.string1fret9Gis:
                soundPool.play(guitarStringFret[1][9], 1, 1, 0, 0, 1);
                break;
            case R.id.string1fret10A:
                soundPool.play(guitarStringFret[1][10], 1, 1, 0, 0, 1);
                break;
            case R.id.string1fret11Ais:
                soundPool.play(guitarStringFret[1][11], 1, 1, 0, 0, 1);
                break;
            case R.id.string1fret12B:
                soundPool.play(guitarStringFret[1][12], 1, 1, 0, 0, 1);
                break;

            //struna 0
            case R.id.string0fret0E:
                soundPool.play(guitarStringFret[0][0], 1, 1, 0, 0, 1);
                break;
            case R.id.string0fret1F:
                soundPool.play(guitarStringFret[0][1], 1, 1, 0, 0, 1);
                break;
            case R.id.string0fret2Fis:
                soundPool.play(guitarStringFret[0][2], 1, 1, 0, 0, 1);
                break;
            case R.id.string0fret3G:
                soundPool.play(guitarStringFret[0][3], 1, 1, 0, 0, 1);
                break;
            case R.id.string0fret4Gis:
                soundPool.play(guitarStringFret[0][4], 1, 1, 0, 0, 1);
                break;
            case R.id.string0fret5A:
                soundPool.play(guitarStringFret[0][5], 1, 1, 0, 0, 1);
                break;
            case R.id.string0fret6Ais:
                soundPool.play(guitarStringFret[0][6], 1, 1, 0, 0, 1);
                break;
            case R.id.string0fret7B:
                soundPool.play(guitarStringFret[0][7], 1, 1, 0, 0, 1);
                break;
            case R.id.string0fret8C:
                soundPool.play(guitarStringFret[0][8], 1, 1, 0, 0, 1);
                break;
            case R.id.string0fret9Cis:
                soundPool.play(guitarStringFret[0][9], 1, 1, 0, 0, 1);
                break;
            case R.id.string0fret10D:
                soundPool.play(guitarStringFret[0][10], 1, 1, 0, 0, 1);
                break;
            case R.id.string0fret11Dis:
                soundPool.play(guitarStringFret[0][11], 1, 1, 0, 0, 1);
                break;
            case R.id.string0fret12E:
                soundPool.play(guitarStringFret[0][12], 1, 1, 0, 0, 1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }


}
