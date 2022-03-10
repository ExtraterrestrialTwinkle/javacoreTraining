package com.example.user.javacoretraining.classes.admission;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Faculty {

    protected String name;
    protected Exam[] exams;
    private int minScore;
    private List<Applicant> budgetStudents = new ArrayList<>();

    {
        setFacultyName();
        appointExams();
        determineMinScore();
    }

    protected abstract void appointExams();
    protected abstract void setFacultyName();

    public String getFacultyName(){
        return name;
    }

    public Exam[] getExams(){
        return exams;
    }

    public int getMinScore(){
        return minScore;
    }

    private void determineMinScore(){
        this.minScore = new Random().nextInt(100);
    }

    public void enrollment(Applicant[] applicants) {
        for (Applicant applicant : applicants) {
            if(applicant.getFaculty().getFacultyName().equals(this.getFacultyName())){
                if (applicant.getScore() >= minScore) {
                    budgetStudents.add(applicant);
                }
            }
        }
        System.out.println("Зачисленные студенты: \n" + budgetStudents);
    }
}
 class FacultyOfEngineering extends Faculty{

    @Override
    protected void setFacultyName() {
        this.name = "Faculty Of Engineering";
    }

    @Override
    protected void appointExams() {
        this.exams = new Exam[] {
                Exam.MATH,
                Exam.CHEMISTRY,
                Exam.PHYSICS
        };
    }
}

class FacultyOfPhilology extends Faculty{

    @Override
    protected void setFacultyName() {
        this.name = "Faculty Of Philology";
    }

    @Override
    protected void appointExams() {
        this.exams = new Exam[] {
                Exam.ENGLISH,
                Exam.LAW,
                Exam.HISTORY
        };
    }
}
class FacultyOfGeography extends Faculty{

    @Override
    protected void setFacultyName() {
        this.name = "Faculty Of Geography";
    }

    @Override
    protected void appointExams() {
        this.exams = new Exam[] {
                Exam.ENGLISH,
                Exam.GEOGRAPHY,
                Exam.HISTORY
        };
    }
}




