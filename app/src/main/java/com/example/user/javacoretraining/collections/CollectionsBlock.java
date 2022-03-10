package com.example.user.javacoretraining.collections;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Набор тренингов по работе со строками в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see CollectionsBlockTest.
 */
public class CollectionsBlock<T extends Comparable> {

    /**
     * Даны два упорядоченных по убыванию списка.
     * Объедините их в новый упорядоченный по убыванию список.
     * Исходные данные не проверяются на упорядоченность в рамках данного задания
     *
     * @param firstList  первый упорядоченный по убыванию список
     * @param secondList второй упорядоченный по убыванию список
     * @return объединенный упорядоченный список
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask0(@NonNull List<T> firstList, @NonNull List<T> secondList) {
        List<T> newList = new ArrayList<>();
        newList.addAll(firstList);
        newList.addAll(secondList);
        Collections.sort(newList);
        Collections.reverse(newList);
        return newList;
    }

    /**
     * Дан список. После каждого элемента добавьте предшествующую ему часть списка.
     *
     * @param inputList с исходными данными
     * @return измененный список
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask1(@NonNull List<T> inputList) {
        if (inputList.isEmpty()) return inputList;
        List<T> newList = new ArrayList<>();
        newList.add(inputList.get(0));
        for (int i = 1; i < inputList.size(); i++) {
            List<T> sublist = inputList.subList(0, i);
            newList.add(inputList.get(i));
            newList.addAll(sublist);
        }
        return newList;
    }

    /**
     * Даны два списка. Определите, совпадают ли множества их элементов.
     *
     * @param firstList  первый список элементов
     * @param secondList второй список элементов
     * @return <tt>true</tt> если множества списков совпадают
     * @throws NullPointerException если один из параметров null
     */
    public boolean collectionTask2(@NonNull List<T> firstList, @NonNull List<T> secondList) {
        return firstList.containsAll(secondList) && secondList.containsAll(firstList);
    }

    /**
     * Создать список из заданного количества элементов.
     * Выполнить циклический сдвиг этого списка на N элементов вправо или влево.
     * Если N > 0 циклический сдвиг вправо.
     * Если N < 0 циклический сдвиг влево.
     *
     * @param inputList список, для которого выполняется циклический сдвиг влево
     * @param n         количество шагов циклического сдвига N
     * @return список inputList после циклического сдвига
     * @throws NullPointerException если один из параметров null
     */
    public List<T> collectionTask3(@NonNull List<T> inputList, int n) {
        if (inputList.isEmpty()) return Collections.emptyList();
        if (Math.abs(n) > inputList.size()) {
            n = n % inputList.size();
        }
        List<T> buffer = new ArrayList<>();
        if (n > 0) {
            buffer.addAll(inputList.subList(inputList.size() - n, inputList.size()));
            for (int i = inputList.size() - 1; i >= n; i--) {
                inputList.set(i, inputList.get(i - n));
            }
            for (int i = 0; i < n; i++) {
                inputList.set(i, buffer.get(i));
            }
        } else {
            n = Math.abs(n);
            buffer.addAll(inputList.subList(0, n));
            for (int i = 0; i < inputList.size() - n; i++) {
                inputList.set(i, inputList.get(i + n));
            }
            for (int i = 0; i < n; i++) {
                inputList.set(inputList.size() - n + i, buffer.get(i));
            }
        }
        return inputList;
    }

    /**
     * Элементы списка хранят слова предложения.
     * Замените каждое вхождение слова A на B.
     *
     * @param inputList список со словами предложения и пробелами для разделения слов
     * @param a         слово, которое нужно заменить
     * @param b         слово, на которое нужно заменить
     * @return список после замены каждого вхождения слова A на слово В
     * @throws NullPointerException если один из параметров null
     */
    public List<String> collectionTask4(List<String> inputList, String a, String b) {
        if (inputList == null || a == null || b == null) throw new NullPointerException();
        if (inputList.contains(a)) {
            inputList.set(inputList.indexOf(a), b);
            collectionTask4(inputList, a, b);
        }
        return inputList;
    }

    /*
      Задание подразумевает создание класса(ов) для выполнения задачи.

      Дан список студентов. Элемент списка содержит фамилию, имя, отчество, год рождения,
      курс, номер группы, оценки по пяти предметам. Заполните список и выполните задание.
      Упорядочите студентов по курсу, причем студенты одного курса располагались
      в алфавитном порядке. Найдите средний балл каждой группы по каждому предмету.
      Определите самого старшего студента и самого младшего студентов.
      Для каждой группы найдите лучшего с точки зрения успеваемости студента.
     */
}
