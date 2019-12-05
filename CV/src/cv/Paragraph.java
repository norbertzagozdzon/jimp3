package cv;

import java.io.PrintStream;

class Paragraph {
    private String content;
    Paragraph() {}
    Paragraph(String paragraphText) {
        this.content = paragraphText;
    }
    Paragraph setContent(String content) {
        this.content = content;
        return this;
    }
    void writeHTML(PrintStream out){
        out.println("<p>"+content+"</p>");
    }

}
