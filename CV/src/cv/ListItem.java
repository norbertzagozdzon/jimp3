package cv;

import java.io.PrintStream;

class ListItem {
    private String text;
    ListItem(String text) {
        this.text=text;
    }
    void writeHTML(PrintStream out){
        out.println("<li>"+text+"</li>");
    }

}
