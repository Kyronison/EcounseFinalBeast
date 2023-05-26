package com.kyronison.ecounse.utils;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.ToggleButton;

import com.kyronison.ecounse.R;

import org.vosk.Model;
import org.vosk.Recognizer;
import org.vosk.android.SpeechService;
import org.vosk.android.SpeechStreamService;
import org.vosk.android.StorageService;
import org.w3c.dom.Text;

import java.io.IOException;

public class VoiceRecognizer {
    static private final int STATE_START = 0;
    static private final int STATE_READY = 1;
    static private final int STATE_DONE = 2;
    static private final int STATE_MIC = 4;

    private Model model;
    private SpeechService speechService;
    private SpeechStreamService speechStreamService;


    public VoiceRecognizer(Context context) {
        initModel(context);
    }
    /*
    private void setUiState(int state) {
        switch (state) {
            case STATE_START:
                resultView.setText(R.string.preparing);
                resultView.setMovementMethod(new ScrollingMovementMethod());
                findViewById(R.id.mic).setEnabled(false);
                break;
            case STATE_READY:
                resultView.setText(R.string.ready);
                ((Button) findViewById(R.id.mic)).setText(R.string.recognize_microphone);
                findViewById(R.id.mic).setEnabled(true);
                break;
            case STATE_DONE:
                ((Button) findViewById(R.id.mic)).setText(R.string.recognize_microphone);
                findViewById(R.id.mic).setEnabled(true);
                break;
            case STATE_MIC:
                ((Button) findViewById(R.id.mic)).setText(R.string.stop_microphone);
                resultView.setText(getString(R.string.say_something));
                findViewById(R.id.mic).setEnabled(true);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + state);
        }
    }
    */



    private void initModel(Context context) {
        StorageService.unpack(context, "model-en-us", "model",
                (model) -> {
                    this.model = model;
                    //setUiState(STATE_READY);
                },
                (exception) -> setErrorState("Failed to unpack the model" + exception.getMessage()));
    }

    public void recognizeMicrophone() {
        if (speechService != null) {
            //setUiState(STATE_DONE);
            speechService.stop();
            speechService = null;
        } else {
            //setUiState(STATE_MIC);
            try {
                Recognizer rec = new Recognizer(model, 16000.0f);
                speechService = new SpeechService(rec, 16000.0f);
                //speechService.startListening(this);
            } catch (IOException e) {
                setErrorState(e.getMessage());
            }
        }
    }



    private void setErrorState(String message) {
        //resultView.setText(message);
        //((Button) findViewById(R.id.recognize_mic)).setText(R.string.recognize_microphone);
        //findViewById(R.id.recognize_mic).setEnabled(false);
    }
}
