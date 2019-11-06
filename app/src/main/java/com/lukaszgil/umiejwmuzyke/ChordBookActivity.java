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

    private String[] rootNotes = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#"};
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
    String[] selectedChordNotes;

    // loadRelativeLayoutChordArray()
    RelativeLayout.LayoutParams chordBookRelativeLayoutChordArrayParams;
    RelativeLayout[] chordBookRelativeLayoutChordArray;

    // loadImageViewNeck()
    RelativeLayout.LayoutParams chordBookImageViewNeckParams;
    ImageView[] chordBookImageViewNeck;

    // loadStringImages()
    RelativeLayout.LayoutParams chordBookImageViewStringsParams;
    ImageView[][] chordBookImageViewStrings;

    // loadNotesDots()
    LinearLayout.LayoutParams chordBookLinearLayoutNotesDotsParams, chordBookImageViewNotesDotsParams;
    LinearLayout[][] chordBookLinearLayoutNotesDots;
    ImageView[][][] chordBookImageViewNotesDots;

    // loadFretNumbers()
    LinearLayout.LayoutParams chordBookLinearLayoutFretNumbersParams, chordBookTextViewFretNumbersParams;
    LinearLayout[] chordBookLinearLayoutFretNumbers;
    TextView[][] chordBookTextViewFretNumbers;

    // loadOpenMuteStrings()
    LinearLayout.LayoutParams chordBookLinearLayoutMuteOpenParams, chordBookTextViewMuteOpenParams;
    LinearLayout[] chordBookLinearLayoutMuteOpen;
    TextView[][] chordBookTextViewMuteOpen;

    // chooseVisibleDotsAndFrets()


    // howManyChords()
    int chordNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chord_book);
        dens = this.getResources().getDisplayMetrics().density;
        chordBookLinearLayoutAllChords = findViewById(R.id.chordBookLinearLayoutAllChords);


        loadFirstChord();


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

    public void composeChord() {
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
        // Toast.makeText(this, selectedChordNotesCombined, Toast.LENGTH_SHORT).show();

        howManyChords();
    }

    private void howManyChords() {

        chordNumber = 0;
        int chordFirstFret = 0;
        int chordLastFret = 12;
        boolean enableFirstAndLastFret = true;
        boolean[] enableStrings = {true, true, true, true, true, true};
        boolean[] foundNotes = new boolean[selectedChordNotes.length];
        int foundNotesNumber = 0;

        while (chordFirstFret < 12) {

            for (int fret = chordFirstFret; fret <= chordLastFret; fret++) {

                for (int string = 0; string < 6; string++) {
                    if (enableStrings[string]) {
                        for (int noteIndex = 0; noteIndex < selectedChordNotes.length; noteIndex++) {


                            if (guitarFretNotes[string][fret].equals(selectedChordNotes[noteIndex])) {

                                if (enableFirstAndLastFret) {

                                    chordLastFret = fret + 3;  //3
                                    enableFirstAndLastFret = false;
                                }

                                enableStrings[string] = false;
                                //if every string false
                                foundNotes[noteIndex] = true;
                                //Toast.makeText(this, guitarFretNotes[string][fret] + string + fret, Toast.LENGTH_SHORT).show();
                                break;


                            } //ifequals

                        } //noteindexloop

                    } //ifenablestring

                } //stringloop

            } //fretloop

            for (boolean note : foundNotes) {
                if (note) {
                    foundNotesNumber++;
                }
            }
            if (foundNotesNumber == selectedChordNotes.length) {

                chordNumber++;
                chordFirstFret++;

            } else {
                chordFirstFret++;
            }

            for (int b = 0; b < 6; b++) {
                enableStrings[b] = true;
            }
            enableFirstAndLastFret = true;
            for (int b = 0; b < selectedChordNotes.length; b++) {
                foundNotes[b] = false;
            }
            foundNotesNumber = 0;
            chordLastFret = 12;

            //Toast.makeText(this, String.valueOf(chordNumber), Toast.LENGTH_SHORT).show();


        } //whileloop

        Toast.makeText(this, String.valueOf(chordNumber), Toast.LENGTH_SHORT).show();


        createRelativeLayoutChordArray();
    }

    public void createRelativeLayoutChordArray() {
        chordBookLinearLayoutAllChords.removeAllViews();
        chordBookRelativeLayoutChordArrayParams = new RelativeLayout.LayoutParams((int) (250 * dens), (int) (350 * dens));
        chordBookRelativeLayoutChordArrayParams.setMarginStart((int) (50 * dens));
        chordBookRelativeLayoutChordArrayParams.setMarginEnd((int) (50 * dens));
        chordBookRelativeLayoutChordArray = new RelativeLayout[chordNumber];
        for (int i = 0; i < chordNumber; i++) {
            chordBookRelativeLayoutChordArray[i] = new RelativeLayout(this);
            chordBookRelativeLayoutChordArray[i].setLayoutParams(chordBookRelativeLayoutChordArrayParams);
            chordBookLinearLayoutAllChords.addView(chordBookRelativeLayoutChordArray[i]);
        }
        loadImageViewNeck();
    }

    public void loadImageViewNeck() {
        chordBookImageViewNeckParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        chordBookImageViewNeckParams.setMarginStart((int) (20 * dens));
        chordBookImageViewNeckParams.setMarginEnd((int) (20 * dens));
        chordBookImageViewNeck = new ImageView[chordNumber];
        for (int i = 0; i < chordNumber; i++) {
            chordBookImageViewNeck[i] = new ImageView(this);
            chordBookImageViewNeck[i].setLayoutParams(chordBookImageViewNeckParams);
            chordBookImageViewNeck[i].setImageResource(R.drawable.chord_book_neck);
            chordBookRelativeLayoutChordArray[i].addView(chordBookImageViewNeck[i]);
        }
        loadStringImages();

    }

    public void loadStringImages() {
        chordBookImageViewStrings = new ImageView[chordNumber][6];
        for (int j = 0; j < chordNumber; j++) {
            for (int i = 0; i < 6; i++) {
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
                chordBookImageViewStrings[j][i] = new ImageView(this);
                chordBookImageViewStrings[j][i].setLayoutParams(chordBookImageViewStringsParams);
                chordBookImageViewStrings[j][i].setImageResource(getResources().getIdentifier("virtual_guitar_string" + i, "drawable", this.getPackageName()));
                chordBookRelativeLayoutChordArray[j].addView(chordBookImageViewStrings[j][i]);
            }
        }

        loadNotesDots();

    }

    public void loadNotesDots() {
        chordBookLinearLayoutNotesDotsParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        chordBookImageViewNotesDotsParams = new LinearLayout.LayoutParams((int) (30 * dens), (int) (30 * dens));
        chordBookImageViewNotesDotsParams.setMarginStart((int) (4.5 * dens));
        chordBookLinearLayoutNotesDots = new LinearLayout[chordNumber][4];
        chordBookImageViewNotesDots = new ImageView[chordNumber][4][6];
        for (int i = 0; i < chordNumber; i++) {
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
                chordBookLinearLayoutNotesDots[i][fret] = new LinearLayout(this);
                chordBookLinearLayoutNotesDots[i][fret].setLayoutParams(chordBookLinearLayoutNotesDotsParams);
                chordBookLinearLayoutNotesDots[i][fret].setGravity(Gravity.CENTER_HORIZONTAL);
                chordBookRelativeLayoutChordArray[i].addView(chordBookLinearLayoutNotesDots[i][fret]);

                for (int string = 5; string >= 0; string--) {
                    chordBookImageViewNotesDots[i][fret][string] = new ImageView(this);
                    chordBookImageViewNotesDots[i][fret][string].setLayoutParams(chordBookImageViewNotesDotsParams);
                    chordBookImageViewNotesDots[i][fret][string].setImageResource(R.drawable.chord_book_note_dot);
                    chordBookImageViewNotesDots[i][fret][string].setVisibility(View.INVISIBLE);

                    chordBookLinearLayoutNotesDots[i][fret].addView(chordBookImageViewNotesDots[i][fret][string]);
                }
            }
        }
        loadFretNumbers();
    }

    public void loadFretNumbers() {
        chordBookLinearLayoutFretNumbersParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        chordBookLinearLayoutFretNumbers = new LinearLayout[chordNumber];

        chordBookTextViewFretNumbersParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        chordBookTextViewFretNumbersParams.setMargins(0, (int) (20 * dens), 0, (int) (20 * dens));
        chordBookTextViewFretNumbers = new TextView[chordNumber][4];

        for (int j = 0; j < chordNumber; j++) {
            chordBookLinearLayoutFretNumbers[j] = new LinearLayout(this);
            chordBookLinearLayoutFretNumbers[j].setOrientation(LinearLayout.VERTICAL);
            chordBookLinearLayoutFretNumbers[j].setGravity(Gravity.CENTER_VERTICAL);
            chordBookLinearLayoutFretNumbers[j].setLayoutParams(chordBookLinearLayoutFretNumbersParams);

            for (int i = 0; i < 4; i++) {
                chordBookTextViewFretNumbers[j][i] = new TextView(this);
                chordBookTextViewFretNumbers[j][i].setLayoutParams(chordBookTextViewFretNumbersParams);
                chordBookTextViewFretNumbers[j][i].setTextSize(20);
                chordBookTextViewFretNumbers[j][i].setTextColor(Color.parseColor("#ddeeff"));
                chordBookTextViewFretNumbers[j][i].setText(String.valueOf(i + 1));
                chordBookLinearLayoutFretNumbers[j].addView(chordBookTextViewFretNumbers[j][i]);
            }
            chordBookRelativeLayoutChordArray[j].addView(chordBookLinearLayoutFretNumbers[j]);
        }
        loadOpenMuteStrings();
    }

    public void loadOpenMuteStrings() {
        chordBookLinearLayoutMuteOpenParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        chordBookLinearLayoutMuteOpen = new LinearLayout[chordNumber];
        chordBookTextViewMuteOpenParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        chordBookTextViewMuteOpenParams.setMarginStart((int) (12 * dens));
        chordBookTextViewMuteOpenParams.setMarginEnd((int) (12 * dens));
        chordBookTextViewMuteOpen = new TextView[chordNumber][6];

        for (int j = 0; j < chordNumber; j++) {
            chordBookLinearLayoutMuteOpen[j] = new LinearLayout(this);
            chordBookLinearLayoutMuteOpen[j].setLayoutParams(chordBookLinearLayoutMuteOpenParams);
            chordBookLinearLayoutMuteOpen[j].setGravity(Gravity.CENTER_HORIZONTAL);

            for (int i = 5; i >= 0; i--) {
                chordBookTextViewMuteOpen[j][i] = new TextView(this);
                chordBookTextViewMuteOpen[j][i].setLayoutParams(chordBookTextViewMuteOpenParams);
                chordBookTextViewMuteOpen[j][i].setTextSize(20);
                chordBookTextViewMuteOpen[j][i].setTextColor(Color.parseColor("#ddeeff"));
                chordBookTextViewMuteOpen[j][i].setText(String.valueOf(i));
                chordBookLinearLayoutMuteOpen[j].addView(chordBookTextViewMuteOpen[j][i]);
            }
            chordBookRelativeLayoutChordArray[j].addView(chordBookLinearLayoutMuteOpen[j]);
        }

        chooseDotsFretsMutes();
    }

    public void chooseDotsFretsMutes() {


        int chordFirstFret = 0;
        int chordLastFret = 12;
        boolean enableFirstAndLastFret = true;
        boolean[] enableStrings = {true, true, true, true, true, true};
        boolean[] foundNotes = new boolean[selectedChordNotes.length];
        int foundNotesNumber = 0;

        for (int i = 0; i < chordNumber; i++) {
            while (chordFirstFret < 12) {

                for (int fret = chordFirstFret; fret <= chordLastFret; fret++) {

                    for (int string = 0; string < 6; string++) {
                        if (enableStrings[string]) {
                            for (int noteIndex = 0; noteIndex < selectedChordNotes.length; noteIndex++) {


                                if (guitarFretNotes[string][fret].equals(selectedChordNotes[noteIndex])) {

                                    if (enableFirstAndLastFret) {

                                        chordLastFret = fret + 3;  //3
                                        enableFirstAndLastFret = false;
                                    }

                                    enableStrings[string] = false;
                                    foundNotes[noteIndex] = true;


                                    if (fret == 0) {
                                        chordBookTextViewMuteOpen[i][string].setText("o");
                                    }


                                    if (chordFirstFret == 0) {
                                        if (fret > 0){
                                            chordBookImageViewNotesDots[i][fret - 1][string].setVisibility(View.VISIBLE);
                                    }
                                }




                                break;
                            } //ifequals

                        } //noteindexloop

                    } //ifenablestring

                } //stringloop

            } //fretloop


            chordFirstFret++;
            for (int b = 0; b < 6; b++) {
                enableStrings[b] = true;
            }


        } //whileloop


    } //forchordnumberloop



//        for (int fret = chordFirstFret; fret <= chordLastFret; fret++) {
//
//            if (chordFirstFret != 0)
//                chordBookTextViewFretNumbers[i][fret - chordFirstFret].setText(String.valueOf(fret));
//            else
//                chordBookTextViewFretNumbers[i][fret - chordFirstFret].setText(String.valueOf(fret + 1));
//
//            for (int string = 5; string >= 0; string--) {
//
//                for (int noteIndex = 0; noteIndex < selectedChordNotes.length; noteIndex++) {
//
//                    if (guitarFretNotes[string][fret].equals(selectedChordNotes[noteIndex])) {
//
//                        if (enableFirstAndLastFret) {
//                            chordFirstFret = fret;
//                            chordLastFret = fret + 3;
//                            enableFirstAndLastFret = false;
//                        }
//                        if (fret == 0) {
//                            chordBookTextViewMuteOpen[i][string].setText("o");
//                            enableStrings[string] = false;
//                            break;
//                        }
//                        if (chordFirstFret == 0) {
//                            if (enableStrings[string]) {
//                                chordBookImageViewNotesDots[i][fret - 1][string].setVisibility(View.VISIBLE);
//                                enableStrings[string] = false;
//                                break;
//                            }
//                        }
//                        if (enableStrings[string]) {
//                            chordBookImageViewNotesDots[i][fret - chordFirstFret][string].setVisibility(View.VISIBLE);
//                            enableStrings[string] = false;
//                            break;
//                        }
//                    }
//                } //noteindexloop
//            } //stringloop
//
//            if (!enableStrings[0] && !enableStrings[1] && !enableStrings[2] && !enableStrings[3] && !enableStrings[4] && !enableStrings[5]) {
//                chordNumber++;
//                chordFirstFret++;
//                chordLastFret = 12;
//                enableStrings[0] = true;
//                enableStrings[1] = true;
//                enableStrings[2] = true;
//                enableStrings[3] = true;
//                enableStrings[4] = true;
//                enableStrings[5] = true;
//                enableFirstAndLastFret = true;
//                break;
//            }
//        } //fretloop


}


}


