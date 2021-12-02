package day04;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class fileReader {

    private int findSmallestTemperatureSpread(String filename) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/datamunging/" + filename));

            int minSpreed = Integer.MAX_VALUE;
            int minDay = 0;

            for (int i = 2; i < lines.size() - 1; i++) {
                int day = Integer.parseInt(lines.get(i).substring(2, 4).trim());
                int max = Integer.parseInt(lines.get(i).substring(6, 8).trim());
                int min = Integer.parseInt(lines.get(i).substring(12, 14).trim());

                int spreed = max - min;
                if (minSpreed > spreed) {
                    minSpreed = spreed;
                    minDay = day;
                }
            }
            return minDay;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    public String findSmallestDifference(String filename) {

        Path path = Paths.get("src/main/resources/datamunging/" + filename);
        List<String> lines = readAndFormatFile(path);
        String result ="";
        int minDifference = Integer.MAX_VALUE;
        for (String actual : lines) {
            try {
                int f = Integer.parseInt(actual.substring(44, 46).trim());
                int a = Integer.parseInt(actual.substring(51, 53).trim());
                if (f - a < minDifference) {
                    minDifference = f - a;
                    result = actual.substring(7,22);
                }
            }catch (NumberFormatException nfe){
                throw new IllegalStateException("Can not convert");
            }
        }
        return result;
    }

    private List<String> readAndFormatFile(Path path) {
        try {
            return stringFormatter(Files.readAllLines(path));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file");
        }
    }

    private List<String> stringFormatter(List<String> toFormat) {
        toFormat.remove(18);
        toFormat.remove(0);
        return toFormat;
    }

    public static void main(String[] args) {
        int min = new fileReader().findSmallestTemperatureSpread("weather.dat");
        System.out.println(min);

        String winner = new fileReader().findSmallestDifference("football.dat");
        System.out.println(winner);

    }


}
