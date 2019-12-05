import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVReader {
    BufferedReader reader;
    String delimiter;
    boolean hasHeader;
    String[] current;
    // nazwy kolumn w takiej kolejności, jak w pliku
    List<String> columnLabels = new ArrayList<>();
    // odwzorowanie: nazwa kolumny -> numer kolumny
    Map<String,Integer> columnLabelsToInt = new HashMap<>();

    /**
     *
     * @param filename - nazwa pliku
     * @param delimiter - separator pól
     * @param hasHeader - czy plik ma wiersz nagłówkowy
     */

    public CSVReader(String filename,String delimiter,boolean hasHeader) throws IOException{
        reader = new BufferedReader(new FileReader(filename));
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
        if(hasHeader)parseHeader();
    }
    //...
    void parseHeader() throws IOException{
        // wczytaj wiersz
        String line = reader.readLine();
        if (line == null) {
            return;
        }
        // podziel na pola
        String[] header = line.split(delimiter);
        // przetwarzaj dane w wierszu
        for (int i = 0; i < header.length; i++) {
            columnLabelsToInt.put(header[i],i);
            columnLabels.add(header[i]);
        }
    }
    boolean next(){
        String line;
        try {
            line = reader.readLine();
        }
        catch (IOException e) {
            return false;
        }
        if(line==null) return false;
        current = line.split(delimiter+"(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        return true;

    }
    void readCurr() {
        for(String i:current) {
            System.out.print(i+", ");
        }
        System.out.println();
    }
    int getInt(String name) {
        return Integer.parseInt(current[columnLabelsToInt.get(name)]);
    }
    String get(String name) {
        return current[columnLabelsToInt.get(name)];
    }
    double getDouble(String name) {
        try {
            return Double.parseDouble(current[columnLabelsToInt.get(name)]);
        }
        catch(Exception e) {
            return -404;
        }
    }
    List<String> getColumnLabels() {
        return columnLabels;
    }
    int getRecordLength() {
        return current.length;
    }
    boolean isMissing(int columnIndex){
        return columnIndex>=getRecordLength();
    }
    public static void main(String[] args) throws IOException{

        CSVReader reader = new CSVReader("titanic-part.csv",",",true);
        for(String i:reader.getColumnLabels()) {
            System.out.print(i+"  ");
        }
        System.out.println();
        while(reader.next()){
            int id = reader.getInt("PassengerId");
            String name = reader.get("Name");
            double fare = reader.getDouble("Fare");
            if(fare==-404) continue;
            System.out.println(id+", "+name+", "+fare);

        }
    }

}