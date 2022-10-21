package com.example.sharkoongamer.splashscreen;

public class Course {
    private int course_id;
    private String course_name;
    private byte [] course_image ;
    private int course_houres;
    private int course_minutes;
    private String course_difficulty;
    private String course_coefficient;

    private int course_houres_studied;
    private int course_minutes_studied;
    private int course_houres_should_study;
    private int course_minutes_should_study;
    private String creation_date;
    private int course_hours_for_today;
    private int course_mins_for_today;



    public Course(int id ,String course_name , byte[] course_image , int course_houres_studied , int course_minutes_studied, int course_houres_should_study, int course_minutes_should_study,String creation_date,int course_hours_for_today, int course_mins_for_today ){
        this.course_id=id;
        this.course_name=course_name;
        this.course_image=course_image;
        this.course_houres_studied=course_houres_studied;
        this.course_minutes_studied=course_minutes_studied;
        this.course_houres_should_study=course_houres_should_study;
        this.course_minutes_should_study=course_minutes_should_study;
        this.creation_date=creation_date;
        this.course_hours_for_today=course_hours_for_today;
        this.course_mins_for_today=course_mins_for_today;
    }



    public Course(int course_id, int course_houres_studied, int course_minutes_studied )
    {
        this.course_id=course_id;
        this.course_houres_studied=course_houres_studied;
        this.course_minutes_studied=course_minutes_studied;
        this.course_hours_for_today=course_houres_studied;
        this.course_mins_for_today=course_minutes_studied;
    }

    public Course (int course_id)
    {
        this.course_id=course_id;
    }

    public Course(int course_id,String course_name,byte[] course_image,int course_houres, int course_minutes, String course_difficulty, String corfficient) {

        this.course_id = course_id ;
        this.course_name = course_name;
        this.course_image=course_image;
        this.course_houres = course_houres;
        this.course_minutes = course_minutes;
        this.course_difficulty = course_difficulty;
        this.course_coefficient = corfficient;
    }


    public Course(String course_name,byte[] course_image,int course_houres, int course_minutes, String course_difficulty, String corfficient) {

        this.course_name = course_name;
        this.course_image=course_image;
        this.course_houres = course_houres;
        this.course_minutes = course_minutes;
        this.course_difficulty = course_difficulty;
        this.course_coefficient = corfficient;
    }

    public Course(int id ,String course_name , byte[] course_image , int course_houres_studied , int course_minutes_studied, int course_houres_should_study, int course_minutes_should_study,String creation_date ){
        this.course_id=id;
        this.course_name=course_name;
        this.course_image=course_image;
        this.course_houres_studied=course_houres_studied;
        this.course_minutes_studied=course_minutes_studied;
        this.course_houres_should_study=course_houres_should_study;
        this.course_minutes_should_study=course_minutes_should_study;
        this.creation_date=creation_date;
    }


    public int getCourse_hours_for_today() {
        return course_hours_for_today;
    }

    public int getCourse_mins_for_today() {
        return course_mins_for_today;
    }

    public void setCourse_hours_for_today(int course_hours_for_today) {
        this.course_hours_for_today = course_hours_for_today;
    }

    public void setCourse_mins_for_today(int course_mins_for_today) {
        this.course_mins_for_today = course_mins_for_today;
    }

    public void setCourse_houres_studied(int course_houres_studied) {
        this.course_houres_studied = course_houres_studied;
    }

    public void setCourse_minutes_studied(int course_minutes_studied) {
        this.course_minutes_studied = course_minutes_studied;
    }

    public void setCourse_houres_should_study(int course_houres_should_study) {
        this.course_houres_should_study = course_houres_should_study;
    }

    public void setCourse_minutes_should_study(int course_minutes_should_study) {
        this.course_minutes_should_study = course_minutes_should_study;
    }

    public void setCreation_date(String creation_date) {
        this.creation_date = creation_date;
    }

    public int getCourse_houres_studied() {
        return course_houres_studied;
    }

    public int getCourse_minutes_studied() {
        return course_minutes_studied;
    }

    public int getCourse_houres_should_study() {
        return course_houres_should_study;
    }

    public int getCourse_minutes_should_study() {
        return course_minutes_should_study;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public byte[] getCourse_image() {
        return course_image;
    }

    public void setCourse_image(byte[] course_image) {
        this.course_image = course_image;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setCourse_houres(int course_houres) {
        this.course_houres = course_houres;
    }

    public void setCourse_minutes(int course_minutes) {
        this.course_minutes = course_minutes;
    }

    public void setCourse_difficulty(String course_difficulty) {
        this.course_difficulty = course_difficulty;
    }

    public void setCourse_coefficient(String course_coefficient) {
        this.course_coefficient = course_coefficient;
    }

    public String getCourse_name() {

        return course_name;
    }

    public int getCourse_houres() {
        return course_houres;
    }

    public int getCourse_minutes() {
        return course_minutes;
    }

    public String getCourse_difficulty() {
        return course_difficulty;
    }

    public String getCourse_coefficient() {
        return course_coefficient;
    }


}
