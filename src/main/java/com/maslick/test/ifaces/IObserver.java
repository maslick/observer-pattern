package com.maslick.test.ifaces;

/**
 * Created by maslick on 27.6.2017.
 */
public interface IObserver {
    void updateActivity(String activity);
    void updateEE(Double ee);
    void updateLocation(String location);
}

