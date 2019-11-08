package cv;

import java.io.PrintStream;

public class Photo {
    String url;
    Photo(String url){
        this.url =url;
    }
    Photo setPhoto(String url) {
        this.url = url;
        return this;
    }
    void writeHTML(PrintStream out){
        System.out.printf("<img src=\"%s\" alt=\"Smiley face\" height=\"42\" width=\"42\"/>\n",url);
    }
}