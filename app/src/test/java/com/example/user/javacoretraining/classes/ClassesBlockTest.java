package com.example.user.javacoretraining.classes;


import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClassesBlockTest {

    private static ClassesBlock.Time time;

    @BeforeClass
    public static void init(){
        time = new ClassesBlock.Time(23, 45, 6);
    }

    @Test
    public void test_changeHours(){
        int hour = 13;
        String expectedTime = new ClassesBlock.Time(13, 45, 6).toString();
        String actualTime = time.changeHours(hour).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_changeMinutes(){
        int minute = 13;
        String expectedTime = new ClassesBlock.Time(23, 13, 6).toString();
        String actualTime = time.changeMinutes(minute).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_changeSeconds(){
        int second = 13;
        String expectedTime = new ClassesBlock.Time(23, 45, 13).toString();
        String actualTime = time.changeSeconds(second).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_minusSeconds_less60(){
        int second = 4;
        String expectedTime = new ClassesBlock.Time(23, 45, 2).toString();
        String actualTime = time.minusSeconds(second).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_minusSeconds_more60(){
        int second = 134;
        String expectedTime = new ClassesBlock.Time(23, 42, 52).toString();
        String actualTime = time.minusSeconds(second).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_minusSeconds_changeHour(){
        int second = 3400;
        String expectedTime = new ClassesBlock.Time(22, 48, 26).toString();
        String actualTime = time.minusSeconds(second).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_minusSeconds_changeDay(){
        int second = 104000;
        String expectedTime = new ClassesBlock.Time(18, 51, 46).toString();
        String actualTime = time.minusSeconds(second).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_minusMinutes_less60(){
        int minute = 4;
        String expectedTime = new ClassesBlock.Time(23, 41, 6).toString();
        String actualTime = time.minusMinutes(minute).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_minusMinutes_changeHour(){
        int minute = 134;
        String expectedTime = new ClassesBlock.Time(21, 31, 6).toString();
        String actualTime = time.minusMinutes(minute).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_minusHours(){
        int hour = 134;
        String expectedTime = new ClassesBlock.Time(9, 45, 6).toString();
        String actualTime = time.minusHours(hour).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_plusSeconds_less60(){
        int second = 34;
        String expectedTime = new ClassesBlock.Time(23, 45, 40).toString();
        String actualTime = time.plusSeconds(second).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_plusSeconds_more60(){
        int second = 134;
        String expectedTime = new ClassesBlock.Time(23, 47, 20).toString();
        String actualTime = time.plusSeconds(second).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_plusSeconds_changeDay(){
        int second = 1340;
        String expectedTime = new ClassesBlock.Time(0, 7, 26).toString();
        String actualTime = time.plusSeconds(second).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_plusMinutes_less60(){
        int minute = 4;
        String expectedTime = new ClassesBlock.Time(23, 49, 6).toString();
        String actualTime = time.plusMinutes(minute).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_plusMinutes_changeDay(){
        int minute = 134;
        String expectedTime = new ClassesBlock.Time(1, 59, 6).toString();
        String actualTime = time.plusMinutes(minute).toString();
        assertEquals(expectedTime, actualTime);
    }

    @Test
    public void test_plusHours(){
        int hour = 134;
        String expectedTime = new ClassesBlock.Time(13, 45, 6).toString();
        String actualTime = time.plusHours(hour).toString();
        assertEquals(expectedTime, actualTime);
    }
}