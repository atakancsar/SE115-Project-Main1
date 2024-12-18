import java.lang.reflect.Array;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;

public class WayFinder {
    public CountryMap countryMap;
    public City city;
    public String[] data;
    public String[] textData;
    
    public WayFinder(CountryMap countryMap, City city){
        this.countryMap = countryMap;
        this.city = city;
    }
    public void printData() {
        int a = 0;
        for (String line : textData) {
            if (line != null) { 
                a++;
            }
        }
        String[] data1 = new String[a];
        for(int i = 0 ; i < a; i++){data1[i] = textData[i];}
        data=data1;
 
    }


    public void wayFinder(){

        // Algorithm part
        String startCity = city.direction[0];
        String endCity = city.direction[1];
        int endCityIndex = -1; 
        int startCityIndex = -1;
        for(int j = 0; j< city.cities.length; j++){if (city.cities[j].equals(startCity)){startCityIndex=j;break;} {
        }}
        for (int i = 0; i < city.cities.length; i++) {
            if (city.cities[i].equals(endCity)) {
                endCityIndex = i;
                break; 
            }
        }
        String cities[] = city.cities;
        int minCityWay[] = new int[cities.length];
        
        for(int i = 0; i < cities.length; i++){
            if (cities[i].equals(startCity)) {minCityWay[i]=0;}
            else{minCityWay[i]= Integer.MAX_VALUE;}
        }
        int cityIndex = 0;
        
        for (int i = 0; i < cities.length * cities.length; i++) {
            int a = 0;
            for (int j = 0; j < countryMap.neighbourLeftSize.length; j++) {
                int index = -1;
                for (int k = 0; k < cities.length; k++) {
                    if (cities[k].equals(countryMap.neighbourdOnLeft[cityIndex][a])) {
                        index = k;
                        break;
                    }
                }
        
                if (index != -1 && !countryMap.neighbourdOnLeft[cityIndex][a].equals("-")) {
                    if (minCityWay[index] < Integer.MAX_VALUE) {
                        int newWay = Integer.parseInt(countryMap.neighbourdOnLeft[cityIndex][a + 1]) + minCityWay[index];
                        if (minCityWay[cityIndex] > newWay) {
                            minCityWay[cityIndex] = newWay;
                        }
                    }
                    a += 2;
                }
            }
            cityIndex++;
            if (cityIndex == cities.length) {
                cityIndex = 0; 
            }
        }
        //Path Direction  
        if (minCityWay[endCityIndex]!=Integer.MAX_VALUE) {
            String usedCities[] = new String[cities.length];
            usedCities[0] = endCity;
            int startIndex = startCityIndex;
            int endIndex = endCityIndex;
            int location = 1;
            usedCities[1] = startCity;

            while (startIndex!=endIndex) {
                int minWay = Integer.MAX_VALUE;
                int index = -1;
                int a = 0;
                for(int i = 0; i < countryMap.neighbourLeftSize[endIndex]; i++){
                    if(Integer.parseInt(countryMap.neighbourdOnLeft[endIndex][a+1])<minWay){
                        minWay = Integer.parseInt(countryMap.neighbourdOnLeft[endIndex][a+1]);
                        index = a;
                        
                    }
                    a+=2;
                }
                for(int i = 0; i < cities.length; i++){
                    if (cities[i].equals(countryMap.neighbourdOnLeft[endIndex][index])) {
                        usedCities[location]=cities[i];
                        location++;
                        endIndex=i;
                    }
                }
            }

            int count = 1;
            for(int i = 0; i < usedCities.length; i++){
                if (usedCities[i]!=null) {
                    count++;
                }
                else{break;}
            }
            String usedCitiesFixed[] = new String[count-1];
            for(int j = 0; j < usedCitiesFixed.length; j++){
                usedCitiesFixed[j] = usedCities[j];
            }

            String totalTime = "Total time:" + minCityWay[endCityIndex];
            try {

                FileWriter writer = new FileWriter("output.txt");
                writer.write("--Minimum way of direction--\n");

                for(int z = usedCitiesFixed.length-1; z >= 0; z-- ){
                    if (z==0) {writer.write(usedCitiesFixed[z]+"\n");}
                    else{writer.write(usedCitiesFixed[z] + "->");}
                }
                writer.write(totalTime);

                System.out.println("Data written as output.txt file.");
                writer.close();
            } catch (IOException e) {
                System.out.println("Something went wrong while printing the file: " + e.getMessage());
            }

        }
        else{System.out.println("There is no way for this direction.");}
    }  

}
