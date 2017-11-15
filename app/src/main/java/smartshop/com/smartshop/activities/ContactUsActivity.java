package smartshop.com.smartshop.activities;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import java.util.Locale;

import smartshop.com.smartshop.R;

public class ContactUsActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {

    private AppCompatButton appCompatButtonSignout;
    private AppCompatButton appCompatButtonGoHome;
    private TextToSpeech speechEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        speechEngine = new TextToSpeech(this, this);

        initViews();
        initListeners();
    }

    @Override
    public void onInit(int i) {

        if (i == TextToSpeech.SUCCESS) {
            //Setting speech Language
            speechEngine.setLanguage(Locale.US);
            speechEngine.setPitch(1);
        }
    }

    private void initViews() {
        appCompatButtonGoHome = (AppCompatButton) findViewById(R.id.appCompatButtonGoHome);
        appCompatButtonSignout = (AppCompatButton) findViewById(R.id.appCompatButtonSignout);
    }

    private void initListeners()
    {
        appCompatButtonGoHome.setOnClickListener(this);
        appCompatButtonSignout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.appCompatButtonSignout:
                speechEngine.speak(getString(R.string.SignoutSpeakText), TextToSpeech.QUEUE_FLUSH, null, null);
                Intent loginRegister = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginRegister);
                break;
            case R.id.appCompatButtonGoHome:
                speechEngine.speak(getString(R.string.TodaysDealTitleText), TextToSpeech.QUEUE_FLUSH, null, null);
                Intent productList = new Intent(getApplicationContext(), ProductListActivity.class);
                startActivity(productList);
                break;
        }
    }
}
