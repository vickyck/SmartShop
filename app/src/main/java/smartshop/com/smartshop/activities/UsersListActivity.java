package smartshop.com.smartshop.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import smartshop.com.smartshop.R;
import smartshop.com.smartshop.adapters.UsersRecyclerAdapter;
import smartshop.com.smartshop.model.User;
import smartshop.com.smartshop.sql.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UsersListActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener {

    private AppCompatActivity activity = UsersListActivity.this;
    private AppCompatTextView textViewName;
    private AppCompatButton appCompatButtonSignout;
    private RecyclerView recyclerViewUsers;
    private TextToSpeech speechEngine;
    private List<User> listUsers;
    private UsersRecyclerAdapter usersRecyclerAdapter;
    private DatabaseHelper databaseHelper;
    private AppCompatButton appCompatButtonSpeak;
    private AppCompatButton appCompatButtonContactus;

    @Override
    public void onInit(int i) {

        if (i == TextToSpeech.SUCCESS) {
            //Setting speech Language
            speechEngine.setLanguage(Locale.US);
            speechEngine.setPitch(1);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        getSupportActionBar().setTitle("");
        speechEngine = new TextToSpeech(this, this);

        initViews();
        initObjects();
        initListeners();
        appCompatButtonSpeak.performClick();
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        textViewName = (AppCompatTextView) findViewById(R.id.textViewName);
        recyclerViewUsers = (RecyclerView) findViewById(R.id.recyclerViewUsers);
        appCompatButtonSignout = (AppCompatButton) findViewById(R.id.appCompatButtonSignout);
        appCompatButtonSpeak = (AppCompatButton) findViewById(R.id.appCompatButtonSpeak);
        appCompatButtonContactus = (AppCompatButton) findViewById(R.id.appCompatButtonContactus);
    }

    private void initListeners() {
        appCompatButtonSignout.setOnClickListener(this);
        appCompatButtonSpeak.setOnClickListener(this);
        appCompatButtonContactus.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        listUsers = new ArrayList<>();
        usersRecyclerAdapter = new UsersRecyclerAdapter(listUsers);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewUsers.setLayoutManager(mLayoutManager);
        recyclerViewUsers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUsers.setHasFixedSize(true);
        recyclerViewUsers.setAdapter(usersRecyclerAdapter);
        databaseHelper = new DatabaseHelper(activity);

        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText(emailFromIntent);

        getDataFromSQLite();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonSignout:
                speechEngine.speak(getString(R.string.SignoutSpeakText), TextToSpeech.QUEUE_FLUSH, null, null);
                Intent loginRegister = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(loginRegister);
                break;
            case R.id.appCompatButtonSpeak:
                speechEngine.speak(getString(R.string.HomePageWelcomeSpeakText), TextToSpeech.QUEUE_FLUSH, null, null);
                break;
            case R.id.appCompatButtonContactus:
                speechEngine.speak(getString(R.string.ContactUsSpeakText), TextToSpeech.QUEUE_FLUSH, null, null);
                Intent contact = new Intent(getApplicationContext(), ContactUsActivity.class);
                startActivity(contact);
                break;
        }
    }
    /**
     * This method is to fetch all user records from SQLite
     */
    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listUsers.clear();
                listUsers.addAll(databaseHelper.getAllUser());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                usersRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
