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
        int endCityIndex = Arrays.asList(city.cities).indexOf(endCity);
        String cities[] = city.cities;
        int minCityWay[] = new int[cities.length];
        
        for(int i = 0; i < cities.length; i++){
            if (cities[i].equals(startCity)) {minCityWay[i]=0;}
            else{minCityWay[i]= Integer.MAX_VALUE;}
        }
        
        int cityIndex = 0;

        for(int i = 0; i < cities.length*cities.length; i++){
            int a = 0;
            for(int j = 0; j < countryMap.neighbourLeftSize.length; j++){
                int index = Arrays.asList(cities).indexOf(countryMap.neighbourdOnLeft[cityIndex][a]);
                if(countryMap.neighbourdOnLeft[cityIndex][a]!="-"){
                    if (minCityWay[Arrays.asList(cities).indexOf(countryMap.neighbourdOnLeft[cityIndex][a])] < Integer.MAX_VALUE) {
    
                        if(minCityWay[cityIndex] > Integer.parseInt(countryMap.neighbourdOnLeft[cityIndex][a+1]) + minCityWay[index]){
                            minCityWay[cityIndex] = Integer.parseInt(countryMap.neighbourdOnLeft[cityIndex][a+1]) + minCityWay[index];
                        }
                    }
                    a+=2;
                }
            }
            cityIndex++;
            if (cityIndex == cities.length) {
                cityIndex=0;
            }
        }

        //Path Direction  
        if (minCityWay[endCityIndex]!=Integer.MAX_VALUE) {
            String usedCities[] = new String[cities.length];
            usedCities[0] = endCity;
            String end = endCity;
            String start = startCity;
            int endIndex = endCityIndex;
            int location = 1;
            while (!end.equals(start)) {
                int min = Integer.MAX_VALUE;
                int a = 0;
                for(int i = 0; i < countryMap.neighbourLeftSize[endIndex]; i++){
                    if (Integer.parseInt(countryMap.neighbourdOnLeft[endIndex][a+1]) < min) {
                        min = Integer.parseInt(countryMap.neighbourdOnLeft[endIndex][a+1]);
                        end = countryMap.neighbourdOnLeft[endIndex][a];
                    }
                }
                usedCities[location] = end;
                endIndex = Arrays.asList(cities).indexOf(end);
                location++;
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
                writer.write("--Minimum way direction--\n");
                for(int z = usedCitiesFixed.length-1; z >= 0; z-- ){
                    if (z==0) {writer.write(usedCitiesFixed[z]+"\n");}
                    else{writer.write(usedCitiesFixed[z] + "->");}
                }
                writer.write(totalTime);
                System.out.println("Data written to output.txt file.");
                writer.close();
            } catch (IOException e) {
                System.out.println("Somethin went wrong while printing the file: " + e.getMessage());
            }

        }
        else{System.out.println("There is no way in this direcion.");}
    }  

}
