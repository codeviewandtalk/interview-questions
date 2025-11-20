package designpatterns.behavioral.observerpattern.observer;

import designpatterns.behavioral.observerpattern.observable.StockObservable;
import designpatterns.behavioral.observerpattern.observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    String emailId;
    StockObservable observable;

    public EmailAlertObserverImpl(String emailId, StockObservable observable){
     this.observable=observable;
     this.emailId= emailId;

    }
    @Override
    public void update() {
      sendEmail(emailId,"product is in stock hurry up");
    }

    private void sendEmail(String emailId, String s) {
        System.out.println("mail sent to : "+ emailId);
        // send actual email to the end user
    }
}
