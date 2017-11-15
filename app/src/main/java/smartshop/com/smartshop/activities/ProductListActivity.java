package smartshop.com.smartshop.activities;

import android.content.Intent;
import android.graphics.Color;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.util.Locale;

import smartshop.com.smartshop.R;

public class ProductListActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {
    private final AppCompatActivity activity = ProductListActivity.this;
    private AppCompatButton appCompatButtonSignout;
    private AppCompatButton appCompatButtonViewUsers;
    private AppCompatButton appCompatButtonContactus;
    private TextToSpeech speechEngine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
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
        appCompatButtonSignout = (AppCompatButton) findViewById(R.id.appCompatButtonSignout);
        appCompatButtonViewUsers = (AppCompatButton) findViewById(R.id.appCompatButtonViewUsers);
        appCompatButtonContactus = (AppCompatButton) findViewById(R.id.appCompatButtonContactus);

        String[] strProductList = getString(R.string.ProductList).split(",");
        LinearLayoutCompat myLinearLayout = (LinearLayoutCompat)findViewById(R.id.linearLayoutProductListImage);

        for(int i = 0; i < strProductList.length; i++)
        {
            ImageButton b = new ImageButton(this);
            AppCompatTextView t = new AppCompatTextView(this);
            AppCompatButton btnCheckout = new AppCompatButton(this);

            btnCheckout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                // Perform action on click
                Intent accountsIntent = new Intent(activity, PaymentActivity.class);
                speechEngine.speak(getString(R.string.PaymentSpeakText), TextToSpeech.QUEUE_FLUSH, null, null);
                startActivity(accountsIntent);
                }
            });

            if (i == 0) b.setImageResource(R.mipmap.sonyheadphones);
            else b.setImageResource(R.mipmap.walkingstick);
            b.setBackgroundColor(Color.TRANSPARENT);
            b.setId(i);

            t.setText(strProductList[i]);
            btnCheckout.setText("Check out");
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            if (i > 0) {
                lp.addRule(RelativeLayout.RIGHT_OF, b.getId() - 1);
            }

            b.setLayoutParams(lp);
            b.setTag(i);

            myLinearLayout.addView(b);
            myLinearLayout.addView(t);
            myLinearLayout.addView(btnCheckout);
        }
    }

    private void initListeners()
    {
        appCompatButtonSignout.setOnClickListener(this);
        appCompatButtonViewUsers.setOnClickListener(this);
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
            case R.id.appCompatButtonViewUsers:
                speechEngine.speak(getString(R.string.ViewRegisteredUserListSpeakText), TextToSpeech.QUEUE_FLUSH, null, null);
                Intent viewUserList = new Intent(getApplicationContext(), UsersListActivity.class);
                startActivity(viewUserList);
                break;
            case R.id.appCompatButtonPay:
                speechEngine.speak(getString(R.string.ViewRegisteredUserListSpeakText), TextToSpeech.QUEUE_FLUSH, null, null);
                Intent orderConfirmationList = new Intent(getApplicationContext(), OrderConfirmationActivity.class);
                startActivity(orderConfirmationList);
                break;
            case R.id.appCompatButtonContactus:
                speechEngine.speak(getString(R.string.ContactUsSpeakText), TextToSpeech.QUEUE_FLUSH, null, null);
                Intent contact = new Intent(getApplicationContext(), ContactUsActivity.class);
                startActivity(contact);
                break;
        }
    }
}
