package designpatterns.behavioral.observerpattern.observer;

import designpatterns.behavioral.observerpattern.observable.StockObservable;
import designpatterns.behavioral.observerpattern.observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

    String userName;
    StockObservable observable;

    public MobileAlertObserverImpl(String userName,StockObservable observable) {
        this.observable= observable;
        this.userName= userName;

    }

    @Override
    public void update() {
        sendMsgOnMobile(userName, "product is in stock hurry up");
    }

    private void sendMsgOnMobile(String userName, String s) {
        System.out.println("Msg sent to : "+ userName);
    }
}
