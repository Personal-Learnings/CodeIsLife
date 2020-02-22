package com.learnings.practise.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class Observer {
    public static void main(String[] args) {
        ESPN espn = new ESPN();
        StarSports starSports = new StarSports();

        CricketScoreProvider provider = new CricketScoreProvider();
        provider.subscribe(espn);
        provider.subscribe(starSports);

        System.out.println("New Scores Received");
        provider.updateScores((short) 10, 2.0f, (short) 247);

        provider.Unsubscribe(starSports);

        System.out.println("New Scores Received");
        provider.updateScores((short) 20, 3.0f, (short) 265);
    }
}

interface Provider {
    void subscribe(Consumer consumer);
    void Unsubscribe(Consumer consumer);
    void notifySubscribers();
}

class CricketScoreProvider implements Provider {
    private List<Consumer> consumers;
    private short score, predictedScore; float overs;

    CricketScoreProvider() { consumers = new ArrayList<>(); }
    @Override public void subscribe(Consumer consumer) { consumers.add(consumer); }
    @Override public void Unsubscribe(Consumer consumer) { consumers.remove(consumer); }
    @Override public void notifySubscribers() { for(Consumer consumer : consumers) consumer.updateScores(score, overs, predictedScore); }

    public void updateScores(short score, float overs, short predictedScore) {
        this.score = score; this.overs = overs; this.predictedScore = predictedScore;
        notifySubscribers();
    }
}

interface Consumer {
    void updateScores(short score, float overs, short predictedScore);
}

class ESPN implements Consumer {
    private short score, predictedScore; float overs;

    @Override
    public void updateScores(short score, float overs, short predictedScore) {
        setScore(score);
        setOvers(overs);
        setPredictedScore(predictedScore);
        display();
    }

    private void display() {
        System.out.println(String.format("ESPN:: Score: %S Overs: %S Predicted Score: %S", score, overs, predictedScore));
    }

    public void setScore(short score) { this.score = score; }
    public void setOvers(float overs) { this.overs = overs; }
    public void setPredictedScore(short predictedScore) { this.predictedScore = predictedScore; }
}

class StarSports implements Consumer {
    private short score, predictedScore; float overs;

    @Override
    public void updateScores(short score, float overs, short predictedScore) {
        setScore(score);
        setOvers(overs);
        setPredictedScore(predictedScore);
        display();
    }

    private void display() {
        System.out.println(String.format("StarSports:: Score: %S Overs: %S Predicted Score: %S", score, overs, predictedScore));
    }

    public void setScore(short score) { this.score = score; }
    public void setOvers(float overs) { this.overs = overs; }
    public void setPredictedScore(short predictedScore) { this.predictedScore = predictedScore; }
}