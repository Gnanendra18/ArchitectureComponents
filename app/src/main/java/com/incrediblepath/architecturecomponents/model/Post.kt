package com.incrediblepath.architecturecomponents.model

import androidx.room.Entity
import androidx.room.PrimaryKey


//Entity annotation creates new table in database with specified table name

@Entity(tableName = "posts_table")
data class Post(
    val userId:Int,
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title:String,
    val body:String
    )
