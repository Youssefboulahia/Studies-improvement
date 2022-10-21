package com.example.sharkoongamer.splashscreen;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class Courses_Fragment_CoursesList extends Fragment{


private Button courseimage,addcourse,image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12,image13,image14,image15,image16,image17,image18,image19,image20,image21,image22,image23,image24,image25,image26,image27,image28,image29,image30,image31,image32,image33,image34,image35,image36;
private Dialog dialogmain,dialogphotos;
private EditText coursename,hours,minutes;
private ConstraintLayout mainlayoutaddcourse;
private Animation animehome,animecourseimage,defaultimage;
private SharedPreferences imageswitcher ;
private int theimage =R.drawable.addphotocourse, testimage;
private FloatingActionButton addbutton;
private boolean testdialogmain_course,testdialogmain_hours,testdialogmain_minutes,testdialogmain_image,testdialogmain_radiodifficulty,testdialogmain_radiocoefficient ;
private RadioGroup radiodifficulty,radiocoefficient;
private String radiobutton1,radiobutton2;
private ListView course_list ;
private Courses_DataBase db;
private  CourseAdapter courseAdapter ;
private int id_selected_course ;
private byte[] image_selected_course;
private AdapterView<?> parent_long_click;
private int position_log_click;
private int count_items;
private RelativeLayout layout_empty_course;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.Fragment_Course);
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        final View view = localInflater.inflate(R.layout.fragment_courses__fragment__courseslist, container, false);


        animehome = AnimationUtils.loadAnimation(getActivity(),R.anim.animehome);
        animecourseimage=AnimationUtils.loadAnimation(getActivity(),R.anim.course_image_anime);
        defaultimage=AnimationUtils.loadAnimation(getActivity(),R.anim.defaultimage);
        addbutton= (FloatingActionButton) view.findViewById(R.id.add_course);
        layout_empty_course=(RelativeLayout)view.findViewById(R.id.layout_empty_course);
        db=new Courses_DataBase(getActivity());



        course_list=(ListView)view.findViewById(R.id.courses_list);

        final ArrayList<Course> courses = db.getAllCourses();

        courseAdapter = new CourseAdapter(getActivity(),R.layout.course_item,courses);
        courseAdapter.notifyDataSetChanged();
        course_list.setAdapter(courseAdapter);
        courseAdapter.notifyDataSetChanged();
        count_items=course_list.getAdapter().getCount();

        Courses_Fragment_StartStudying.fake_text3.setText(String.valueOf(count_items));


        if (count_items>0)
            layout_empty_course.animate().alpha(0);
       else if (count_items==0)
            layout_empty_course.animate().alpha(1);





        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogmain = new Dialog(getActivity());
                dialogmain.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialogmain.setContentView(R.layout.dialog_add_courses);



                mainlayoutaddcourse = (ConstraintLayout) dialogmain.findViewById(R.id.mainlayoutaddcourse);
                courseimage=(Button) dialogmain.findViewById(R.id.courseimage);
                addcourse=(Button)dialogmain.findViewById(R.id.addcourse);
                coursename=(EditText)dialogmain.findViewById(R.id.coursename);
                hours=(EditText)dialogmain.findViewById(R.id.hours);
                minutes=(EditText)dialogmain.findViewById(R.id.minutes);
                radiodifficulty=(RadioGroup) dialogmain.findViewById(R.id.radiodifficulty);
                radiocoefficient=(RadioGroup) dialogmain.findViewById(R.id.radiocoefficient);



                courseimage.setBackgroundResource(theimage);
                dialogmain.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;
                courseimage.setAnimation(animecourseimage);
                dialogmain.show();

                addcourse.setAlpha(0.6F);


                addcourse.setEnabled(false);



                testdialogmain_course=false;
                testdialogmain_hours=false;
                testdialogmain_minutes=false;
                testdialogmain_image=false;
                testdialogmain_radiodifficulty=false;
                testdialogmain_radiocoefficient=false;



                courseimage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {



                        dialogphotos = new Dialog(getActivity());
                        dialogphotos.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialogphotos.setContentView(R.layout.dialog_add_photo);
                        image1 = (Button) dialogphotos.findViewById(R.id.image1);
                        image2 = (Button) dialogphotos.findViewById(R.id.image2);
                        image3 = (Button) dialogphotos.findViewById(R.id.image3);
                        image4 = (Button) dialogphotos.findViewById(R.id.image4);
                        image5 = (Button) dialogphotos.findViewById(R.id.image5);
                        image6 = (Button) dialogphotos.findViewById(R.id.image6);
                        image7 = (Button) dialogphotos.findViewById(R.id.image7);
                        image8 = (Button) dialogphotos.findViewById(R.id.image8);
                        image9 = (Button) dialogphotos.findViewById(R.id.image9);
                        image10 = (Button) dialogphotos.findViewById(R.id.image10);
                        image11 = (Button) dialogphotos.findViewById(R.id.image11);
                        image12 = (Button) dialogphotos.findViewById(R.id.image12);
                        image13 = (Button) dialogphotos.findViewById(R.id.image13);
                        image14 = (Button) dialogphotos.findViewById(R.id.image14);
                        image15 = (Button) dialogphotos.findViewById(R.id.image15);
                        image16 = (Button) dialogphotos.findViewById(R.id.image16);
                        image17 = (Button) dialogphotos.findViewById(R.id.image17);
                        image18 = (Button) dialogphotos.findViewById(R.id.image18);
                        image19 = (Button) dialogphotos.findViewById(R.id.image19);
                        image20 = (Button) dialogphotos.findViewById(R.id.image20);
                        image21 = (Button) dialogphotos.findViewById(R.id.image21);
                        image22 = (Button) dialogphotos.findViewById(R.id.image22);
                        image23 = (Button) dialogphotos.findViewById(R.id.image23);
                        image24 = (Button) dialogphotos.findViewById(R.id.image24);
                        image25 = (Button) dialogphotos.findViewById(R.id.image25);
                        image26 = (Button) dialogphotos.findViewById(R.id.image26);
                        image27 = (Button) dialogphotos.findViewById(R.id.image27);
                        image28 = (Button) dialogphotos.findViewById(R.id.image28);
                        image29 = (Button) dialogphotos.findViewById(R.id.image29);
                        image30 = (Button) dialogphotos.findViewById(R.id.image30);
                        image31 = (Button) dialogphotos.findViewById(R.id.image31);
                        image32 = (Button) dialogphotos.findViewById(R.id.image32);
                        image33 = (Button) dialogphotos.findViewById(R.id.image33);
                        image34 = (Button) dialogphotos.findViewById(R.id.image34);
                        image35 = (Button) dialogphotos.findViewById(R.id.image35);
                        image36 = (Button) dialogphotos.findViewById(R.id.image36);

                        dialogphotos.getWindow().getAttributes().windowAnimations=R.style.DialogAnimation;
                        dialogphotos.show();
                        image1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto1);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto2);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto3);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto4);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto5);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image6.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto6);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image7.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto7);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image8.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto8);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image9.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto9);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image10.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto10);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image11.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto11);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image12.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto12);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image13.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto13);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image14.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto14);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image15.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto15);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image16.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto16);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image17.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto17);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image18.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto18);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image19.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto19);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image20.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto20);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image21.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto21);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image22.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto22);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image23.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto23);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image24.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto24);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image25.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto25);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image26.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto26);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image27.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto27);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image28.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto28);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image29.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto29);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image30.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto30);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image31.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto31);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image32.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto32);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image33.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto33);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image34.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto34);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image35.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto35);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });
                        image36.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                courseimage.setBackgroundResource(R.drawable.coursephoto36);
                                testdialogmain_image=true;
                                courseimage.setAnimation(defaultimage);
                                addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                                if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                    addcourse.animate().alpha(1).setDuration(400);
                                else addcourse.animate().alpha(0.6F).setDuration(400);

                                dialogphotos.dismiss();
                            }
                        });



                    }
                });



                coursename.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {


                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                     if (s.length()==0)
                     {coursename.setError("Field is empty");
                         testdialogmain_course=false;}

                        if (s.length()>20)
                        {coursename.setError("Too long");
                            testdialogmain_course=false;}

                     else if(s.length()>0 && s.length()<21)
                        {testdialogmain_course=true;}

                        addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                        if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                            addcourse.animate().alpha(1).setDuration(400);
                        else addcourse.animate().alpha(0.6F).setDuration(400);





                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                hours.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                        if (s.length()==0 )
                        {hours.setError("Field is empty");
                            testdialogmain_hours=false;}
                        else if(s.length()>0 )
                        {testdialogmain_hours=true;}

                        addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                        if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                            addcourse.animate().alpha(1).setDuration(400);
                        else addcourse.animate().alpha(0.6F).setDuration(400);

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                minutes.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                        if (s.length()==0)
                        {minutes.setError("Field is empty");
                            testdialogmain_minutes=false;}
                       else if(s.length()>0)
                        {testdialogmain_minutes=true;}

                        if (s.length()>0) {
                            if (Integer.parseInt(s.toString()) > 59) {
                                minutes.setError("Don't surpass 59");
                                testdialogmain_minutes = false;
                            } else if (Integer.parseInt(s.toString()) < 60) {
                                testdialogmain_minutes = true;
                            }
                        }

                        addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                        if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                            addcourse.animate().alpha(1).setDuration(400);
                        else addcourse.animate().alpha(0.6F).setDuration(400);


                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

                radiodifficulty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if ((checkedId==R.id.easy) || (checkedId==R.id.medium) || (checkedId==R.id.hard))
                        testdialogmain_radiodifficulty=true;

                        if (checkedId==R.id.easy)
                            radiobutton1="Easy";
                        else if (checkedId==R.id.medium)
                            radiobutton1="Medium";
                        else if(checkedId==R.id.hard)
                        radiobutton1="Hard";

                            addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                        if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                            addcourse.animate().alpha(1).setDuration(400);
                        else addcourse.animate().alpha(0.6F).setDuration(400);

                    }
                });

                radiocoefficient.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if ((checkedId==R.id.weak) || (checkedId==R.id.average) || (checkedId==R.id.important))
                        testdialogmain_radiocoefficient=true;

                        if (checkedId==R.id.weak)
                            radiobutton2="Weak";
                        else if (checkedId==R.id.average)
                            radiobutton2="Average";
                        else if(checkedId==R.id.important)
                            radiobutton2="Important";

                            addcourse.setEnabled(testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true);

                        if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                            addcourse.animate().alpha(1).setDuration(400);
                        else addcourse.animate().alpha(0.6F).setDuration(400);

                    }
                });





               addcourse.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       Bitmap bitmap = ((BitmapDrawable)courseimage.getBackground()).getBitmap();

                       Course course = new Course(coursename.getText().toString(),getBytes(bitmap),Integer.parseInt(hours.getText().toString()),Integer.parseInt(minutes.getText().toString()),radiobutton1,radiobutton2);
                       db.addCourse(course);
                       courseAdapter.notifyDataSetChanged();
                       ArrayList<Course> courses = db.getAllCourses();

                       courseAdapter = new CourseAdapter(getActivity(),R.layout.course_item,courses);
                       courseAdapter.notifyDataSetChanged();
                       course_list.setAdapter(courseAdapter);
                       courseAdapter.notifyDataSetChanged();

                       count_items = course_list.getAdapter().getCount();
                       Courses_Fragment_StartStudying.fake_text3.setText(String.valueOf(count_items));
                       if (count_items>0)
                           layout_empty_course.animate().alpha(0);

                       dialogmain.dismiss();
                   }
               });


            }
        });


















            course_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                    dialogmain = new Dialog(getActivity());
                    dialogmain.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialogmain.setContentView(R.layout.dialog_add_courses);





                    mainlayoutaddcourse = (ConstraintLayout) dialogmain.findViewById(R.id.mainlayoutaddcourse);
                    courseimage = (Button) dialogmain.findViewById(R.id.courseimage);
                    addcourse = (Button) dialogmain.findViewById(R.id.addcourse);
                    coursename = (EditText) dialogmain.findViewById(R.id.coursename);
                    hours = (EditText) dialogmain.findViewById(R.id.hours);
                    minutes = (EditText) dialogmain.findViewById(R.id.minutes);
                    radiodifficulty = (RadioGroup) dialogmain.findViewById(R.id.radiodifficulty);
                    radiocoefficient = (RadioGroup) dialogmain.findViewById(R.id.radiocoefficient);



                    addcourse.setEnabled(true);
                    testdialogmain_course = true;
                    testdialogmain_hours = true;
                    testdialogmain_minutes = true;
                    testdialogmain_image = true;
                    testdialogmain_radiodifficulty = true;
                    testdialogmain_radiocoefficient = true;


                    Course selected_course = (Course) parent.getItemAtPosition(position);
                    id_selected_course = selected_course.getCourse_id();
                    image_selected_course = selected_course.getCourse_image();


                    dialogmain.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;


                    Bitmap bitmap = BitmapFactory.decodeByteArray(image_selected_course, 0, image_selected_course.length);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
                    courseimage.setBackground(bitmapDrawable);


                    coursename.setText(selected_course.getCourse_name());
                    hours.setText(String.valueOf(selected_course.getCourse_houres()));
                    minutes.setText(String.valueOf(selected_course.getCourse_minutes()));
                    addcourse.setText("UPDATE");

                    switch (selected_course.getCourse_difficulty()) {
                        case "Easy":
                            radiodifficulty.check(R.id.easy);
                            radiobutton1="Easy";
                            break;

                        case "Medium":
                            radiodifficulty.check(R.id.medium);
                            radiobutton1="Medium";
                            break;

                        case "Hard":
                            radiodifficulty.check(R.id.hard);
                            radiobutton1="Hard";
                            break;
                    }


                    switch (selected_course.getCourse_coefficient()) {
                        case "Weak":
                            radiocoefficient.check(R.id.weak);
                            radiobutton2="Weak";
                            break;

                        case "Average":
                            radiocoefficient.check(R.id.average);
                            radiobutton2="Average";
                            break;

                        case "Important":
                            radiocoefficient.check(R.id.important);
                            radiobutton2="Important";
                            break;
                    }

                    dialogmain.show();


                    courseimage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            dialogphotos = new Dialog(getActivity());
                            dialogphotos.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            dialogphotos.setContentView(R.layout.dialog_add_photo);
                            image1 = (Button) dialogphotos.findViewById(R.id.image1);
                            image2 = (Button) dialogphotos.findViewById(R.id.image2);
                            image3 = (Button) dialogphotos.findViewById(R.id.image3);
                            image4 = (Button) dialogphotos.findViewById(R.id.image4);
                            image5 = (Button) dialogphotos.findViewById(R.id.image5);
                            image6 = (Button) dialogphotos.findViewById(R.id.image6);
                            image7 = (Button) dialogphotos.findViewById(R.id.image7);
                            image8 = (Button) dialogphotos.findViewById(R.id.image8);
                            image9 = (Button) dialogphotos.findViewById(R.id.image9);
                            image10 = (Button) dialogphotos.findViewById(R.id.image10);
                            image11 = (Button) dialogphotos.findViewById(R.id.image11);
                            image12 = (Button) dialogphotos.findViewById(R.id.image12);
                            image13 = (Button) dialogphotos.findViewById(R.id.image13);
                            image14 = (Button) dialogphotos.findViewById(R.id.image14);
                            image15 = (Button) dialogphotos.findViewById(R.id.image15);
                            image16 = (Button) dialogphotos.findViewById(R.id.image16);
                            image17 = (Button) dialogphotos.findViewById(R.id.image17);
                            image18 = (Button) dialogphotos.findViewById(R.id.image18);
                            image19 = (Button) dialogphotos.findViewById(R.id.image19);
                            image20 = (Button) dialogphotos.findViewById(R.id.image20);
                            image21 = (Button) dialogphotos.findViewById(R.id.image21);
                            image22 = (Button) dialogphotos.findViewById(R.id.image22);
                            image23 = (Button) dialogphotos.findViewById(R.id.image23);
                            image24 = (Button) dialogphotos.findViewById(R.id.image24);
                            image25 = (Button) dialogphotos.findViewById(R.id.image25);
                            image26 = (Button) dialogphotos.findViewById(R.id.image26);
                            image27 = (Button) dialogphotos.findViewById(R.id.image27);
                            image28 = (Button) dialogphotos.findViewById(R.id.image28);
                            image29 = (Button) dialogphotos.findViewById(R.id.image29);
                            image30 = (Button) dialogphotos.findViewById(R.id.image30);
                            image31 = (Button) dialogphotos.findViewById(R.id.image31);
                            image32 = (Button) dialogphotos.findViewById(R.id.image32);
                            image33 = (Button) dialogphotos.findViewById(R.id.image33);
                            image34 = (Button) dialogphotos.findViewById(R.id.image34);
                            image35 = (Button) dialogphotos.findViewById(R.id.image35);
                            image36 = (Button) dialogphotos.findViewById(R.id.image36);

                            dialogphotos.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
                            dialogphotos.show();
                            image1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto1);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto2);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto3);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto4);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto5);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image6.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto6);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image7.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto7);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image8.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto8);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image9.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto9);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image10.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto10);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image11.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto11);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image12.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto12);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image13.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto13);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image14.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto14);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image15.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto15);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image16.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto16);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image17.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto17);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image18.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto18);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image19.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto19);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image20.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto20);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image21.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto21);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image22.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto22);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image23.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto23);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image24.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto24);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image25.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto25);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image26.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto26);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image27.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto27);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image28.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto28);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image29.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto29);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image30.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto30);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image31.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto31);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image32.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto32);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image33.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto33);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image34.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto34);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image35.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto35);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });
                            image36.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    courseimage.setBackgroundResource(R.drawable.coursephoto36);
                                    testdialogmain_image = true;
                                    courseimage.setAnimation(defaultimage);
                                    addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                                    if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                        addcourse.animate().alpha(1).setDuration(400);
                                    else addcourse.animate().alpha(0.6F).setDuration(400);

                                    dialogphotos.dismiss();
                                }
                            });


                        }
                    });



                    coursename.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {


                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            if (s.length() == 0) {
                                coursename.setError("Field is empty");
                                testdialogmain_course = false;
                            }

                            if (s.length() > 20) {
                                coursename.setError("Too long");
                                testdialogmain_course = false;
                            } else if (s.length() > 0 && s.length() < 21) {
                                testdialogmain_course = true;
                            }

                            addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                            if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                addcourse.animate().alpha(1).setDuration(400);
                            else addcourse.animate().alpha(0.6F).setDuration(400);



                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });

                    hours.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                            if (s.length() == 0) {
                                hours.setError("Field is empty");
                                testdialogmain_hours = false;
                            } else if (s.length() > 0) {
                                testdialogmain_hours = true;
                            }

                            addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                            if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                addcourse.animate().alpha(1).setDuration(400);
                            else addcourse.animate().alpha(0.6F).setDuration(400);

                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });

                    minutes.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                            if (s.length() == 0) {
                                minutes.setError("Field is empty");
                                testdialogmain_minutes = false;
                            } else if (s.length() > 0) {
                                testdialogmain_minutes = true;
                            }

                            if (s.length() > 0) {
                                if (Integer.parseInt(s.toString()) > 59) {
                                    minutes.setError("Don't surpass 59");
                                    testdialogmain_minutes = false;
                                } else if (Integer.parseInt(s.toString()) < 60) {
                                    testdialogmain_minutes = true;
                                }
                            }

                            addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                            if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                addcourse.animate().alpha(1).setDuration(400);
                            else addcourse.animate().alpha(0.6F).setDuration(400);


                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });

                    radiodifficulty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if ((checkedId == R.id.easy) || (checkedId == R.id.medium) || (checkedId == R.id.hard))
                                testdialogmain_radiodifficulty = true;

                            if (checkedId == R.id.easy)
                                radiobutton1 = "Easy";
                            else if (checkedId == R.id.medium)
                                radiobutton1 = "Medium";
                            else if (checkedId == R.id.hard)
                                radiobutton1 = "Hard";

                            addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                            if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                addcourse.animate().alpha(1).setDuration(400);
                            else addcourse.animate().alpha(0.6F).setDuration(400);

                        }
                    });

                    radiocoefficient.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if ((checkedId == R.id.weak) || (checkedId == R.id.average) || (checkedId == R.id.important))
                                testdialogmain_radiocoefficient = true;

                            if (checkedId == R.id.weak)
                                radiobutton2 = "Weak";
                            else if (checkedId == R.id.average)
                                radiobutton2 = "Average";
                            else if (checkedId == R.id.important)
                                radiobutton2 = "Important";

                            addcourse.setEnabled(testdialogmain_course == true && testdialogmain_minutes == true && testdialogmain_hours == true && testdialogmain_image == true && testdialogmain_radiocoefficient == true && testdialogmain_radiodifficulty == true);

                            if (testdialogmain_course==true && testdialogmain_minutes==true && testdialogmain_hours==true && testdialogmain_image==true && testdialogmain_radiocoefficient==true && testdialogmain_radiodifficulty==true)
                                addcourse.animate().alpha(1).setDuration(400);
                            else addcourse.animate().alpha(0.6F).setDuration(400);

                        }
                    });


                    addcourse.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Bitmap bitmap = ((BitmapDrawable) courseimage.getBackground()).getBitmap();

                            Course course = new Course(id_selected_course, coursename.getText().toString(), getBytes(bitmap), Integer.parseInt(hours.getText().toString()), Integer.parseInt(minutes.getText().toString()), radiobutton1, radiobutton2);
                            db.update_course(course);


                            courseAdapter.notifyDataSetChanged();
                            ArrayList<Course> courses = db.getAllCourses();
                            courseAdapter = new CourseAdapter(getActivity(), R.layout.course_item, courses);
                            courseAdapter.notifyDataSetChanged();
                            course_list.setAdapter(courseAdapter);
                            courseAdapter.notifyDataSetChanged();
                            dialogmain.dismiss();
                        }
                    });


                }
            });










        course_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {


                parent_long_click=parent;
                position_log_click=position;

                Course course_clicked = (Course) parent.getItemAtPosition(position);

                if (course_clicked.getCourse_id()==Courses_Fragment_StartStudying.checked_course_confirmed.getCourse_id())
                    Toast.makeText(getActivity(),"This course is selected in START section",Toast.LENGTH_SHORT).show();
                else {

                    AlertDialog.Builder alertdialog = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.Fragment_Course));
                    alertdialog.setTitle("Confirmation")
                            .setMessage("Do you really want to delete this course")
                            .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Course selected_course = (Course) parent_long_click.getItemAtPosition(position_log_click);

                                    db.delete_course(selected_course);
                                    courseAdapter.notifyDataSetChanged();
                                    ArrayList<Course> courses = db.getAllCourses();
                                    courseAdapter = new CourseAdapter(getActivity(), R.layout.course_item, courses);
                                    courseAdapter.notifyDataSetChanged();
                                    course_list.setAdapter(courseAdapter);
                                    courseAdapter.notifyDataSetChanged();

                                    count_items = course_list.getAdapter().getCount();
                                    Courses_Fragment_StartStudying.fake_text3.setText(String.valueOf(count_items));

                                    if (count_items == 0)
                                        layout_empty_course.animate().alpha(1).setDuration(600);

                                    dialog.dismiss();
                                }
                            })
                            .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    dialog.dismiss();

                                }
                            });

                    AlertDialog dialog = alertdialog.create();
                    dialog.show();
                }




                return true;
            }
        });





        return view;
    }


    public static byte[] getBytes(Bitmap bitmap)
    {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,0,stream);
        return stream.toByteArray();
    }

}
