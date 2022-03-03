package com.incrediblepath.architecturecomponents.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.incrediblepath.architecturecomponents.model.Post

@Database(entities = [Post::class], version = 1, exportSchema = false)
abstract class PostDatabase :RoomDatabase(){

    abstract fun postDao():PostDao


    companion object{
        @Volatile
        private var INSTANCE:PostDatabase? = null

        fun getDatabase(context:Context):PostDatabase{
            var tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }else{
                val instance = Room.databaseBuilder(context,PostDatabase::class.java,"post_database").build()
                return instance
            }
        }
    }

}