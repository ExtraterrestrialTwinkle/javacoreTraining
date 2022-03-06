package com.example.user.javacoretraining.training;

import java.util.Arrays;

/**
 * Набор тренингов по работе с примитивными типами java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see ElementaryTrainingTest.
 */
public class ElementaryTraining {

    /**
     * Метод должен возвращать среднее значение
     * для введенных параметров
     *
     * @param firstValue  первый элемент
     * @param secondValue второй элемент
     * @return среднее значение для введенных чисел
     */
    public double averageValue(int firstValue, int secondValue) {
        return ((double) firstValue + secondValue) / 2;
    }

    /**
     * Пользователь вводит три числа.
     * Произвести манипуляции и вернуть сумму новых чисел
     *
     * @param firstValue  увеличить в два раза
     * @param secondValue уменьшить на три
     * @param thirdValue  возвести в квадрат
     * @return сумма новых трех чисел
     */
    public double complicatedAmount(int firstValue, int secondValue, int thirdValue) {
        return firstValue * 2 + (secondValue - 3) + thirdValue * thirdValue;
    }

    /**
     * Метод должен поменять значение в соответствии с условием.
     * Если значение больше 3, то увеличить
     * на 10, иначе уменьшить на 10.
     *
     * @param value число для изменения
     * @return новое значение
     */
    public int changeValue(int value) {
        if (value > 3) {
            return value + 10;
        } else {
            return value - 10;
        }
    }

    /**
     * Метод должен менять местами первую
     * и последнюю цифру числа.
     * Обрабатывать максимум пятизначное число.
     * Если число < 10, вернуть
     * то же число
     *
     * @param value число для перестановки
     * @return новое число
     */
    public int swapNumbers2(int value) {
        int first;
        int last;
        int multiplier = 1;
        int residue;
        int intermediate = value;

        if (value < 10) {
            return value;
        }
        do {
            intermediate = intermediate / 10;
            multiplier = multiplier * 10;
        } while (intermediate >= 10);

        first = intermediate % 10;
        last = value % 10;
        residue = value - first * multiplier - last;

        return last * multiplier + residue + first;
    }

    public int swapNumbers(int value){
        if(value < 10){
            return value;
        }
        String valueString = String.valueOf(value);
        char[] array = valueString.toCharArray();
        char buffer = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = buffer;

        StringBuilder str = new StringBuilder();
        for(int i = array.length - 1; i >= 0; i--){
            str.append(array[i]);
        }
        String string = str.toString();
        int val = Integer.parseInt(string);
        return Integer.parseInt(str.toString());
    }

    /**
     * Изменить значение четных цифр числа на ноль.
     * Счет начинать с единицы.
     * Обрабатывать максимум пятизначное число.
     * Если число < 10 вернуть
     * то же число.
     *
     * @param value число для изменения
     * @return новое число
     */
    public int zeroEvenNumber(int value) {
        int digit;
        StringBuilder str = new StringBuilder();
        int count = String.valueOf(value).length();
        if (value < 10){
            return value;
        }
        for (int i = 1; i <= count; i++){
            digit = value % 10;
            if (digit % 2 == 0) {
                digit = 0;
            }
            value /= 10;
            str.append(digit);
        }
        return Integer.parseInt(str.reverse().toString());
    }
}
