import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input data file text: ");
        String fileName = sc.nextLine();

        WayFinder wayFinder = new WayFinder(null, null);
        City city = new City(wayFinder);
        CountryMap countryMap = new CountryMap(city);
        wayFinder.city = city;
        wayFinder.countryMap = countryMap;

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            int sizeOfText = 0;
            while ((line= br.readLine()) != null) {
                sizeOfText++;
            }
            String textDataDemo[] = new String[sizeOfText + 1];
            wayFinder.textData = textDataDemo;
        }catch(Exception e){System.out.println("File read error. "+ e.getMessage());}

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                wayFinder.textData[index] = line;
                index++;
            }
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        sc.close();
        wayFinder.printData();
        city.city();
        countryMap.countryMap();
        wayFinder.wayFinder();
        
    }
}
