import java.util.*;
import java.io.*;

public class City {
    public WayFinder wayFinder;

    public int textLenght;
    public int countOfCity;
    public String cities[];
    public int countOfWay;
    public String ways[][];
    public String direction[];

    public City(WayFinder wayFinder) {
        this.wayFinder = wayFinder;
    }
    
    public void city() {
        int textLenght = wayFinder.data.length;
        try {
            int countOfCity = Integer.parseInt(wayFinder.data[0]);
            try {
                String cities[] = new String[countOfCity];
                cities = wayFinder.data[1].split(" ");  
                if (countOfCity != wayFinder.data[1].split(" ").length) {
                    cities[countOfCity+1] = "a";
                }
                try {
                    int countOfWay = Integer.parseInt(wayFinder.data[2]);
                    try {
                        if (countOfWay == textLenght - 4) {
                            String ways[][] = new String[countOfWay][3];
                            for (int i = 0; i < countOfWay; i++) {
                                ways[i] = wayFinder.data[3+i].split(" ");
                                if (wayFinder.data[3+i].split(" ").length != 3) {
                                    throw new IllegalArgumentException("Invalid path data at line " + (3+i));
                                }
                                else{
                                    try {
                                        String direction[] = new String[2];
                                        direction = wayFinder.data[textLenght-1].split(" ");
                                        if (wayFinder.data[textLenght-1].split(" ").length != 2) {
                                            throw new IllegalArgumentException("Invalid direction format.");
                                        }
                                        this.textLenght = textLenght;
                                        this.cities = cities;
                                        this.countOfCity = countOfCity;
                                        this.countOfWay = countOfWay;
                                        this.direction = direction;
                                        this.ways = ways;
                                    }catch (Exception e){
                                        System.out.println("The direction in this text is not correct: "+ e.getMessage());
                                    } 
                                }
                            }
                        }
                        else{System.out.println("Number of way does not match or there is no direction: ");}
                        
                    } catch (Exception e) {
                        
                    }
                } catch (Exception e) {
                    System.out.println("Number of paths must be a integer: " + e.getMessage());
                }
            } catch (Exception e) {
                System.out.println("City data does not match!:  " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("In the input text first value must be a integer: "+ e.getMessage());
        }
        
    }   
}