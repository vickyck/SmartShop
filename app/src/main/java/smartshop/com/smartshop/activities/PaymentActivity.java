package smartshop.com.smartshop.activities;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import java.util.Locale;

import smartshop.com.smartshop.R;

public class PaymentActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {
    private AppCompatButton appCompatButtonSignout;
    private AppCompatButton appCompatButtonCancel;
    private AppCompatButton appCompatButtonPay;
    private AppCompatButton appCompatButtonContactus;
    private TextToSpeech speechEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
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
        appCompatButtonPay = (AppCompatButton) findViewById(R.id.appCompatButtonPay);
        appCompatButtonSignout = (AppCompatButton) findViewById(R.id.appCompatButtonSignout);
        appCompatButtonCancel = (AppCompatButton) findViewById(R.id.appCompatButtonCancel);
        appCompatButtonContactus = (AppCompatButton) findViewById(R.id.appCompatButtonContactus);
    }

    private void initListeners()
    {
        appCompatButtonPay.setOnClickListener(this);
        appCompatButtonSignout.setOnClickListener(this);
        appCompatButtonCancel.setOnClickListener(this);
        appCompatButtonContactus.setOnClickListener(this);
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
            case R.id.appCompatButtonCancel:
                speechEngine.speak(getString(R.string.TodaysDealTitleText), TextToSpeech.QUEUE_FLUSH, null, null);
                Intent productList = new Intent(getApplicationContext(), ProductListActivity.class);
                startActivity(productList);
                break;
            case R.id.appCompatButtonPay:
                speechEngine.speak(getString(R.string.OrderConfirmationSpeakText), TextToSpeech.QUEUE_FLUSH, null, null);
                Intent orderconfirmed = new Intent(getApplicationContext(), OrderConfirmationActivity.class);
                startActivity(orderconfirmed);
                break;
            case R.id.appCompatButtonContactus:
                speechEngine.speak(getString(R.string.ContactUsSpeakText), TextToSpeech.QUEUE_FLUSH, null, null);
                Intent contact = new Intent(getApplicationContext(), ContactUsActivity.class);
                startActivity(contact);
                break;
        }
    }
}
