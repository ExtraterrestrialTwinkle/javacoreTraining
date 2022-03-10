package com.example.user.javacoretraining.classes.admission;

import java.util.Arrays;
import java.util.Random;

public class Applicant {

    private String name;
    private Faculty faculty;
    private int[] scores;
    private int score;

    public Applicant(String name){
        this.name = name;
    }

    public void registrate(Faculty faculty) {
        this.faculty = faculty;
    }

    public String getName(){
        return name;
    }

    public Faculty getFaculty(){
        return faculty;
    }

    public void takeExams(){
        scores = new int[faculty.getExams().length];
        for(int i = 0; i < faculty.getExams().length; i++){
            scores[i] = new Random().nextInt(100);
        }
        calculateScore();
    }

    private int calculateScore(){
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }
        score = sum / scores.length;
        return score;
    }

    public int getScore(){
        return calculateScore();
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "name= '" + name + '\'' +
                ", faculty= " + faculty.getFacultyName() +
                ", scores= " + Arrays.toString(scores) +
                ", score= " + score +
                '}';
    }
}
