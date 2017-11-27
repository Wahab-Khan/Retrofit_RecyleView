package com.example.khan.retrorecyleviewtest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by KHAN on 11/15/2017.
 */

public class Student {
    @SerializedName("StudentId")
    public String ID;
    @SerializedName("StudentName")
    public String name;
    @SerializedName("StudentMarks")
    public String marks;

}
