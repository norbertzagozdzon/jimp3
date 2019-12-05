import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kolos {
    BufferedReader br;
    boolean hasHeader=false;
    String delimiter;
    String[] current;
    final static String[] MONTHS = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    List<Month> monthz = new ArrayList<>();

    Kolos(String path,String delimiter) throws IOException {
        this.br = new BufferedReader(new FileReader(path));
        this.delimiter = delimiter;
        br.readLine();
    }
    String currentToString() {
        StringBuilder sb = new StringBuilder();
        for(String i:current) {
            sb.append(i+", ");
        }
        return sb.toString();
    }
    void trimCurrent() {
        for(int i=0;i<current.length;i++) {
            current[i]= current[i].trim();
        }
    }
    void readCurrent() {
        for(String i:current) {
            System.out.print(i+", ");
        }
        System.out.println();
    }
    boolean isMonthIn(String name) {
        for(Month i:monthz) {
            if(i.getName().equals(name)) return true;
        }
        return false;
    }
    String parseMonth(String month) {
        try {
            return month.substring(4, 7);
        }
        catch (StringIndexOutOfBoundsException e) {
            return null;
        }
    }
    String getStraightDouble(String text) {
        String tempVal="6000.00";
        try {
            tempVal = text.substring(1, 8);
        }
        catch(StringIndexOutOfBoundsException e) {
            try {
                tempVal = text.substring(0, 7);
            }
            catch (StringIndexOutOfBoundsException e2) {
                System.out.println("Error In Line: " + currentToString() + ". Cant understand this value, skipping the line...");
            }
        }
        return tempVal;
    }
    void fillValues() throws IOException{
        String line = br.readLine();
        Scanner sc = new Scanner(System.in);
        outerloop:
        while(line!=null) {
            current = line.split(delimiter);
            trimCurrent();
            readCurrent();
            String tempMonth = parseMonth(current[0]);
            if (Arrays.asList(MONTHS).contains(tempMonth)) {
                if(!isMonthIn(tempMonth)) {
                    monthz.add(new Month(tempMonth));
                }
            }
            else {
                System.out.println("Error In Line: " + currentToString() + ". Cant understand this month, skipping the line...");
                br.readLine();
                continue;
            }
            ArrayList<Double> tempVals = new ArrayList<>();
            for (int i = 1; i < current.length; i++) {
                String tempVal=getStraightDouble(current[i]);
                try {
                    double toAdd = Double.parseDouble(tempVal);
                    tempVals.add(toAdd);
                } catch (NumberFormatException e) {
                    System.out.println("Error in Line: " + currentToString() + ". Problem with parsing: " + tempVal + "\nDo you want to skip line or fill the value with 6000?\n" +
                            "1: skip\n" +
                            "2: fill");
                    int choice = sc.nextInt();
                    if(choice==2) {
                        tempVals.add(6000.0);
                    }
                    else {
                        line = br.readLine();
                        continue outerloop;
                    }
                }
            }
            for (Month i : monthz) {
                if (i.getName().equals(tempMonth)) {
                    i.addLine(tempVals);
                }
            }
            line = br.readLine();
        }
    }
    void readByMonths() {
        System.out.println("___________________");
        for(Month i:monthz) {
            //i.reado();
            i.readFinal();
        }

    }
    public static void main(String[] args) throws IOException{
        if(args[0].equals("load")) {
            Kolos k = new Kolos(args[1], ",");
            k.fillValues();
            k.readByMonths();
        }
        else if(args[0].equals("test")) {
            JUnitCore junit = new JUnitCore();
            Result result = junit.run(Month.class);
        }
    }
}
