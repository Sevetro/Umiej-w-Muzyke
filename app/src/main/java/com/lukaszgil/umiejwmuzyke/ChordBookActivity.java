package com.lukaszgil.umiejwmuzyke;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;


import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;

public class ChordBookActivity extends AppCompatActivity {

    private String[] selectedChordNotes, rootNotes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#"};
    private String selectedRootNote, selectedChordType;
    private int selectedRootNoteIndex;
    private View lastRootNoteView, lastChordTypeView;
    private String[][] guitarFretNotes = {
            {"E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G"},
            {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C"},
            {"D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F"},
            {"G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#"},
            {"B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D"},
            {"E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G"}};


    LinearLayout.LayoutParams chordBookLinearLayoutMuteOpenParams, chordBookTextViewMuteOpenParams, chordBookLinearLayoutFretNumbersParams, chordBookTextViewFretNumbersParams ;
    RelativeLayout.LayoutParams chordBookRelativeLayoutParams, chordBookImageViewNeckParams, chordBookImageViewStringsParams;
    RelativeLayout chordBookRelativeLayout;
    LinearLayout chordBookLinearLayoutAllChords, chordBookLinearLayoutMuteOpen, chordBookLinearLayoutFretNumbers;
    ImageView chordBookImageViewNeck;
    ImageView[] chordBookImageViewStrings = new ImageView[6];
    TextView[] chordBookTextViewMuteOpen = new TextView[6], chordBookTextViewFretNumbers = new TextView[4];

    float dens;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_book);

        dens = this.getResources().getDisplayMetrics().density;
        chordBookLinearLayoutAllChords = findViewById(R.id.chordBookLinearLayoutAllChords);

        loadFirstChord();
        loadChordImage();


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
    public void loadChordImage() {

        chordBookRelativeLayoutParams = new RelativeLayout.LayoutParams((int) (250 * dens), (int) (350 * dens));
        chordBookRelativeLayoutParams.setMarginStart((int) (50 * dens));
        chordBookRelativeLayoutParams.setMarginEnd((int) (50 * dens));
        chordBookRelativeLayout = new RelativeLayout(this);
        chordBookRelativeLayout.setLayoutParams(chordBookRelativeLayoutParams);

        //NECK IMAGE###################################

        chordBookImageViewNeck = new ImageView(this);
        chordBookImageViewNeckParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        chordBookImageViewNeckParams.setMarginStart((int) (20 * dens));
        chordBookImageViewNeckParams.setMarginEnd((int) (20 * dens));
        chordBookImageViewNeck.setLayoutParams(chordBookImageViewNeckParams);
        chordBookImageViewNeck.setImageResource(R.drawable.chord_book_neck);

        //STRINGS IMAGES##########################################

        for (int i = 0; i < 6; i++) {
            chordBookImageViewStrings[i] = new ImageView(this);
            chordBookImageViewStringsParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            chordBookImageViewStringsParams.setMargins(0, (int) (30 * dens), 0, (int) (50 * dens));
            switch (i) {
                case 5:
                    chordBookImageViewStringsParams.setMarginStart((int) (35 * dens));
                    break;
                case 4:
                    chordBookImageViewStringsParams.setMarginStart((int) (70 * dens));
                    break;
                case 3:
                    chordBookImageViewStringsParams.setMarginStart((int) (105 * dens));
                    break;
                case 2:
                    chordBookImageViewStringsParams.setMarginStart((int) (140 * dens));
                    break;
                case 1:
                    chordBookImageViewStringsParams.setMarginStart((int) (174 * dens));
                    break;
                case 0:
                    chordBookImageViewStringsParams.setMarginStart((int) (208 * dens));
                    break;
            }
            chordBookImageViewStrings[i].setLayoutParams(chordBookImageViewStringsParams);
            chordBookImageViewStrings[i].setImageResource(getResources().getIdentifier(
                    "virtual_guitar_string" + i, "drawable", this.getPackageName()));
        }

        chordBookRelativeLayout.addView(chordBookImageViewNeck);
        for (int i = 0; i < 6; i++) {
            chordBookRelativeLayout.addView(chordBookImageViewStrings[i]);
        }
        chordBookLinearLayoutAllChords.addView(chordBookRelativeLayout);

// OPEN MUTE@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

        chordBookLinearLayoutMuteOpenParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        chordBookLinearLayoutMuteOpen = new LinearLayout(this);
        chordBookLinearLayoutMuteOpen.setLayoutParams(chordBookLinearLayoutMuteOpenParams);
        chordBookLinearLayoutMuteOpen.setGravity(Gravity.CENTER_HORIZONTAL);
        for (int i = 0; i < 6; i++) {
            chordBookTextViewMuteOpen[i] = new TextView(this);
            chordBookTextViewMuteOpenParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            chordBookTextViewMuteOpenParams.setMarginStart((int) (12 * dens));
            chordBookTextViewMuteOpenParams.setMarginEnd((int) (12 * dens));
            chordBookTextViewMuteOpen[i].setLayoutParams(chordBookTextViewMuteOpenParams);
            chordBookTextViewMuteOpen[i].setTextSize(20);
            chordBookTextViewMuteOpen[i].setTextColor(Color.parseColor("#ddeeff"));
            chordBookTextViewMuteOpen[i].setText("x");
            chordBookLinearLayoutMuteOpen.addView(chordBookTextViewMuteOpen[i]);
        }
        chordBookRelativeLayout.addView(chordBookLinearLayoutMuteOpen);

        //FRET NUMBERS#####################################

        chordBookLinearLayoutFretNumbersParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        chordBookLinearLayoutFretNumbers = new LinearLayout(this);
        chordBookLinearLayoutFretNumbers.setOrientation(LinearLayout.VERTICAL);
        chordBookLinearLayoutFretNumbers.setGravity(Gravity.CENTER_VERTICAL);
        chordBookLinearLayoutFretNumbers.setLayoutParams(chordBookLinearLayoutFretNumbersParams);

        for (int i = 0; i < 4; i++) {
            chordBookTextViewFretNumbers[i] = new TextView(this);
            chordBookTextViewFretNumbersParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            chordBookTextViewFretNumbersParams.setMargins(0,(int) (20 * dens),0,(int) (20 * dens));
            chordBookTextViewFretNumbers[i].setLayoutParams(chordBookTextViewFretNumbersParams);
            chordBookTextViewFretNumbers[i].setTextSize(20);
            chordBookTextViewFretNumbers[i].setTextColor(Color.parseColor("#ddeeff"));
            chordBookTextViewFretNumbers[i].setText("1");
            chordBookLinearLayoutFretNumbers.addView(chordBookTextViewFretNumbers[i]);
        }
        chordBookRelativeLayout.addView(chordBookLinearLayoutFretNumbers);
        



    }

}
