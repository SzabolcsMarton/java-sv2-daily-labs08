package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {

    private List<Integer> numbers = new ArrayList<>();

    public NumberSequence(List<Integer> numbers){
        this.numbers = numbers;
    }

    public NumberSequence(int min, int max , int pieces){
        Random rnd = new Random();
        for(int i = 0; i < pieces; i++){
            numbers.add(rnd.nextInt(numbers.get(0), numbers.get(1) + 1));
        }
    }

    public List<Integer> closeToAverange(int value){
        List<Integer> result = new ArrayList<>();
        double average = calculateAverange();
        for (int actual : numbers){
            if(Math.abs(actual - average) <= value){
                result.add(actual);
            }
        }
        return result;
    }

    private double calculateAverange(){
        double sum = 0;
        for(int actual : numbers){
            sum += actual;
        }
        return sum / numbers.size();
    }

}
