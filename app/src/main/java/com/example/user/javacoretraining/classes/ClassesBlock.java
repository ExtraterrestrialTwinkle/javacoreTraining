package com.example.user.javacoretraining.classes;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Набор заданий по работе с классами в java.
 * <p>
 * Задания подразумевают создание класса(ов), выполняющих задачу.
 * <p>
 * Проверка осуществляется ментором.
 */

class Result {

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args) {
//        ClassesBlock.FirstClass first = new ClassesBlock.FirstClass(3.6, 14);
//        System.out.println(first.sum());
//        System.out.println(first.maxValue());
//
//        ClassesBlock.SecondClass second = new ClassesBlock.SecondClass(12);
//        second.fill();
//        second.print();
//        second.shuffle();
//        second.print();
//        System.out.println(second.elementCount(second.getArray()[4]));
//
//        ClassesBlock.Triangle triangle;
//        ClassesBlock.Triangle.Point a = new ClassesBlock.Triangle.Point(14, 45);
//        ClassesBlock.Triangle.Point b = new ClassesBlock.Triangle.Point(1, 45.3);
//        ClassesBlock.Triangle.Point c = new ClassesBlock.Triangle.Point(-9, 40.9);
//        triangle = new ClassesBlock.Triangle(a, b, c);
//        triangle.printTriangleInfo();
//        ClassesBlock.Triangle.Point a1 = new ClassesBlock.Triangle.Point(14, 0);
//        ClassesBlock.Triangle.Point b1 = new ClassesBlock.Triangle.Point(17, 43.1);
//        ClassesBlock.Triangle.Point c1 = new ClassesBlock.Triangle.Point(-9, -40.9);
//        ClassesBlock.Triangle newTriangle = new ClassesBlock.Triangle(a1, b1, c1);
//        newTriangle.printTriangleInfo();
//
//        ClassesBlock.Time time = new ClassesBlock.Time(14, 56, 48);
//        time.changeSeconds(28);
//        System.out.printf("Time is: %d hours %d minutes %d seconds \n",
//                time.getHours(), time.getMinutes(), time.getSeconds());

        ClassesBlock.Abonent petr = new ClassesBlock.Abonent(0, "Petr", "Avdeev", "Leonidovich");
        ClassesBlock.Abonent igor = new ClassesBlock.Abonent(1, "Igor", "Petrov", "Vasilievich");
        ClassesBlock.Abonent elena = new ClassesBlock.Abonent(
                2,
                "Elena",
                "Semenova",
                "Dmitrievna",
                "34 - 76 Tverskaya str., Moskow",
                13245,
                13.45,
                444.87,
                324,
                1120
        );
        ClassesBlock.Abonent svetlana = new ClassesBlock.Abonent(
                3,
                "Svetlana",
                "Vasilieva",
                "Andreevna",
                "25 - 13 Savelovskaya str., Moskow",
                86425,
                17.99,
                988.54,
                4678,
                332
        );
        igor.setIntracityCalls(457);
        petr.setFirstName("Pavel");
        petr.setLongDistanceCalls(7);
        petr.setIntracityCalls(1165);
        // Создать массив объектов класса Abonents
        ClassesBlock.Abonent[] abonents = new ClassesBlock.Abonent[]{petr, igor, svetlana, elena};
        System.out.println(Arrays.toString(abonents));

        //Вывести сведения относительно абонентов, у которых время городских переговоров
        // превышает заданное. (500 min)
        System.out.println("Абоненты, у которых время городских переговоров превышает 500 минут:");
        for (ClassesBlock.Abonent i : abonents) {
            if (i.getIntracityCalls() > 500) i.printAbonentInfo();
        }

        //Сведения относительно абонентов, которые пользовались междугородной связью.
        System.out.println("Абоненты, которые пользовались междугородней связью:");
        for (ClassesBlock.Abonent i : abonents) {
            if (i.getLongDistanceCalls() > 0) i.printAbonentInfo();
        }

        // Список абонентов в алфавитном порядке.

        Comparator<ClassesBlock.Abonent> comparator = Comparator.comparing(ClassesBlock.Abonent::getFirstName);
        Arrays.sort(abonents, comparator);
        System.out.println("Список абонентов: \n" + Arrays.toString(abonents));
    }
}

public interface ClassesBlock {

    /*
      I

      Создать класс с двумя переменными. Добавить функцию вывода на экран
      и функцию изменения этих переменных. Добавить функцию, которая находит
      сумму значений этих переменных, и функцию, которая находит наибольшее
      значение из этих двух переменных.
     */

    class FirstClass {
        private final double a;
        private final double b;

        public FirstClass(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public double sum() {
            return a + b;
        }

        public double maxValue() {
            return Math.max(b, a);
        }
    }

    /*
      II

      Создать класс, содержащий динамический массив и количество элементов в нем.
      Добавить конструктор, который выделяет память под заданное количество элементов.
      Добавить методы, позволяющие заполнять массив случайными числами,
      переставлять в данном массиве элементы в случайном порядке, находить количество
      различных элементов в массиве, выводить массив на экран.
     */

    class SecondClass {
        private final int[] array;
        private final int count;

        public int[] getArray() {
            return array;
        }

        public SecondClass(int count) {
            this.count = count;
            this.array = new int[count];
        }

        public int[] fill() {
            for (int i = 0; i < count; i++) {
                array[i] = new Random().nextInt();
            }
            return array;
        }

        public int[] shuffle() {
            for (int i = 0; i < count; i++) {
                int buffer = array[i];
                int random = new Random().nextInt(count - 1);
                array[i] = array[random];
                array[random] = buffer;
            }
            return array;
        }

        public int elementCount(int element) {
            int counter = 0;
            for (int i = 0; i < count; i++) {
                if (array[i] == element) {
                    counter++;
                }
            }
            return counter;
        }

        public void print() {
            System.out.println(Arrays.toString(array));
        }
    }

    /*
      III

      Описать класс, представляющий треугольник. Предусмотреть методы для создания объектов,
      вычисления площади, периметра и точки пересечения медиан.
      Описать свойства для получения состояния объекта.
     */

    class Triangle {
        private Point a;
        private Point b;
        private Point c;

        public Triangle(Point a, Point b, Point c) {
            checkTriangle(a, b, c);
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double sideA() {
            return this.a.distanceTo(this.b);
        }

        public double sideB() {
            return this.b.distanceTo(this.c);
        }

        public double sideC() {
            return this.c.distanceTo(this.a);
        }

        public double perimeter() {
            return sideA() + sideB() + sideC();
        }

        public double area() {
            double pp = perimeter() / 2;
            return Math.sqrt(pp * (pp - sideA()) * (pp - sideB()) * (pp - sideC()));
        }

        public Point center() {
            double x = (a.x + b.x + c.x) / 3;
            double y = (a.y + b.y + c.y) / 3;

            return new Point(x, y);
        }

        private void checkTriangle(Point a, Point b, Point c) {
            if (a == null || b == null || c == null)
                throw new WrongTriangleException("Point must not be null");

            double sideA = a.distanceTo(b);
            double sideB = b.distanceTo(c);
            double sideC = c.distanceTo(a);

            if (sideA + sideB <= sideC ||
                    sideB + sideC <= sideA ||
                    sideC + sideA <= sideB
            ) throw new WrongTriangleException("This is not a triangle");
        }

        public void printTriangleInfo() {
            System.out.printf("Triangle: area = %f, perimeter = %f, " +
                            "side a = %f, side b = %f, side c = %f \n", this.area(),
                    this.perimeter(), this.sideA(), this.sideB(), this.sideC());
        }

        static class WrongTriangleException extends RuntimeException {
            WrongTriangleException(String message) {
                super(message);
            }
        }

        static class Point {
            double x;
            double y;

            public Point(double x, double y) {
                this.x = x;
                this.y = y;
            }

            public double distanceTo(Point point) {
                double a = Math.abs(this.x - point.x);
                double b = Math.abs(this.y - point.y);
                return Math.sqrt(a * a + b * b);
            }
        }
    }
    /*
      IV

      Составить описание класса для представления времени.
      Предусмотреть возможности установки времени и изменения его отдельных полей
      (час, минута, секунда) с проверкой допустимости вводимых значений.
      В случае недопустимых значений полей выбрасываются исключения.
      Создать методы изменения времени на заданное количество часов, минут и секунд.
     */

    class Time {
        private int hours;
        private int minutes;
        private int seconds;

        public Time(int hours, int minutes, int seconds) {
            try {
                checkHours(hours);
                checkMinutes(minutes);
                checkSeconds(seconds);
            } catch (IncorrectTimeException ex) {
                System.out.println(ex.getMessage());
            }
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
        }

        public int getHours() {
            return this.hours;
        }

        public int getMinutes() {
            return this.minutes;
        }

        public int getSeconds() {
            return this.seconds;
        }

        public Time changeHours(int hours) {
            try {
                checkHours(hours);
            } catch (IncorrectTimeException ex) {
                System.out.println(ex.getMessage());
            }
            return new Time(hours, this.minutes, this.seconds);
        }

        public Time changeMinutes(int minutes) {
            try {
                checkMinutes(minutes);
            } catch (IncorrectTimeException ex) {
                System.out.println(ex.getMessage());
            }
            return new Time(this.hours, minutes, this.seconds);
        }

        public Time changeSeconds(int seconds) {
            try {
                checkSeconds(seconds);
            } catch (IncorrectTimeException ex) {
                System.out.println(ex.getMessage());
            }
            return new Time(this.hours, this.minutes, seconds);
        }

        public Time plusHours(int hours) {
            int newHours = this.hours + hours;
            if (newHours > 23) {
                newHours = newHours % 24;
            }
            return new Time(newHours, this.minutes, this.seconds);
        }

        public Time plusMinutes(int minutes) {
            int newMinutes = this.minutes + minutes;
            int newHours = this.hours;
            while (newMinutes > 59) {
                newMinutes = newMinutes - 60;
                newHours++;
            }
            while (newHours > 23) {
                newHours = newHours - 24;
            }
            return new Time(newHours, newMinutes, this.seconds);
        }

        public Time plusSeconds(int seconds) {
            int newSeconds = this.seconds + seconds;
            int newMinutes = this.minutes;
            int newHours = this.hours;
            while (newSeconds > 59) {
                newSeconds = newSeconds - 60;
                newMinutes++;
                while (newMinutes > 59) {
                    newMinutes = newMinutes - 60;
                    newHours++;
                }
                while (newHours > 23) {
                    newHours = newHours - 24;
                }
            }
            return new Time(newHours, newMinutes, newSeconds);
        }

        public Time minusHours(int hours) {
            int newHours = this.hours - hours;
            while (newHours < 0) {
                newHours = 24 + newHours;
            }
            return new Time(newHours, this.minutes, this.seconds);
        }

        public Time minusMinutes(int minutes) {
            int newMinutes = this.minutes - minutes;
            int newHours = this.hours;
            while (newMinutes < 0) {
                newMinutes = newMinutes + 60;
                newHours--;
                while (newHours < 0) {
                    newHours = 24 + newHours;
                }
            }
            return new Time(newHours, newMinutes, this.seconds);
        }

        public Time minusSeconds(int seconds) {
            int newSeconds = this.seconds - seconds;
            int newMinutes = this.minutes;
            int newHours = this.hours;
            while (newSeconds < 0) {
                newSeconds = newSeconds + 60;
                newMinutes--;
                while (newMinutes < 0) {
                    newMinutes = newMinutes + 60;
                    newHours--;
                    while (newHours < 0) {
                        newHours = 24 + newHours;
                    }
                }
            }
            return new Time(newHours, newMinutes, newSeconds);
        }

        private void checkHours(int hours) {
            if (hours < 0 || hours > 23) throw new IncorrectTimeException("Incorrect hours!");
        }

        private void checkMinutes(int minutes) {
            if (minutes < 0 || minutes > 59) throw new IncorrectTimeException("Incorrect hours!");
        }

        private void checkSeconds(int seconds) {
            if (seconds < 0 || seconds > 59) throw new IncorrectTimeException("Incorrect hours!");
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + hours;
            result = prime * result + minutes;
            result = prime * result + seconds;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            return this == obj;
        }

        @Override
        public String toString() {
            return String.format("Time: %d hours %d minutes %d seconds", this.hours, this.minutes, this.seconds);
        }

        static class IncorrectTimeException extends RuntimeException {
            IncorrectTimeException(String message) {
                super(message);
            }
        }
    }

    /*
      V

      Класс Абонент: Идентификационный номер, Фамилия, Имя, Отчество, Адрес,
      Номер кредитной карточки, Дебет, Кредит, Время междугородных и городских переговоров;
      Конструктор; Методы: установка значений атрибутов, получение значений атрибутов,
      вывод информации. Создать массив объектов данного класса.
      Вывести сведения относительно абонентов, у которых время городских переговоров
      превышает заданное.  Сведения относительно абонентов, которые пользовались
      междугородной связью. Список абонентов в алфавитном порядке.
     */

    class Abonent {
        private int id;
        private String lastName = "";
        private String firstName = "";
        private String patronymic = "";
        private String address = "";
        private long cardNumber = 0L;
        private double credit = 0.0;
        private double debit = 0.0;
        private long longDistanceCalls = 0L;
        private long intracityCalls = 0L;

        public Abonent(int id, String lastName, String firstName, String patronymic) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.patronymic = patronymic;
        }

        public Abonent(
                int id,
                String lastName,
                String firstName,
                String patronymic,
                String address,
                long cardNumber,
                double credit,
                double debit,
                long longDistanceCalls,
                long intracityCalls
        ) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.patronymic = patronymic;
            this.address = address;
            this.cardNumber = cardNumber;
            this.credit = credit;
            this.debit = debit;
            this.longDistanceCalls = longDistanceCalls;
            this.intracityCalls = intracityCalls;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setPatronymic(String patronymic) {
            this.patronymic = patronymic;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setCardNumber(long cardNumber) {
            this.cardNumber = cardNumber;
        }

        public void setCredit(double credit) {
            this.credit = credit;
        }

        public void setDebit(double debit) {
            this.debit = debit;
        }

        public void setIntracityCalls(long intracityCalls) {
            this.intracityCalls = intracityCalls;
        }

        public void setLongDistanceCalls(long longDistanceCalls) {
            this.longDistanceCalls = longDistanceCalls;
        }

        public int getId() {
            return id;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getPatronymic() {
            return patronymic;
        }

        public String getAddress() {
            return address;
        }

        public long getCardNumber() {
            return cardNumber;
        }

        public double getCredit() {
            return credit;
        }

        public double getDebit() {
            return debit;
        }

        public long getIntracityCalls() {
            return intracityCalls;
        }

        public long getLongDistanceCalls() {
            return longDistanceCalls;
        }

        public void printAbonentInfo() {
            String info = String.format("Abonent: %s %s %s \n Address: %s \n Credit: %f \n " +
                            "Debit: %f \n Intracity calls: %d min \n Long distance calls: %d min",
                    this.firstName, this.lastName, this.patronymic, this.address, this.credit, this.debit,
                    this.intracityCalls, this.longDistanceCalls);
            System.out.println(info);
        }

        @Override
        public String toString() {
            return String.format("Abonent: %s %s %s", this.firstName, this.lastName, this.patronymic);
        }
    }
    //Задачи 6 и 7 выполнены в отдельных пакетах
}
