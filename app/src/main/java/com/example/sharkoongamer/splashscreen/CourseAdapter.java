package com.example.sharkoongamer.splashscreen;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CourseAdapter extends ArrayAdapter<Course> {


    private Context context;
    private int resource;

    public CourseAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;

        notifyDataSetChanged();
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        convertView=LayoutInflater.from(context).inflate(resource,parent,false);

        TextView course_name = (TextView) convertView.findViewById(R.id.course_name);
        ImageView course_image = (ImageView) convertView.findViewById(R.id.course_image) ;
        TextView course_houres = (TextView) convertView.findViewById(R.id.course_houres);
        TextView course_minutes = (TextView) convertView.findViewById(R.id.course_minutes);
        TextView course_difficulty = (TextView) convertView.findViewById(R.id.course_difficulty);
        TextView course_coefficient = (TextView) convertView.findViewById(R.id.course_coefficient);
        LinearLayout layout_image_1 =(LinearLayout) convertView.findViewById(R.id.layout_image_1);
        LinearLayout layout_data_2 =(LinearLayout) convertView.findViewById(R.id.layout_data_2);

        Animation fade = AnimationUtils.loadAnimation(getContext(),R.anim.affiche_course_fade_in);


        Course currentCourse = getItem(position);

        if (currentCourse.getCourse_name().length()>14)
            course_name.setTextSize(15);

        course_name.setText(currentCourse.getCourse_name());
        course_houres.setText(String.valueOf(currentCourse.getCourse_houres()));
        course_minutes.setText(String.valueOf(currentCourse.getCourse_minutes()));
        course_difficulty.setText(currentCourse.getCourse_difficulty());
        course_coefficient.setText(currentCourse.getCourse_coefficient());


        Bitmap bitmap = BitmapFactory.decodeByteArray(currentCourse.getCourse_image(),0,currentCourse.getCourse_image().length);
        course_image.setImageBitmap(bitmap);


        layout_image_1.setAnimation(fade);
        layout_data_2.setAnimation(fade);

        return (convertView);
    }
}
