package com.example.user.javacoretraining.classes.admission;

import java.util.Random;


/*
      VI

      Задача на взаимодействие между классами. Разработать систему «Вступительные экзамены».
      Абитуриент регистрируется на Факультет, сдает Экзамены. Преподаватель выставляет Оценку.
      Система подсчитывает средний балл и определяет Абитуриента, зачисленного в учебное заведение.
     */

public class Admission {
    public static void main(String[] args){
        Applicant yuri = new Applicant("Yuri");
        Applicant anton = new Applicant("Anton");
        Applicant evgenii = new Applicant("Evgenii");
        Applicant sidor = new Applicant("Sidor");
        Applicant angelina = new Applicant("Angelina");
        Applicant stella = new Applicant("Stella");
        Applicant anastasia = new Applicant("Anastasia");
        Applicant taisia = new Applicant("Taisia");
        Applicant elena = new Applicant("Elena");

        Applicant[] applicants = new Applicant[]{yuri, anton, evgenii, sidor, angelina, stella,
                anastasia, taisia, elena};

        Faculty[] faculties = new Faculty[]{
                new FacultyOfEngineering(),
                new FacultyOfGeography(),
                new FacultyOfPhilology()
        };

        for(Applicant applicant : applicants){
            int rd = new Random().nextInt(3);
            switch(rd){
                case 0 : {
                    applicant.registrate(new FacultyOfEngineering());
                    break;
                }
                case 1 : {
                    applicant.registrate(new FacultyOfPhilology());
                    break;
                }
                case 2 : {
                    applicant.registrate(new FacultyOfGeography());
                }
            }
            applicant.takeExams();
            System.out.println(applicant.toString());
        }

        for(Faculty faculty : faculties){
            System.out.printf("Minscore on faculty %s : %d \n", faculty.getFacultyName(), faculty.getMinScore());
            faculty.enrollment(applicants);
        }
    }
}