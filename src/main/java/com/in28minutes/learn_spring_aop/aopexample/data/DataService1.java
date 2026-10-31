package com.in28minutes.learn_spring_aop.aopexample.data;

import com.in28minutes.learn_spring_aop.aopexample.annotations.TrackTime;
import org.springframework.stereotype.Component;

@Component
public class DataService1 {

    @TrackTime
    public int[] retrieveData() {

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new int[] {11, 22, 33, 44, 55};
    }
}
