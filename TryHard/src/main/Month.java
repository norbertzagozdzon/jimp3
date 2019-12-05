import java.util.ArrayList;
import java.util.List;

public class Month {
    String name;
    int records=0;
    List<ArrayList<Double>> l = new ArrayList<>();
    Month(String name) {
        this.name = name;
    }
    void addLine(ArrayList<Double> line) {
        records++;
        l.add(line);
    }
    String getName() {
        return name;
    }
    void reado() {
        System.out.print(name+"\n");
        for(ArrayList<Double> i :l) {
            for(Double j: i) {
                System.out.print(j+", ");
            }
            System.out.println();
        }
        System.out.println(records);
        System.out.print("_____________________");
        System.out.println();
    }
    double countAvg() {
        double res=0;
        for(ArrayList<Double> i :l) {
            for(Double j: i) {
                res+=j;
            }
        }
        return res/(4*records);
    }
    double countMaxSub() {
        double maxRes=0;
        for(ArrayList<Double> i :l) {
            double res = i.get(0)>i.get(3)?1-(i.get(3)/i.get(0)):1-(i.get(0)/i.get(3));
            if(res>maxRes) maxRes = res;
        }
        return maxRes*100;
    }
    void readFinal() {
        System.out.println(name+" : "+records+" : avg : "+countAvg());
        System.out.println(name+" : "+records+" : max%Sub : "+countMaxSub()+" %");
    }
}
