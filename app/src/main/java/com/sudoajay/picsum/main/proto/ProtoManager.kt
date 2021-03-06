package com.sudoajay.picsum.main.proto

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.sudoajay.picsum.R
import com.sudoajay.picsum.StatePreferences
import javax.inject.Inject

class ProtoManager @Inject constructor (var context: Context){
    val dataStoreStatePreferences : DataStore<StatePreferences> = context.stateDataStore
    suspend fun setDefaultValue(){
        dataStoreStatePreferences.updateData { preferences->
            preferences.toBuilder()
                .setDatabase(context.getString(R.string.no_dataBase_text))
                .setJsonConverter(context.getString(R.string.jacksonJson_text))
                .setImageLoader(context.getString(R.string.glide_text))
                .build()
        }
    }

    suspend fun setDataBase(database: String) {
        dataStoreStatePreferences.updateData { preferences ->
            preferences.toBuilder()
                .setDatabase(database)
                .build()
        }
    }

    suspend fun setJsonConverter(jsonConverter: String)  {
        dataStoreStatePreferences.updateData { preferences ->
            preferences.toBuilder()
                .setJsonConverter(jsonConverter)
                .build()
        }
    }

    suspend fun setImageLoader(imageLoader:String){
        dataStoreStatePreferences.updateData { preferences ->
            preferences.toBuilder()
                .setImageLoader(imageLoader)
                .build()
        }
    }



    companion object {
        private const val DATA_STORE_FILE_NAME = "state_prefs.pb"

        private val Context.stateDataStore: DataStore<StatePreferences> by dataStore(
            fileName = DATA_STORE_FILE_NAME,
            serializer = StatePreferencesSerializer
        )

    }

}





