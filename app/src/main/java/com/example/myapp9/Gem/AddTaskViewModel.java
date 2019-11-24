package com.example.myapp9.Gem;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapp9.Gem.Database.AppDatabase;
import com.example.myapp9.Gem.Database.TaskEntry;

/**
 *
 * Build from Udacity Lesson 8: Android Architecture Components, Url: https://classroom.udacity.com/courses/ud851
 */

public class AddTaskViewModel extends ViewModel {

    private LiveData<TaskEntry> task;

    public AddTaskViewModel(AppDatabase database, int taskId) {
        task = database.taskDao().loadTaskById(taskId);
    }

    public LiveData<TaskEntry> getTask() {
        return task;
    }
}
