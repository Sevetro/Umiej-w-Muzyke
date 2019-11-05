package com.lukaszgil.umiejwmuzyke;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;


import android.os.Handler;
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

import java.sql.Array;
import java.sql.Time;
import java.util.Arrays;
import java.util.Timer;

public class ChordBookActivity extends AppCompatActivity {

    private String[] rootNotes = {"C", "C#", "D", "D#", "E", "F", "F#", "G",
            "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#"};
    private String[][] guitarFretNotes = {
            {"E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G"},
            {"B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D"},
            {"G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#"},
            {"D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F"},
            {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C"},
            {"E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G"}};


    LinearLayout chordBookLinearLayoutAllChords;
    float dens;


    // rootNoteClick(View view)
    private String selectedRootNote;
    private View lastRootNoteView;

    // chordTypeClick(View view)
    private String selectedChordType;
    private View lastChordTypeView;

    //  composeChord()
    int selectedRootNoteIndex;
    private String[] selectedChordNotes;

    // loadRelativeLayoutChordArray()
    RelativeLayout.LayoutParams chordBookRelativeLayoutChordArrayParams;
    private RelativeLayout[] chordBookRelativeLayoutChordArray;

    // loadImageViewNeck()
    RelativeLayout.LayoutParams chordBookImageViewNeckParams;
    ImageView chordBookImageViewNeck;

    // loadStringImages()
    RelativeLayout.LayoutParams chordBookImageViewStringsParams;
    private ImageView[] chordBookImageViewStrings = new ImageView[6];

    // loadNotesDots()
    LinearLayout.LayoutParams chordBookLinearLayoutNotesDotsParams, chordBookImageViewNotesDotsParams;
    private LinearLayout[] chordBookLinearLayoutNotesDots = new LinearLayout[4];
    ImageView[][] chordBookImageViewNotesDots = new ImageView[4][6];

    // loadFretNumbers()
    LinearLayout.LayoutParams chordBookLinearLayoutFretNumbersParams, chordBookTextViewFretNumbersParams;
    LinearLayout chordBookLinearLayoutFretNumbers;
    TextView[] chordBookTextViewFretNumbers = new TextView[4];

    // loadOpenMuteStrings()
    LinearLayout.LayoutParams chordBookLinearLayoutMuteOpenParams, chordBookTextViewMuteOpenParams;
    LinearLayout chordBookLinearLayoutMuteOpen;
    TextView[] chordBookTextViewMuteOpen = new TextView[6];

    // chooseVisibleDots()
    private int chordFirstFret = 0, chordLastFret = 12;
    boolean enableFirstAndLastFret = true;
    boolean[] enableStrings = {true, true, true, true, true, true};
    int chordNumber = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_book);
        dens = this.getResources().getDisplayMetrics().density;
        chordBookLinearLayoutAllChords = findViewById(R.id.chordBookLinearLayoutAllChords);


        loadFirstChord();
        CreateChords();



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
        //Toast.makeText(this, selectedChordNotesCombined, Toast.LENGTH_SHORT).show();
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

    public void createRelativeLayoutChordArray(int i) {
        chordBookRelativeLayoutChordArrayParams = new RelativeLayout.LayoutParams((int) (250 * dens), (int) (350 * dens));
        chordBookRelativeLayoutChordArrayParams.setMarginStart((int) (50 * dens));
        chordBookRelativeLayoutChordArrayParams.setMarginEnd((int) (50 * dens));
        chordBookRelativeLayoutChordArray = new RelativeLayout[chordNumber];
        chordBookRelativeLayoutChordArray[i] = new RelativeLayout(this);
        chordBookRelativeLayoutChordArray[i].setLayoutParams(chordBookRelativeLayoutChordArrayParams);
        chordBookLinearLayoutAllChords.addView(chordBookRelativeLayoutChordArray[i]);
    }

    public void loadImageViewNeck(int i) {
        chordBookImageViewNeckParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        chordBookImageViewNeckParams.setMarginStart((int) (20 * dens));
        chordBookImageViewNeckParams.setMarginEnd((int) (20 * dens));
        chordBookImageViewNeck = new ImageView(this);
        chordBookImageViewNeck.setLayoutParams(chordBookImageViewNeckParams);
        chordBookImageViewNeck.setImageResource(R.drawable.chord_book_neck);
        chordBookRelativeLayoutChordArray[i].addView(chordBookImageViewNeck);

    }

    public void loadStringImages(int j) {
        for (int i = 0; i < 6; i++) {
//            chordBookImageViewStrings[i] = new ImageView(this);
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
            chordBookImageViewStrings[i] = new ImageView(this);
            chordBookImageViewStrings[i].setLayoutParams(chordBookImageViewStringsParams);
            chordBookImageViewStrings[i].setImageResource(getResources().getIdentifier(
                    "virtual_guitar_string" + i, "drawable", this.getPackageName()));
            chordBookRelativeLayoutChordArray[j].addView(chordBookImageViewStrings[i]);
        }
    }

    public void loadNotesDots(int i) {
        chordBookLinearLayoutNotesDotsParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        chordBookImageViewNotesDotsParams = new LinearLayout.LayoutParams((int) (30 * dens), (int) (30 * dens));
        chordBookImageViewNotesDotsParams.setMarginStart((int) (4.5 * dens));
        for (int fret = 0; fret < 4; fret++) {
            switch (fret) {
                case 0:
                    chordBookLinearLayoutNotesDotsParams.setMargins(0, (int) (53 * dens), (int) (5 * dens), 0);
                    break;
                case 1:
                    chordBookLinearLayoutNotesDotsParams.setMargins(0, (int) (125 * dens), (int) (5 * dens), 0);
                    break;
                case 2:
                    chordBookLinearLayoutNotesDotsParams.setMargins(0, (int) (190 * dens), (int) (5 * dens), 0);
                    break;
                case 3:
                    chordBookLinearLayoutNotesDotsParams.setMargins(0, (int) (255 * dens), (int) (5 * dens), 0);
                    break;
            }
            chordBookLinearLayoutNotesDots[fret] = new LinearLayout(this);
            chordBookLinearLayoutNotesDots[fret].setLayoutParams(chordBookLinearLayoutNotesDotsParams);
            chordBookLinearLayoutNotesDots[fret].setGravity(Gravity.CENTER_HORIZONTAL);

            chordBookRelativeLayoutChordArray[i].addView(chordBookLinearLayoutNotesDots[fret]);


//            chordBookImageViewNotesDotsParams = new LinearLayout.LayoutParams((int) (30 * dens), (int) (30 * dens));
//            chordBookImageViewNotesDotsParams.setMarginStart((int) (4.5 * dens));
            for (int string = 5; string >= 0; string--) {
                chordBookImageViewNotesDots[fret][string] = new ImageView(this);
                chordBookImageViewNotesDots[fret][string].setLayoutParams(chordBookImageViewNotesDotsParams);
                chordBookImageViewNotesDots[fret][string].setImageResource(R.drawable.chord_book_note_dot);
                chordBookImageViewNotesDots[fret][string].setVisibility(View.INVISIBLE);

                chordBookLinearLayoutNotesDots[fret].addView(chordBookImageViewNotesDots[fret][string]);
            }
        }


    }

    public void loadFretNumbers(int j) {
        chordBookLinearLayoutFretNumbersParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        chordBookLinearLayoutFretNumbers = new LinearLayout(this);
        chordBookLinearLayoutFretNumbers.setOrientation(LinearLayout.VERTICAL);
        chordBookLinearLayoutFretNumbers.setGravity(Gravity.CENTER_VERTICAL);
        chordBookLinearLayoutFretNumbers.setLayoutParams(chordBookLinearLayoutFretNumbersParams);

        for (int i = 0; i < 4; i++) {
            chordBookTextViewFretNumbersParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            chordBookTextViewFretNumbersParams.setMargins(0, (int) (20 * dens), 0, (int) (20 * dens));
            chordBookTextViewFretNumbers[i] = new TextView(this);
            chordBookTextViewFretNumbers[i].setLayoutParams(chordBookTextViewFretNumbersParams);
            chordBookTextViewFretNumbers[i].setTextSize(20);
            chordBookTextViewFretNumbers[i].setTextColor(Color.parseColor("#ddeeff"));
            chordBookTextViewFretNumbers[i].setText(String.valueOf(i + 1 + chordFirstFret));
            chordBookLinearLayoutFretNumbers.addView(chordBookTextViewFretNumbers[i]);
        }
        chordBookRelativeLayoutChordArray[j].addView(chordBookLinearLayoutFretNumbers);
    }

    public void loadOpenMuteStrings(int j) {
        chordBookLinearLayoutMuteOpenParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        chordBookLinearLayoutMuteOpen = new LinearLayout(this);
        chordBookLinearLayoutMuteOpen.setLayoutParams(chordBookLinearLayoutMuteOpenParams);
        chordBookLinearLayoutMuteOpen.setGravity(Gravity.CENTER_HORIZONTAL);
        for (int i = 5; i >= 0; i--) {
            chordBookTextViewMuteOpenParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            chordBookTextViewMuteOpenParams.setMarginStart((int) (12 * dens));
            chordBookTextViewMuteOpenParams.setMarginEnd((int) (12 * dens));
            chordBookTextViewMuteOpen[i] = new TextView(this);
            chordBookTextViewMuteOpen[i].setLayoutParams(chordBookTextViewMuteOpenParams);
            chordBookTextViewMuteOpen[i].setTextSize(20);
            chordBookTextViewMuteOpen[i].setTextColor(Color.parseColor("#ddeeff"));
            chordBookTextViewMuteOpen[i].setText(String.valueOf(i));
            chordBookLinearLayoutMuteOpen.addView(chordBookTextViewMuteOpen[i]);
        }
        chordBookRelativeLayoutChordArray[j].addView(chordBookLinearLayoutMuteOpen);
    }

    public void chooseVisibleDots() {

        for (int fret = chordFirstFret; fret <= chordLastFret; fret++) {
            for (int string = 5; string >= 0; string--) {
                for (int noteIndex = 0; noteIndex < selectedChordNotes.length; noteIndex++) {
                    if (guitarFretNotes[string][fret].equals(selectedChordNotes[noteIndex])) {
                        if (enableFirstAndLastFret) {
                            chordFirstFret = fret;
                            chordLastFret = fret + 3;
                            enableFirstAndLastFret = !enableFirstAndLastFret;
                        }
                        if (fret == 0) {
                            chordBookTextViewMuteOpen[string].setText("o");
                            enableStrings[string] = !enableStrings[string];
                        }
                        if (chordFirstFret == 0) {
                            if (enableStrings[string]) {
                                chordBookImageViewNotesDots[fret - 1][string].setVisibility(View.VISIBLE);
                                enableStrings[string] = !enableStrings[string];
                            }
                        } else if (enableStrings[string]) {
                            chordBookImageViewNotesDots[fret][string].setVisibility(View.VISIBLE);
                            enableStrings[string] = !enableStrings[string];
                        }
                    }
                }
            }

//            if (!enableStrings[0] && !enableStrings[1] && !enableStrings[2] && !enableStrings[3] && !enableStrings[4] && !enableStrings[5]) {
//                chordNumber++;
//                chordFirstFret = +1;
//                chordLastFret = 12;

        }

    }

    public void CreateChords() {
        for (int counter = 0; counter < chordNumber; counter++) {
            createRelativeLayoutChordArray(counter);
            loadImageViewNeck(counter);
            loadStringImages(counter);
            loadNotesDots(counter);
            loadFretNumbers(counter);
            loadOpenMuteStrings(counter);
            //chooseVisibleDots();
        }
    }


}


