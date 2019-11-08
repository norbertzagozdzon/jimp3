package cv;

import java.io.PrintStream;

public class Paragraph {
    private String content;
    Paragraph(String paragraphText) {
        this.content = paragraphText;
    }
    Paragraph setContent(String content) {
        this.content = content;
        return this;
    }
    void writeHTML(PrintStream out){}
}
