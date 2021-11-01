package com.chipapps.todolist.di

import android.content.Context
import androidx.room.Room
import com.chipapps.todolist.data.ToDoDatabase
import com.chipapps.todolist.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Describe how we provide instances of each type which we will inject later
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    //We don't own Room library so we need to create a module

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: ToDoDatabase) = database.toDoDao()

}