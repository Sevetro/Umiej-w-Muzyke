package com.lukaszgil.umiejwmuzyke;


import androidx.appcompat.app.AppCompatActivity;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;


public class VirtualGuitarActivity extends AppCompatActivity {


    private SoundPool soundPool;
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


        loadNotes();


    }




    public void loadNotes() {

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
