package day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberSequenceTest {

    @Test
    void createNumberSequecnceWithListTest(){
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);

        NumberSequence numberSequence = new NumberSequence(testList);
        assertEquals(5,numberSequence.getNumbers().size());

    }

    @Test
    void createNumberSequenceWithIntsTest(){
        NumberSequence numberSequence = new NumberSequence(1,5,5);

        assertEquals(5,numberSequence.getNumbers().size());

    }

    @Test
    void closeToAverageTest(){
        List<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);

        NumberSequence numberSequence = new NumberSequence(testList);
        List<Integer> test =numberSequence.closeToAverange(1);
        assertEquals(3, test.size());


    }



}