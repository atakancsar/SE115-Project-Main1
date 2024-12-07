public class WayFinder {
    public String[] textData = new String[1000];
    public String[] data;
    
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
}
