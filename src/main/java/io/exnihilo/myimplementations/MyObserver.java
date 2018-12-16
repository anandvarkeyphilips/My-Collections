package io.exnihilo.myimplementations;

import java.util.ArrayList;

//MyObserver as observer interface
interface MyObserver {
    void update(MyObservable o, Object arg);
}

//MyObservable as Observable class
class MyObservable {
    ArrayList<MyObserver> myObserverList = new ArrayList<MyObserver>();

    boolean changeFlag = false;

    public void notifyObservers(Object o) {
        if (hasChanged()) {
            for (MyObserver mo : myObserverList) {
                mo.update(this, o);
            }
            clearChanged();
        }
    }


    public void addObserver(MyObserver o) {
        myObserverList.add(o);
    }

    public void setChanged() {
        changeFlag = true;
    }

    public boolean hasChanged() {
        return changeFlag;
    }

    protected void clearChanged() {
        changeFlag = false;
    }

}

//Your example with MyObserver and MyObservable!s
class MessageBoard extends MyObservable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void changeMessage(String message) {
        this.message = message;
        setChanged();
        notifyObservers(message);
    }

    public static void main(String[] args) {
        MessageBoard board = new MessageBoard();
        Student bob = new Student();
        Student joe = new Student();
        board.addObserver(bob);
        board.addObserver(joe);
        board.changeMessage("More Homework!");
    }
}

class Student implements MyObserver {
    public void update(MyObservable o, Object arg) {
        System.out.println("Message board changed: " + arg);
    }
}