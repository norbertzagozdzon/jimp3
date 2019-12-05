package cv;

import java.io.PrintStream;

class Photo {
    private String url;
    Photo(String url){
        this.url =url;
    }
    Photo setPhoto(String url) {
        this.url = url;
        return this;
    }
    void writeHTML(PrintStream out){
        out.printf("<img src=\"%s\" alt=\"Smiley face\"",url);
    }
}