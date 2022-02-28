package com.incrediblepath.architecturecomponents

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.incrediblepath.architecturecomponents.databinding.FragmentFirstBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class FirstFragment : Fragment() {

    private val scope = CoroutineScope(CoroutineName("My Scope"))
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainJob = scope.launch {
            val job = launch {
                while (true) {
                    //ensureActive()
                    //delay(50L)
                    //yield()
                    if (isActive) {
                        Log.e("Coroutine", "running")
                    }
                }
            }
            delay(1000)
            Log.e("Coroutine", "CANCELLING")
            job.cancel()
            job.join()
            Log.e("Coroutine", "CANCELLED")


            GlobalScope.launch(Dispatchers.IO) {
                Log.e("IO",this.coroutineContext.toString())
                withContext(Dispatchers.Main){
                    Log.e("Main",this.coroutineContext.toString())
                }
            }

        }
        //for testing purposes only
        runBlocking {
            mainJob.cancel()
        }



        val binding = FragmentFirstBinding.inflate(inflater,container,false)
        binding.button2.setOnClickListener{
            findNavController().navigate(R.id.secondFragment)
        }
        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.e("Ondestroy","Destroy")
    }
}