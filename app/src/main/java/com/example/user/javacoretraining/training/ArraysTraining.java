package com.example.user.javacoretraining.training;

import java.util.Random;

/**
 * Набор тренингов по работе с массивами в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see ArraysTrainingTest.
 */
public class ArraysTraining {

    /**
     * Метод должен сортировать входящий массив
     * по возрастранию пузырьковым методом
     *
     * @param valuesArray массив для сортировки
     * @return отсортированный массив
     */
    public int[] sort(int[] valuesArray) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < valuesArray.length - 1; i++) {
                if (valuesArray[i] > valuesArray[i + 1]) {
                    isSorted = false;
                    int buffer = valuesArray[i];
                    valuesArray[i] = valuesArray[i + 1];
                    valuesArray[i + 1] = buffer;
                }
            }
        }
        return valuesArray;
    }

    /**
     * Метод должен возвращать максимальное
     * значение из введенных. Если входящие числа
     * отсутствуют - вернуть 0
     *
     * @param values входящие числа
     * @return максимальное число или 0
     */
    public int maxValue(int... values) {
        if (values.length != 0) {
            long start = System.currentTimeMillis();
            System.out.println(start);
            for (int i = 0; i < values.length - 1; i++) {
                if (values[i] > values[i + 1]) {
                    values[i + 1] = values[i];
                }
            }
            int result = values[values.length - 1];
            long finish = System.currentTimeMillis();
            System.out.println(finish);
            long time = finish - start;
            System.out.println("Non-sorted time = " + time);
            long start1 = System.currentTimeMillis();
            System.out.println(start1);
            values = sort(values);
            int result1 = values[values.length - 1];
            long finish1 = System.currentTimeMillis();
            System.out.println(finish1);
            long time1 = finish1 - start;
            System.out.println("Sorted time = " + time1);
            return result;
        }
        return 0;
    }

    /**
     * Переставить элементы массива
     * в обратном порядке
     *
     * @param array массив для преобразования
     * @return входящий массив в обратном порядке
     */
    public int[] reverse(int[] array) {
        if(array.length == 0) {
            return array;
        }
        for (int i = 0; i <= (array.length - 1) / 2; i++) {
            int buffer = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = buffer;
        }
        return array;
    }

    /**
     * Метод должен вернуть массив,
     * состоящий из чисел Фибоначчи
     *
     * @param numbersCount количество чисел Фибоначчи,
     *                     требуемое в исходящем массиве.
     *                     Если numbersCount < 1, исходный
     *                     массив должен быть пуст.
     * @return массив из чисел Фибоначчи
     */
    public int[] fibonacciNumbers(int numbersCount) {
        int[] fibonacci;
        if (numbersCount < 1) {
            fibonacci = new int[]{};
        } else {
            fibonacci = new int[numbersCount];
            switch (numbersCount) {
                case 1:
                    fibonacci[0] = 1;
                    break;
                case 2:
                    fibonacci[0] = 1;
                    fibonacci[1] = 1;
                    break;
                default:
                    fibonacci[0] = 1;
                    fibonacci[1] = 1;
                    for (int i = 2; i < numbersCount; i++) {
                        fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
                    }
            }
        }
        return fibonacci;
    }

    /**
     * В данном массиве найти максимальное
     * количество одинаковых элементов.
     *
     * @param array массив для выборки
     * @return количество максимально встречающихся
     * элементов
     */
    public int maxCountSymbol(int[] array) {
        int count1 = 1;
        int count2 = 1;
        if (array.length == 0) {
            return 0;
        } else {
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] == array[j]) {
                        count1++;
                    }
                    if (count2 < count1) {
                        count2 = count1;
                    }
                }
                count1 = 1;
            }
        }
        return count2;
    }
}

class Result{
    private static ArraysTraining arraysTraining;
    static void init(){
        arraysTraining = new ArraysTraining();
    }
    public static void main(String[] args){
        init();
        int[] values = new int[50000];
        for(int i = 0; i < 50000; i++){
            values[i] = new Random().nextInt();
        }
        arraysTraining.maxValue(values); // non-sorted ~3 ms; sorted ~6 ms
    }
}
