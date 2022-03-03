package com.incrediblepath.architecturecomponents.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.incrediblepath.architecturecomponents.model.Post


//Dao is used for accessing database : data access object
//for every table we create an interface with Dao annotation
//base on requirement we add
@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPost(post: Post)

    @Query("SELECT * FROM posts_table ORDER BY id ASC")
    fun retrievePosts():LiveData<List<Post>>

    @Update
    suspend fun updatePost(post: Post)

    @Delete
    suspend fun deletePost(post: Post)

}