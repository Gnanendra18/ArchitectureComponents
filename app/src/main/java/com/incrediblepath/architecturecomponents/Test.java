package com.incrediblepath.architecturecomponents;

import android.os.CountDownTimer;

public class Test {

    void test(){
       CountDownTimer timer = new CountDownTimer(10000, 1000) {
           @Override
           public void onTick(long l) {

           }

           @Override
           public void onFinish() {

           }
       };
    }
}
