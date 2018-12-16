package io.exnihilo.designpatterns.behavioral;

import lombok.Data;

import java.util.Observable;
import java.util.Observer;

class MessageBoard extends Observable {
    public void changeMessage(String message) {
        setChanged();
        // clearChanged method removes all the changes made by setChanged method
        //clearChanged();
        notifyObservers(message);
    }
}

@Data
class Student implements Observer {
    @Override
    public void update(Observable observable, Object o) {
        System.out.println("Message board changed: " + o);
    }
}

public class ObserverDesignPattern {
    public static void main(String[] args) {
        MessageBoard board = new MessageBoard();
        Student bob = new Student();
        Student joe = new Student();
        board.addObserver(bob);
        board.addObserver(joe);
        board.changeMessage("More Homework!");
    }
}