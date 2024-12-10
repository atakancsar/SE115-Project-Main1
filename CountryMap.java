public class CountryMap {
    public City city;

    public CountryMap(City city){
        this.city = city;
    }
    public String neighbourdOnRight[][];
    public String neighbourdOnLeft[][];
    public int neighbourRightSize[];
    public int neighbourLeftSize[];


    public void countryMap(){
        //Define the neighbours on right side
        String neighboursRight[][] = new String[city.countOfCity][(city.countOfWay*2)];
        int neighbourRightSize[] = new int[city.countOfCity];
        for(int i = 0;i < city.countOfCity; i++){
            int a=0;
            int rightSize =0;
            for(int j = 0; j < city.countOfWay; j++){
                if(city.cities[i].equals(city.ways[j][0])){      
                    neighboursRight[i][a] = city.ways[j][1];
                    neighboursRight[i][a+1]= city.ways[j][2];
                    a+=2;
                    rightSize++;
                }
            }
            neighbourRightSize[i] = rightSize;
        }
        for(int i = 0; i < city.countOfCity;i ++){
            for(int j = 0; j < city.countOfWay+4; j++){
                if(neighboursRight[i][j] == null){
                    neighboursRight[i][j] = "-";
                }
            }
        }
        

        //Define the neighbours on left side
        String neighboursLeft[][] = new String[city.countOfCity][(city.countOfWay*2)+3];
        int neighbourLeftSize[] = new int[city.countOfCity];
        for(int i = 0;i < city.countOfCity; i++){
            int a=0;
            int leftSize=0;
            for(int j = 0; j < city.countOfWay; j++){
                if (city.cities[i].equals(city.ways[j][1])) {
                    neighboursLeft[i][a] = city.ways[j][0];
                    neighboursLeft[i][a+1] = city.ways[j][2];
                    a+=2;
                    leftSize++;
                }
            }
            neighbourLeftSize[i] = leftSize;
        }
        for(int i = 0; i < city.countOfCity;i ++){
            for(int j = 0; j < city.countOfWay+4; j++){
                if(neighboursLeft[i][j] == null){
                    neighboursLeft[i][j] = "-";
                }
            }
        }
        this.neighbourdOnLeft = neighboursLeft;
        this.neighbourdOnRight = neighboursRight;
        this.neighbourRightSize = neighbourRightSize;
        this.neighbourLeftSize = neighbourLeftSize;
        /* 
        for (int integers : neighbourLeftSize) {
            System.out.println(integers);
        }
        System.out.println("--------");
        for (int integers : neighbourRightSize) {
            System.out.println(integers);
        }  */
    }
}