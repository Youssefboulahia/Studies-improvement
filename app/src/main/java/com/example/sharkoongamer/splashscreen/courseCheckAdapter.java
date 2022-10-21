package com.example.sharkoongamer.splashscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class courseCheckAdapter extends ArrayAdapter<Course> {



    private Context context ;
    private int resource ;



    public courseCheckAdapter(Context context, int resource , List<Course> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
    }


    @Override
    public View getView(int position , View convertView , ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(resource,parent,false);

        TextView course_name = (TextView) convertView.findViewById(R.id.course_name_grid);
        ImageView course_image = (ImageView) convertView.findViewById(R.id.course_image_grid);
        TextView houres_you_studied = (TextView) convertView.findViewById(R.id.houres_you_studied);
        TextView minutes_you_studied = (TextView) convertView.findViewById(R.id.minutes_you_studied);
        TextView houres_should_study = (TextView) convertView.findViewById(R.id.houres_should_study);
        TextView minutes_should_study = (TextView) convertView.findViewById(R.id.minutes_should_study);
        TextView creation_date = (TextView) convertView.findViewById(R.id.creation_date);
        CardView cardview = (CardView) convertView.findViewById(R.id.cardview_main);

        Animation fade = AnimationUtils.loadAnimation(getContext(),R.anim.affiche_course_fade_in);

        Course currentCourse = getItem(position);

        course_name.setText(currentCourse.getCourse_name());

        Bitmap bitmap = BitmapFactory.decodeByteArray(currentCourse.getCourse_image(),0,currentCourse.getCourse_image().length);
        course_image.setImageBitmap(bitmap);

        houres_you_studied.setText(String.valueOf(currentCourse.getCourse_houres_studied()));
        minutes_you_studied.setText(String.valueOf(currentCourse.getCourse_minutes_studied()));
        houres_should_study.setText(String.valueOf(currentCourse.getCourse_houres_should_study()));
        minutes_should_study.setText(String.valueOf(currentCourse.getCourse_minutes_should_study()));
        creation_date.setText(currentCourse.getCreation_date());

        if (currentCourse.getCourse_name().length()>10)
            course_name.setTextSize(16);





        return convertView ;
    }
}
