package com.example.myapp9.Gem.Database;

import androidx.room.TypeConverter;

import java.util.Date;

/**
 *
 * Build from Udacity Lesson 8: Android Architecture Components, Url: https://classroom.udacity.com/courses/ud851
 */

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
