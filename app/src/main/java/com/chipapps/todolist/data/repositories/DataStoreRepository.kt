package com.chipapps.todolist.data.repositories

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.chipapps.todolist.data.models.Priority
import com.chipapps.todolist.util.Constants.PREF_KEY
import com.chipapps.todolist.util.Constants.PREF_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PREF_NAME)

class DataStoreRepository @Inject constructor(
    @ApplicationContext private val context: Context
){
    private object PreferenceKeys{
        val sortKey = stringPreferencesKey(name = PREF_KEY)
    }

    private val dataStore = context.dataStore

    suspend fun persistSortState(priority: Priority){
        dataStore.edit { preference ->
            preference[PreferenceKeys.sortKey] = priority.name
        }
    }

    val readSortState: Flow<String> = dataStore.data
        .catch {
            if (it is IOException){
                emit(emptyPreferences())
            }else{
                throw it
            }
        }.map {
            val sortState = it[PreferenceKeys.sortKey] ?: Priority.NONE.name
            sortState
        }
}