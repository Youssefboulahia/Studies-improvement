package com.example.sharkoongamer.splashscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {


    private TextView text1, text2, text3;
    private ImageView welcomepic , studymatelogo;
    private View view1, view2;
    private Animation animewelcomepic, animetext, animeview1, animeview2, animetext2 ;
    private SharedPreferences preferences ;
    private RelativeLayout firstlayout , secondlayout ;
    private Button startbutton;
    private EditText starttext ;
    private String testname ;
    private boolean test ;


    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return (test &&super.dispatchKeyEvent(event));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        testname ="";
        test=false;

        Typeface mkight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface mmedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");

        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        welcomepic = (ImageView) findViewById(R.id.welcomepic);
        studymatelogo = (ImageView) findViewById(R.id.studymatelogo);
        view1 = (View) findViewById(R.id.view1);
        view2 = (View) findViewById(R.id.view2);
        firstlayout=(RelativeLayout) findViewById(R.id.firstlayout);
        secondlayout=(RelativeLayout) findViewById(R.id.secondlayout);
        startbutton=(Button)findViewById(R.id.startbutton);
        starttext=(EditText) findViewById(R.id.starttext);


        text1.setTypeface(vidaloka);
        text2.setTypeface(mkight);
        text3.setTypeface(mmedium);

        animewelcomepic = AnimationUtils.loadAnimation(this, R.anim.animewelcomepic);
        animetext = AnimationUtils.loadAnimation(this, R.anim.animetext);
        animeview1 = AnimationUtils.loadAnimation(this, R.anim.animeview1);
        animeview2 = AnimationUtils.loadAnimation(this, R.anim.animeview2);
        animetext2 = AnimationUtils.loadAnimation(this, R.anim.animetext2);


        welcomepic.setAnimation(animewelcomepic);
        text1.setAnimation(animetext);
        text2.setAnimation(animetext);
        studymatelogo.setAnimation(animetext);
        view1.setAnimation(animeview1);
        view2.setAnimation(animeview2);
        text3.setAnimation(animetext2);


        preferences = getSharedPreferences("SaveData",MODE_PRIVATE);




        if (preferences.getString("key","").length() > 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    finish();
                }
            }, 3400);
        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    secondlayout.setAlpha(0);
                   firstlayout.animate().translationX(-1000).setDuration(900).alpha(0);
                   secondlayout.animate().translationX(0).setDuration(900).alpha(1);
                   new Handler().postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           test=true;
                       }
                   },900);

                   starttext.addTextChangedListener(new TextWatcher() {
                       @Override
                       public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                       }

                       @Override
                       public void onTextChanged(CharSequence s, int start, int before, int count) {
                           testname=s.toString();
                           if (testname.length()==0)
                               starttext.setError("Empty Field !");
                           else if (testname.length()>20)
                               starttext.setError("Too Long !");
                       }

                       @Override
                       public void afterTextChanged(Editable s) {

                       }
                   });

                }
            }, 3400);
        }

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((testname.length()>0) && (testname.length()<=20)) {
                    preferences.edit().putString("key", testname).apply();
                    Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                    finish();
                }
            }
        });

        }





        }


