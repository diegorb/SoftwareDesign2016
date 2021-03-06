package mx.iteso.observer.impl;

import mx.iteso.observer.Observer;
import mx.iteso.observer.Subject;

import java.util.ArrayList;

public class ScoresData implements Subject {
    private ArrayList<Observer> observers;
    private int homeGoals;
    private int awayGoals;
    private String homeTeam;
    private String awayTeam;

    private String player_goals = "";

    public ScoresData(){
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observers.indexOf(observer));
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.homeTeam, this.awayTeam, this.homeGoals, this.awayGoals, player_goals);
        }

        player_goals  = "";
    }

    public void newScore(){
        notifyObservers();
    }

    public void playerScored (String name, int number, String position, String team) {
        player_goals = String.format("%s%s%s: %d: %s: %s", player_goals, player_goals == "" ? "" : "\n" , name, number, position, team);
    }

    public void setScore(String homeTeam, String awayTeam, int homeGoals, int awayGoals){
        this.homeTeam = homeTeam;
        this.awayTeam =  awayTeam;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        newScore();
    }
}
