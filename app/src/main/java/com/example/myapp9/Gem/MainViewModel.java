package com.example.myapp9.Gem;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapp9.Gem.Database.AppDatabase;
import com.example.myapp9.Gem.Database.TaskEntry;

import java.util.List;

/**
 *
 * Build from Udacity Lesson 8: Android Architecture Components, Url: https://classroom.udacity.com/courses/ud851
 */

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the DataBase");
        tasks = database.taskDao().loadAllTasks();
    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }
}
