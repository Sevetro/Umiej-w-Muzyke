package com.lukaszgil.umiejwmuzyke;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

public class ChordBookActivity extends AppCompatActivity {

    private String[] rootNotes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#"};
    private String selectedRootNote, selectedChordType;
    private int selectedRootNoteIndex;
    private String[] selectedChordNotes;
    private View lastRootNoteView, lastChordTypeView;
    private String[][] guitarFretNotes = {
            {"E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G"},
            {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C"},
            {"D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F"},
            {"G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#"},
            {"B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D"},
            {"E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G"}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_book);

        loadFirstChord();


    }


    public void rootNoteClick(View view) {
        lastRootNoteView.setBackgroundColor(Color.parseColor("#282830"));
        lastRootNoteView = view;
        view.setBackgroundColor(Color.parseColor("#909090"));
        selectedRootNote = ((Button) view).getText().toString();
        composeChord();
    }


    public void chordTypeClick(View view) {
        lastChordTypeView.setBackgroundColor(Color.parseColor("#282830"));
        lastChordTypeView = view;
        view.setBackgroundColor(Color.parseColor("#909090"));
        selectedChordType = ((Button) view).getText().toString();
        composeChord();
    }


    private void composeChord() {

        switch (selectedChordType) {
            case "major":
                selectedChordNotes = new String[3];
                selectedChordNotes[0] = selectedRootNote;
                selectedRootNoteIndex = Arrays.asList(rootNotes).indexOf(selectedRootNote);
                selectedChordNotes[1] = rootNotes[selectedRootNoteIndex + 4];
                selectedChordNotes[2] = rootNotes[selectedRootNoteIndex + 7];
                break;
            case "minor":
                selectedChordNotes = new String[3];
                selectedChordNotes[0] = selectedRootNote;
                selectedRootNoteIndex = Arrays.asList(rootNotes).indexOf(selectedRootNote);
                selectedChordNotes[1] = rootNotes[selectedRootNoteIndex + 3];
                selectedChordNotes[2] = rootNotes[selectedRootNoteIndex + 7];
                break;
            case "5":
                selectedChordNotes = new String[2];
                selectedChordNotes[0] = selectedRootNote;
                selectedRootNoteIndex = Arrays.asList(rootNotes).indexOf(selectedRootNote);
                selectedChordNotes[1] = rootNotes[selectedRootNoteIndex + 7];
                break;
            case "7":
                selectedChordNotes = new String[4];
                selectedChordNotes[0] = selectedRootNote;
                selectedRootNoteIndex = Arrays.asList(rootNotes).indexOf(selectedRootNote);
                selectedChordNotes[1] = rootNotes[selectedRootNoteIndex + 4];
                selectedChordNotes[2] = rootNotes[selectedRootNoteIndex + 7];
                selectedChordNotes[3] = rootNotes[selectedRootNoteIndex + 10];
                break;
            case "maj7":
                selectedChordNotes = new String[4];
                selectedChordNotes[0] = selectedRootNote;
                selectedRootNoteIndex = Arrays.asList(rootNotes).indexOf(selectedRootNote);
                selectedChordNotes[1] = rootNotes[selectedRootNoteIndex + 4];
                selectedChordNotes[2] = rootNotes[selectedRootNoteIndex + 7];
                selectedChordNotes[3] = rootNotes[selectedRootNoteIndex + 11];
                break;
            case "m7":
                selectedChordNotes = new String[4];
                selectedChordNotes[0] = selectedRootNote;
                selectedRootNoteIndex = Arrays.asList(rootNotes).indexOf(selectedRootNote);
                selectedChordNotes[1] = rootNotes[selectedRootNoteIndex + 3];
                selectedChordNotes[2] = rootNotes[selectedRootNoteIndex + 7];
                selectedChordNotes[3] = rootNotes[selectedRootNoteIndex + 10];
                break;
        }


        String selectedChordNotesCombined = "";
        for (String note : selectedChordNotes) {
            selectedChordNotesCombined += note;
        }
        Toast.makeText(this, selectedChordNotesCombined, Toast.LENGTH_SHORT).show();
      //  Toast.makeText(this, guitarFretNotes[1][0], Toast.LENGTH_SHORT).show();






    }

    public void loadFirstChord() {
        selectedRootNote = "C";
        selectedChordType = "major";
        lastRootNoteView = findViewById(R.id.btnC);
        lastChordTypeView = findViewById(R.id.btnMajor);
        lastRootNoteView.setBackgroundColor(Color.parseColor("#909090"));
        lastChordTypeView.setBackgroundColor(Color.parseColor("#909090"));
        composeChord();
    }


}
