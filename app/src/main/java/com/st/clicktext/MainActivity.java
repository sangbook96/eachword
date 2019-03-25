package com.st.clicktext;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Toast;

import com.st.library.GetWordTextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private GetWordTextView tv_show_text;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_show_text = findViewById(R.id.english_get_word_text_view);
        tv_show_text.setText("hello, how are you? ");
        init();
        tv_show_text.setOnWordClickListener(new GetWordTextView.OnWordClickListener() {
            @Override
            public void onClick(String word) {
                Toast.makeText(MainActivity.this, "" + word, Toast.LENGTH_SHORT).show();
                textToSpeech(word);
                textToSpeech("Hello, how are you?");
            }
        });


    }

    private void init() {
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR)
                    textToSpeech.setLanguage(Locale.US);
            }
        });
    }

    private void textToSpeech(String word){
            textToSpeech.speak(word,TextToSpeech.QUEUE_ADD,null);

    }
}
