package com.bacter.bacter.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;

import com.bacter.bacter.R;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import io.mahendra.calendarview.widget.CalendarView;

public class CalendarActivity extends AppCompatActivity
{
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = findViewById(R.id.cal);
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);
        calendarView.setIsOverflowDateVisible(true);
        calendarView.setCurrentDay(new Date(System.currentTimeMillis()));
        calendarView.setBackButtonColor(android.R.color.black);
        calendarView.setNextButtonColor(android.R.color.black);
     //   calendarView.setTypeface(Typeface.DEFAULT_BOLD);
        calendarView.refreshCalendar(Calendar.getInstance(Locale.getDefault()));

        calendarView.setOnDateLongClickListener(new CalendarView.OnDateLongClickListener() {
            @Override
            public void onDateLongClick(@NonNull Date selectedDate) {
            }
        });
        calendarView.setOnMonthChangedListener(new CalendarView.OnMonthChangedListener() {
            @Override
            public void onMonthChanged(@NonNull Date monthDate) {
            }
        });
        calendarView.setOnDateClickListener(new CalendarView.OnDateClickListener() {
            @Override
            public void onDateClick(@NonNull Date selectedDate) {

            }
        });
        calendarView.setOnMonthTitleClickListener(new CalendarView.OnMonthTitleClickListener() {
            @Override
            public void onMonthTitleClick(@NonNull Date monthDate) {
            }
        });
    }
}