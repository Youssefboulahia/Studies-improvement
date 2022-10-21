package com.example.sharkoongamer.splashscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;

public class LoginActivity extends AppIntro {


    @Override
    public void onSkipPressed() {
        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onDonePressed() {
        Intent intent = new Intent(LoginActivity.this , MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SliderPage sliderPage1 = new SliderPage();
        sliderPage1.setTitle("MY COURSES");
        sliderPage1.setDescription("Here you can ada new courses and check everything daily Here you can add what you want to do later and we remind you");
        sliderPage1.setImageDrawable(R.drawable.courses);
        sliderPage1.setBgColor(Color.parseColor("#21618C")) ;
        addSlide(AppIntroFragment.newInstance(sliderPage1));

        SliderPage sliderPage2 = new SliderPage();
        sliderPage2.setTitle("MY STATS");
        sliderPage2.setDescription("Here you can check your stats and progress daily Here you can add what you want to do later and we remind you");
        sliderPage2.setImageDrawable(R.drawable.analytics);
        sliderPage2.setBgColor(Color.parseColor("#943126")) ;
        addSlide(AppIntroFragment.newInstance(sliderPage2));

        SliderPage sliderPage3 = new SliderPage();
        sliderPage3.setTitle("MY TODO LIST");
        sliderPage3.setDescription("Here you can add what you want to do later and we remind you Here you can add what you want to do later and we remind you");
        sliderPage3.setImageDrawable(R.drawable.todo);
        sliderPage3.setBgColor(Color.parseColor("#633974")) ;
        addSlide(AppIntroFragment.newInstance(sliderPage3));

        SliderPage sliderPage4 = new SliderPage();
        sliderPage4.setTitle("MY QUOTES ");
        sliderPage4.setDescription("Here you can ada new courses and check everything daily Here you can add what you want to do later and we remind you");
        sliderPage4.setImageDrawable(R.drawable.quote);
        sliderPage4.setBgColor(Color.parseColor("#117864")) ;
        addSlide(AppIntroFragment.newInstance(sliderPage4));






        showSkipButton(true);
        showStatusBar(false);
        setSeparatorColor(Color.parseColor("#633974"));
        setBarColor(Color.parseColor("#544b4b4b"));






    }
}
