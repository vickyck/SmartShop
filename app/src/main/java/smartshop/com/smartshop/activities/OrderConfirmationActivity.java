package smartshop.com.smartshop.activities;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import java.util.Locale;

import smartshop.com.smartshop.R;

public class OrderConfirmationActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {

    private AppCompatButton appCompatButtonSignout;
    private AppCompatButton appCompatButtonGoHome;
    private AppCompatButton appCompatButtonContactus;
    private TextToSpeech speechEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);
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
            case R.id.appCompatButtonContactus:
                speechEngine.speak(getString(R.string.ContactUsSpeakText), TextToSpeech.QUEUE_FLUSH, null, null);
                Intent contact = new Intent(getApplicationContext(), ContactUsActivity.class);
                startActivity(contact);
                break;
        }
    }

    private void initViews() {
        appCompatButtonSignout = (AppCompatButton) findViewById(R.id.appCompatButtonSignout);
        appCompatButtonGoHome = (AppCompatButton) findViewById(R.id.appCompatButtonGoHome);
        appCompatButtonContactus = (AppCompatButton) findViewById(R.id.appCompatButtonContactus);
    }

    private void initListeners()
    {
        appCompatButtonSignout.setOnClickListener(this);
        appCompatButtonGoHome.setOnClickListener(this);
        appCompatButtonContactus.setOnClickListener(this);
    }
}
