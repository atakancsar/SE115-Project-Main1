import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter input data file text: ");
        String fileName = sc.nextLine();

        WayFinder wayFinder = new WayFinder();
        CountryMap countryMap = new CountryMap();
        City city = new City(wayFinder);

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
        
    }
}
