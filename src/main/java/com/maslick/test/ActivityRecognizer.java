package com.maslick.test;

import com.maslick.test.ifaces.IObservable;
import com.maslick.test.ifaces.IObserver;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by maslick on 27.6.2017.
 */
public class ActivityRecognizer implements IObservable {

    private List<IObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(IObserver observer) {
        if (!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void removeObservers() {
        for (IObserver observer : observers) observers.remove(observer);
    }

    @Override
    public void notifyEE(Double ee) {
        for (IObserver observer : observers) observer.updateEE(ee);
    }

    @Override
    public void notifyActivity(String activity) {
        for (IObserver observer : observers) observer.updateActivity(activity);
    }

    @Override
    public void notifyLocation(String location) {
        for (IObserver observer : observers) observer.updateLocation(location);
    }

    public void startActivityRecognition() {
        Observable.interval(1000, TimeUnit.MILLISECONDS).subscribe(object -> notifyActivity("walking"));
        Observable.interval( 500, TimeUnit.MILLISECONDS).subscribe(object -> notifyEE(1.2));
        Observable.interval(2000, TimeUnit.MILLISECONDS).subscribe(object -> notifyLocation("No orientation"));
    }
}
