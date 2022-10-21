package com.example.sharkoongamer.splashscreen;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.widget.DialogTitle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Courses_DataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="courses.db";
    public static final int DATABASE_VERSION=1;
    private int previes_houres_studied;
    private int previes_minutes_studied;
    private int previous_today_houres;
    private int previous_today_mins;


    public Courses_DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_COURSES_CREATE_TABLE="CREATE TABLE courses(ID integer primary key, NAME varchar(30), HOURES integer, MINUTES integer, DIFFICULTY varchar(15), COEFFICIENT varchar(15), IMAGE blob, HOURESSTUDIED integer, MINUTESSTUDIED integer, HOURESSHOULDSTUDY integer, MINUTESSHOULDSTUDY integer, CREATIONDATE text, HOURESTODAY integer, MINUTESTODAY integer)";

        db.execSQL(SQL_COURSES_CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       final String DELETE_TABLE="DROP table courses";
       db.execSQL(DELETE_TABLE);

       onCreate(db);
    }

    public void addCourse(Course course)
    {
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("NAME",course.getCourse_name());
        values.put("HOURES",course.getCourse_houres());
        values.put("MINUTES",course.getCourse_minutes());
        values.put("DIFFICULTY",course.getCourse_difficulty());
        values.put("COEFFICIENT",course.getCourse_coefficient());
        values.put("IMAGE",course.getCourse_image());
        values.put("HOURESSTUDIED",0);
        values.put("MINUTESSTUDIED",0);
        values.put("HOURESSHOULDSTUDY",min_should_study(course.getCourse_difficulty() , course.getCourse_coefficient() , course.getCourse_houres() , course.getCourse_minutes()) / 60);
        values.put("MINUTESSHOULDSTUDY",min_should_study(course.getCourse_difficulty() , course.getCourse_coefficient() , course.getCourse_houres() , course.getCourse_minutes()) % 60);
        values.put("CREATIONDATE",get_date());
        values.put("HOURESTODAY",0);
        values.put("MINUTESTODAY",0);



        db.insert("courses",null,values);
    }

    public ArrayList<Course> getAllCourses()
    {
        ArrayList<Course> courses = new ArrayList<>();

        String SELECT_QUERY="SELECT * FROM courses";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(SELECT_QUERY,null);

        if (cursor.moveToFirst())
        {
            do{
                int id= cursor.getInt(0);
                String name = cursor.getString(1);
                int houres = cursor.getInt(2);
                int minutes = cursor.getInt(3);
                String difficulty = cursor.getString(4);
                String coefficient = cursor.getString(5);
                byte[] image = cursor.getBlob(6);


                Course course=new Course(id,name,image,houres,minutes,difficulty,coefficient);
                courses.add(course);

            }while (cursor.moveToNext());
        }


        return courses;
    }



    public Course getCourseById(int id_course)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Course course = null;
        final String QUERY ="select * from courses where id ="+id_course;
        Cursor cursor=db.rawQuery(QUERY,null);

        if (cursor.moveToFirst())
        {
            int id= cursor.getInt(0);
            String name = cursor.getString(1);
            byte[] image = cursor.getBlob(6);
            int houres_studied = cursor.getInt(7);
            int minutes_studied = cursor.getInt(8);
            int houres_chould_study = cursor.getInt(9);
            int minutes_should_study = cursor.getInt(10);
            String creation_date = cursor.getString(11);
            int houres_today = cursor.getInt(12);
            int minutes_today = cursor.getInt(13);


            course=new Course(id,name,image,houres_studied,minutes_studied,houres_chould_study,minutes_should_study,creation_date,houres_today,minutes_today);
        }


        return course;
    }



    public void update_course(Course course)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();


        values.put("NAME",course.getCourse_name());
        values.put("HOURES",course.getCourse_houres());
        values.put("MINUTES",course.getCourse_minutes());
        values.put("DIFFICULTY",course.getCourse_difficulty());
        values.put("COEFFICIENT",course.getCourse_coefficient());
        values.put("IMAGE",course.getCourse_image());

        db.update("courses",values,"id=?",new String[]{String.valueOf(course.getCourse_id())});
    }

    public void delete_course(Course course)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete("courses","id=?",new String[]{String.valueOf(course.getCourse_id())});
    }


    public void update_course_studied_time(Course course)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db2 = this.getReadableDatabase();



        ContentValues values = new ContentValues();

        Cursor cursor = db2.rawQuery("SELECT * FROM courses WHERE ID ="+course.getCourse_id() ,null);

        if (cursor.moveToFirst())
        {
            previes_houres_studied = cursor.getInt(7);
            previes_minutes_studied = cursor.getInt(8);

            previous_today_houres = cursor.getInt(12);
            previous_today_mins = cursor.getInt(13);

        }


        values.put("HOURESSTUDIED",course.getCourse_houres_studied()+previes_houres_studied);
        values.put("MINUTESSTUDIED",course.getCourse_minutes_studied()+previes_minutes_studied);

        values.put("HOURESTODAY",course.getCourse_hours_for_today()+previous_today_houres);
        values.put("MINUTESTODAY",course.getCourse_mins_for_today()+previous_today_mins);

        db.update("courses",values,"id=?",new String[]{String.valueOf(course.getCourse_id())});
    }






    public ArrayList<Course> getAllCoursesForCheck()
    {
        ArrayList<Course> courses = new ArrayList<>();

        String SELECT_QUERY="SELECT * FROM courses";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(SELECT_QUERY,null);

        if (cursor.moveToFirst())
        {
            do{
                int id= cursor.getInt(0);
                String name = cursor.getString(1);
                byte[] image = cursor.getBlob(6);
                int houres_studied = cursor.getInt(7);
                int minutes_studied = cursor.getInt(8);
                int houres_chould_study = cursor.getInt(9);
                int minutes_should_study = cursor.getInt(10);
                String creation_date = cursor.getString(11);
                int houres_today = cursor.getInt(12);
                int minutes_today = cursor.getInt(13);


                Course course=new Course(id,name,image,houres_studied,minutes_studied,houres_chould_study,minutes_should_study,creation_date,houres_today,minutes_today);
                courses.add(course);

            }while (cursor.moveToNext());
        }


        return courses;
    }




    public void update_course_time_for_today()
    {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put("HOURESTODAY",0);
        values.put("MINUTESTODAY",0);

        db.update("courses",values,null,null);
    }




    private int min_should_study(String difficulty , String coefficient , int houres , int minutes)
    {
        float for_difficulty = 0, for_coefficient = 0, total_should_study;
        int time;
        time=(houres*60)+minutes;

        switch (difficulty) {
            case "Easy":
               for_difficulty=0.03F;
                break;

            case "Medium":
                for_difficulty=0.06F;
                break;

            case "Hard":
                for_difficulty=0.09F;
                break;
        }


        switch (coefficient) {
            case "Weak":
                for_coefficient=0.03F;
                break;

            case "Average":
                for_coefficient=0.06F;
                break;

            case "Important":
                for_coefficient=0.09F;
                break;
        }

        total_should_study=time*(for_difficulty+for_coefficient);

        return (int)total_should_study;


    }



    private String get_date()
    {
        SimpleDateFormat dateFortmat = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
        Date date = new Date();
        return dateFortmat.format(date);
    }




}



