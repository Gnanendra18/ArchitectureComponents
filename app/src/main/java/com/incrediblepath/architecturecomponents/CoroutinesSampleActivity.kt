package com.incrediblepath.architecturecomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.incrediblepath.architecturecomponents.databinding.ActivityCoroutinesSampleBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CoroutinesSampleActivity : AppCompatActivity() {

    private  val scope = CoroutineScope(CoroutineName("OwnScope"))
    private  val scopeWithDispatcher = CoroutineScope(Dispatchers.IO + CoroutineName("OwnScope"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCoroutinesSampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //synchronously running --> Sequentially running
        //Asynchronous --> independent to each other
        //Main IO and defailt
        //Main --> for UI code or non blocking code that executes fast
        //IO --> for network and disk operations
        //Default --> CPU Intensive operations, bigger computations
        //launch is builder method present inside

        task1()



        //task1()
        //lives in entire Application level even activity or fragment destroyed
        GlobalScope.launch{
            task3()
        }

        scope.launch {
            Log.e("Scope Context", this.coroutineContext.toString())
            launch {
                Log.e("Scope Context", this.coroutineContext.toString())
            }
        }

        //job.cancelAndJoin()

        runBlocking {

        }


    }

    fun task1(){
        print("Hello")
    }
    suspend fun task3(){
        print("Hello")
    }

    suspend fun task2(){
        withContext(Dispatchers.IO){
            delay(1000)
            print("World")
        }

    }

    override fun onNavigateUp(): Boolean {
        return super.onNavigateUp()
    }
}