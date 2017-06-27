package com.maslick.test;

import com.maslick.test.ifaces.IObserver;

/**
 * Created by maslick on 27.6.2017.
 */
public class ExampleClient implements IObserver {

    public ExampleClient() {
        ActivityRecognizer activityRecognizer = new ActivityRecognizer();
        activityRecognizer.addObserver(this);
        activityRecognizer.startActivityRecognition();
    }

    public static void main(String[] args) throws InterruptedException {
        ExampleClient example = new ExampleClient();
        Thread.sleep(10000);
    }

    @Override
    public void updateActivity(String activity) {
        System.out.println("New activity: " + activity);
    }

    @Override
    public void updateEE(Double ee) {
        System.out.println("New EE: " + ee);
    }

    @Override
    public void updateLocation(String location) {
        System.out.println("New location: " + location);
    }
}
