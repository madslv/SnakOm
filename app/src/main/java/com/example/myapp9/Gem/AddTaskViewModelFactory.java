package com.example.myapp9.Gem;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapp9.Gem.Database.AppDatabase;

/**
 *
 * Build from Udacity Lesson 8: Android Architecture Components, Url: https://classroom.udacity.com/courses/ud851
 */

public class AddTaskViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final AppDatabase mDb;
    private final int mTaskId;

    public AddTaskViewModelFactory(AppDatabase database, int taskId) {
        mDb = database;
        mTaskId = taskId;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new AddTaskViewModel(mDb, mTaskId);
    }
}
