package com.maslick.test.ifaces;

/**
 * Created by maslick on 27.6.2017.
 */
public interface IObservable {
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void removeObservers();

    void notifyEE(Double ee);
    void notifyActivity(String activity);
    void notifyLocation(String location);
}
