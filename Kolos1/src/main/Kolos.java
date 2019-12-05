public class Kolos {
    String color;
    Kolos(String color) {
        this.color = color;
    }
    double diff(Kolos k) {
        int[] t = SixteenToArray(this.getColor());
        int[] tk = SixteenToArray(k.getColor());
        int diff = t[0];
    }

    //#12ABC3
    int[] SixteenToArray(String sixteen) {
        int[] res = new int[3];
        res[0] = Integer.parseInt(sixteen.substring(1,3),16);
        res[1] = Integer.parseInt(sixteen.substring(3,5),16);
        res[2] = Integer.parseInt(sixteen.substring(5,7),16);
        return res;
    }
    String getColor() {
        return color;
    }
}
