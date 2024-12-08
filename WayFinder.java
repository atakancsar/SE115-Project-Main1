public class WayFinder {
    public CountryMap countryMap;
    public City city;
    public String[] textData = new String[1000];
    public String[] data;
    
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
        for (String string[] : countryMap.neighbourdOnLeft) {
            System.out.println(" ");
            for (String string2 : string) {
                System.out.print(string2+" ");
            }
        }
        System.out.println(" ");
        for (String string[] : countryMap.neighbourdOnRight) {
            System.out.println(" ");
            for (String string2 : string) {
                System.out.print(string2+" ");
            }
        }
    }
}
