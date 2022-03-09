package com.example.user.javacoretraining.training;

/**
 * Набор тренингов по работе со строками в java.
 * <p>
 * Задания определены в комментариях методов.
 * <p>
 * Проверка может быть осуществлена запуском тестов.
 * <p>
 * Доступна проверка тестированием @see StringsTrainingTest.
 */
public class StringsTraining {

    /**
     * Метод по созданию строки,
     * состоящей из нечетных символов
     * входной строки в том же порядке
     * (нумерация символов идет с нуля)
     *
     * @param text строка для выборки
     * @return новая строка из нечетных
     * элементов строки text
     */
    public String getOddCharacterString(String text) {
        StringBuilder newString = new StringBuilder();
        char[] textArray = text.toCharArray();
        for(int i = 0; i < textArray.length; i++){
            if(i % 2 == 1){
                newString.append(textArray[i]);
            }
        }
        return newString.toString();
    }

    /**
     * Метод для определения количества
     * символов, идентичных последнему
     * в данной строке
     *
     * @param text строка для выборки
     * @return массив с номерами символов,
     * идентичных последнему. Если таких нет,
     * вернуть пустой массив
     */
    public int[] getArrayLastSymbol(String text) {
        int[] countArray = new int[]{};
        int count = 0;
        char[] textArray = text.toCharArray();
        if(textArray.length != 0){
            for (int i = 0; i < textArray.length - 1; i++){
                if(textArray[i] == textArray[textArray.length - 1]){
                    count++;
                }
            }
            if(count != 0) {
                countArray = new int[count];
                int i = 0;
                for (int j = 0; j < countArray.length; j++){
                    while (i < textArray.length - 1) {
                        if(textArray[i] != textArray[textArray.length - 1]) {
                            i++;
                        } else break;
                    }
                    countArray[j] = i;
                    i++;
                }
            }
        }
        return countArray;
    }

    /**
     * Метод по получению количества
     * цифр в строке
     *
     * @param text строка для выборки
     * @return количество цифр в строке
     */
    public int getNumbersCount(String text) {
        char[] textArray = text.toCharArray();
        int count = 0;
        for(int i = 0; i < textArray.length; i++){
            char ch = textArray[i];
            if(Character.isDigit(ch)) count++;
        }
        return count;
    }

    /**
     * Дан текст. Заменить все цифры
     * соответствующими словами.
     *
     * @param text текст для поиска и замены
     * @return текст, где цифры заменены словами
     */
    public String replaceAllNumbers(String text) {
        char[] textArray = text.toCharArray();
        String[] stringArray = new String[textArray.length];
        StringBuilder string = new StringBuilder();
        for(int i = 0; i < textArray.length; i++){
            char ch = textArray[i];
            stringArray[i] = Character.toString(ch);
            switch(ch){
                case '0': {
                    stringArray[i] = "zero";
                    break;
                }
                case '1': {
                    stringArray[i] = "one";
                    break;
                }
                case '2': {
                    stringArray[i] = "two";
                    break;
                }
                case '3': {
                    stringArray[i] = "three";
                    break;
                }
                case '4': {
                    stringArray[i] = "four";
                    break;
                }
                case '5': {
                    stringArray[i] = "five";
                    break;
                }
                case '6': {
                    stringArray[i] = "six";
                    break;
                }
                case '7': {
                    stringArray[i] = "seven";
                    break;
                }
                case '8': {
                    stringArray[i] = "eight";
                    break;
                }
                case '9': {
                    stringArray[i] = "nine";
                }
            }
            string.append(stringArray[i]);
        }
        return string.toString();
    }

    /**
     * Метод должен заменить заглавные буквы
     * на прописные, а прописные на заглавные
     *
     * @param text строка для изменения
     * @return измененная строка
     */
    public String capitalReverse(String text) {
        char[] textArray = text.toCharArray();
        for(int i = 0; i < textArray.length; i++) {
            char ch = textArray[i];
            if(Character.isLetter(ch)){
                if(Character.isLowerCase(ch)){
                    ch = Character.toUpperCase(ch);
                } else {
                    ch = Character.toLowerCase(ch);
                }
                textArray[i] = ch;
            }
        }
        text = String.valueOf(textArray);
        return text;
    }

}
