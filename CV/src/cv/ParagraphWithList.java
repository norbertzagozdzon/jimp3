package cv;

import java.io.PrintStream;

public class ParagraphWithList {
    private String content;
    UnorderedList uL = new UnorderedList();
    ParagraphWithList(String paragraphText) {
        this.content = paragraphText;
    }
    ParagraphWithList setContent(String content) {
        this.content = content;
        return this;
    }
    void writeHTML(PrintStream out){}
}
