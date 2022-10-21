package com.example.sharkoongamer.splashscreen;

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class Courses_Fragment_StartStudying extends Fragment {


    private FloatingActionButton empty_box;
    private GridView gridview;
    private courseCheckAdapter adapter;
    private ArrayList<Course> allcourses ;
    private Courses_DataBase db ;
    private int test_id_checked_course=500;
    private int id_checked_course=600;
    private int test_position=500;
    private View previous_view ;
    private Button check_course ,start_chrono , pause_chrono , stop_chrono;
    public static Course checked_course_confirmed = new Course(900)  ;
    private TextView fake_text1 , fake_text2 , selected_name , textView10 , text1_empty;
    private ImageView selected_image , fake_image;
    private Dialog dialog , dialog_yes;
    public static TextView fake_text3;
    private Chronometer chronometer;
    private long lastPause;
    private boolean test_studying;
    private View view_seperate ;
    private CardView cardView;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Fragment_Course);
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        View view = localInflater.inflate(R.layout.fragment_courses__fragment__startstudying, container, false);


        db=new Courses_DataBase(getActivity());

        test_studying=false;

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        PendingIntent pi = PendingIntent.getBroadcast(getActivity(), 0,
                new Intent(getActivity(), AlertTime.class),PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pi);




        fake_text1 = (TextView) view.findViewById(R.id.fake_text1);
        fake_text2 = (TextView) view.findViewById(R.id.fake_text2);
        fake_text3 = (TextView) view.findViewById(R.id.fake_text3);
        selected_name = (TextView) view.findViewById(R.id.selected_name);
        fake_image = (ImageView) view.findViewById(R.id.fake_image);
        selected_image = (ImageView) view.findViewById(R.id.selected_image);
        cardView = (CardView) view.findViewById(R.id.cardView);

        start_chrono = (Button) view.findViewById(R.id.start_chrono);
        pause_chrono = (Button) view.findViewById(R.id.pause_chrono);
        stop_chrono = (Button) view.findViewById(R.id.stop_chrono);
        chronometer = (Chronometer) view.findViewById(R.id.chronometer2);






        start_chrono.setEnabled(false);
        pause_chrono.setEnabled(false);
        stop_chrono.setEnabled(false);

        allcourses=db.getAllCoursesForCheck();
        adapter=new courseCheckAdapter(getActivity(),R.layout.gridview_item,allcourses);



        fake_text3.setText(String.valueOf(adapter.getCount()));



        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_check_course);

        gridview = (GridView) dialog.findViewById(R.id.gridview);
        check_course = (Button) dialog.findViewById(R.id.checkcourse);
        textView10= (TextView) dialog.findViewById(R.id.textView10);
        text1_empty= (TextView) dialog.findViewById(R.id.text1_empty);
        empty_box=(FloatingActionButton) dialog.findViewById(R.id.empty_box);
        view_seperate = (View) dialog.findViewById(R.id.view);

        dialog.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;


        check_course.setEnabled(false);



        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (test_studying == true)
                    Toast.makeText(getActivity(), "Can't change course while studying", Toast.LENGTH_SHORT).show();

                else {


                    allcourses = db.getAllCoursesForCheck();
                    adapter = new courseCheckAdapter(getActivity(), R.layout.gridview_item, allcourses);
                    gridview.setAdapter(adapter);
                    adapter.notifyDataSetChanged();



                    if (adapter.getCount() == 0) {
                        textView10.animate().alpha(0.7F).setDuration(300);
                        empty_box.animate().alpha(0.7F).setDuration(300);
                        text1_empty.animate().alpha(0.7F).setDuration(300);
                        check_course.animate().alpha(0);
                        view_seperate.animate().alpha(0);
                    } else {
                        textView10.animate().alpha(0);
                        empty_box.animate().alpha(0);
                        text1_empty.animate().alpha(0);
                        check_course.animate().alpha(0.6F).setDuration(300);
                        view_seperate.animate().alpha(0.6F).setDuration(300);
                    }





                    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                            Course course = (Course) parent.getItemAtPosition(position);
                            id_checked_course = course.getCourse_id();

                            if (id_checked_course == 600)
                                check_course.animate().alpha(0.6F).setDuration(300);
                            else {
                                check_course.animate().alpha(1).setDuration(300);
                                checked_course_confirmed = (Course) parent.getItemAtPosition(position);
                                check_course.setEnabled(true);
                            }

                            ConstraintLayout layout_information = (ConstraintLayout) view.findViewById(R.id.layout_information);
                            ImageView check_border = (ImageView) view.findViewById(R.id.check_border);
                            ImageView course_image_grid = (ImageView) view.findViewById(R.id.course_image_grid);
                            TextView course_name_grid = (TextView) view.findViewById(R.id.course_name_grid);

                            if (test_id_checked_course != id_checked_course && test_position != position) {
                                course_image_grid.animate().alpha(0).setDuration(300);
                                course_name_grid.animate().alpha(0).setDuration(300);
                                check_border.animate().alpha(1).setDuration(200).setStartDelay(100);
                                layout_information.animate().alpha(1).setDuration(500).setStartDelay(100);

                                if (test_position != 500)

                                {

                                    View previous_view_checked = previous_view;

                                    ConstraintLayout previous_layout_information = (ConstraintLayout) previous_view_checked.findViewById(R.id.layout_information);
                                    ImageView previous_check_border = (ImageView) previous_view_checked.findViewById(R.id.check_border);
                                    ImageView previous_course_image_grid = (ImageView) previous_view_checked.findViewById(R.id.course_image_grid);
                                    TextView previous_course_name_grid = (TextView) previous_view_checked.findViewById(R.id.course_name_grid);

                                    previous_course_image_grid.animate().alpha(1).setDuration(400).setStartDelay(100);
                                    previous_course_name_grid.animate().alpha(1).setDuration(400).setStartDelay(100);
                                    previous_check_border.animate().alpha(0).setDuration(200);
                                    previous_layout_information.animate().alpha(0).setDuration(200);

                                }


                                previous_view = view;
                                test_position = position;
                                test_id_checked_course = id_checked_course;


                            } else if (test_id_checked_course == id_checked_course) {
                                course_image_grid.animate().alpha(1).setDuration(400).setStartDelay(100);
                                course_name_grid.animate().alpha(1).setDuration(400).setStartDelay(100);
                                check_border.animate().alpha(0).setDuration(200);
                                layout_information.animate().alpha(0).setDuration(200);

                                test_id_checked_course = 500;
                                test_position = 500;
                                id_checked_course = 600;

                                if (id_checked_course == 600) {
                                    check_course.animate().alpha(0.6F).setDuration(300);
                                    check_course.setEnabled(false);
                                }

                            }

                        }
                    });


                    check_course.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            fake_image.animate().alpha(0).setDuration(400);
                            fake_text1.animate().alpha(0).setDuration(400);
                            fake_text2.animate().alpha(0).setDuration(400);
                            fake_text3.animate().alpha(0).setDuration(400);

                            Bitmap bitmap = BitmapFactory.decodeByteArray(checked_course_confirmed.getCourse_image(), 0, checked_course_confirmed.getCourse_image().length);
                            selected_image.setImageBitmap(bitmap);
                            selected_name.setText(checked_course_confirmed.getCourse_name());

                            if (checked_course_confirmed.getCourse_name().length() > 10)
                                selected_name.setTextSize(16);

                            selected_name.animate().alpha(1).setDuration(400).setStartDelay(200);
                            selected_image.animate().alpha(1).setDuration(400).setStartDelay(200);

                            start_chrono.setEnabled(true);
                            start_chrono.animate().alpha(1).setDuration(400);

                            check_course.animate().alpha(0.6F).setDuration(300);
                            check_course.setEnabled(false);

                            test_id_checked_course = 500;
                            id_checked_course = 600;
                            test_position = 500;

                            dialog.dismiss();

                        }
                    });

                    dialog.show();

                }

            }
        });


        start_chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                test_studying=true;

                if (lastPause != 0){
                    chronometer.setBase(chronometer.getBase() + SystemClock.elapsedRealtime() - lastPause);
                }
                else{
                    chronometer.setBase(SystemClock.elapsedRealtime());
                }

                chronometer.start();
                start_chrono.setEnabled(false);
                start_chrono.animate().alpha(0.5F).setDuration(400);

                pause_chrono.setEnabled(true);
                pause_chrono.animate().alpha(1).setDuration(400);

                stop_chrono.setEnabled(true);
                stop_chrono.animate().alpha(1).setDuration(400);
            }
        });

        pause_chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lastPause = SystemClock.elapsedRealtime();
                chronometer.stop();
                pause_chrono.setEnabled(false);
                pause_chrono.animate().alpha(0.5F).setDuration(400);

                stop_chrono.setEnabled(false);
                stop_chrono.animate().alpha(0.5F).setDuration(400);

                start_chrono.setEnabled(true);
                start_chrono.animate().alpha(1).setDuration(400);

                start_chrono.setText("Resume\nstudying");



            }
        });

        stop_chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int elapsedMillis = (int) ((SystemClock.elapsedRealtime() - chronometer.getBase())/1000);

                Course course = new Course(checked_course_confirmed.getCourse_id(),elapsedMillis/3600,(elapsedMillis/60)-((elapsedMillis/3600)*60) );
                db.update_course_studied_time(course);

                test_studying=false;




                if (((checked_course_confirmed.getCourse_houres_should_study()*60+checked_course_confirmed.getCourse_minutes_should_study())<= (db.getCourseById(checked_course_confirmed.getCourse_id()).getCourse_hours_for_today()*60+db.getCourseById(checked_course_confirmed.getCourse_id()).getCourse_mins_for_today() ))) {
                    dialog_yes = new Dialog(getActivity());
                    dialog_yes.setContentView(R.layout.yaaaaaaaaay);

                    TextView yay_course_name = (TextView) dialog_yes.findViewById(R.id.yay_course_name);
                    TextView houres_for_checked_course = (TextView) dialog_yes.findViewById(R.id.houres_for_checked_course);
                    TextView minutes_for_checked_course = (TextView) dialog_yes.findViewById(R.id.minutes_for_checked_course);
                    TextView houres_you_studied_now = (TextView) dialog_yes.findViewById(R.id.houres_you_studied_now);
                    TextView minutes_you_studied_now = (TextView) dialog_yes.findViewById(R.id.minutes_you_studied_now);
                    Button yessss = (Button) dialog_yes.findViewById(R.id.button);

                    yay_course_name.setText(checked_course_confirmed.getCourse_name());
                    houres_for_checked_course.setText(String.valueOf(checked_course_confirmed.getCourse_houres_should_study()));
                    minutes_for_checked_course.setText(String.valueOf(checked_course_confirmed.getCourse_minutes_should_study()));
                    houres_you_studied_now.setText(String.valueOf(db.getCourseById(checked_course_confirmed.getCourse_id()).getCourse_hours_for_today()));
                    minutes_you_studied_now.setText(String.valueOf(db.getCourseById(checked_course_confirmed.getCourse_id()).getCourse_mins_for_today()));

                    yessss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog_yes.dismiss();
                        }
                    });

                    dialog_yes.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog_yes.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;

                    dialog_yes.show();
                }
                else
                {
                    dialog_yes = new Dialog(getActivity());
                    dialog_yes.setContentView(R.layout.nooooooooo);

                    TextView yay_course_name = (TextView) dialog_yes.findViewById(R.id.yay_course_name);
                    TextView houres_for_checked_course = (TextView) dialog_yes.findViewById(R.id.houres_for_checked_course);
                    TextView minutes_for_checked_course = (TextView) dialog_yes.findViewById(R.id.minutes_for_checked_course);
                    TextView houres_you_studied_now = (TextView) dialog_yes.findViewById(R.id.houres_you_studied_now);
                    TextView minutes_you_studied_now = (TextView) dialog_yes.findViewById(R.id.minutes_you_studied_now);
                    Button yessss = (Button) dialog_yes.findViewById(R.id.button);

                    yay_course_name.setText(checked_course_confirmed.getCourse_name());
                    houres_for_checked_course.setText(String.valueOf(checked_course_confirmed.getCourse_houres_should_study()));
                    minutes_for_checked_course.setText(String.valueOf(checked_course_confirmed.getCourse_minutes_should_study()));
                    houres_you_studied_now.setText(String.valueOf(db.getCourseById(checked_course_confirmed.getCourse_id()).getCourse_hours_for_today()));
                    minutes_you_studied_now.setText(String.valueOf(db.getCourseById(checked_course_confirmed.getCourse_id()).getCourse_mins_for_today()));

                    yessss.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog_yes.dismiss();
                        }
                    });

                    dialog_yes.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog_yes.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;

                    dialog_yes.show();
                }



                chronometer.stop();
                chronometer.setBase(SystemClock.elapsedRealtime());
                lastPause = 0;
                start_chrono.setEnabled(true);
                start_chrono.animate().alpha(1).setDuration(400);

                pause_chrono.setEnabled(false);
                pause_chrono.animate().alpha(0.5F).setDuration(400);

                stop_chrono.setEnabled(false);
                stop_chrono.animate().alpha(0.5F).setDuration(400);

                start_chrono.setText("Start\nstudying");


            }
        });



        return view;

    }






}
