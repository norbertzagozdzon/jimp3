package cv;

import java.io.PrintStream;

class ParagraphWithList extends Paragraph {
    private String content;
    private UnorderedList uL = new UnorderedList();
    ParagraphWithList() {}
    ParagraphWithList setContent(String content) {
        this.content = content;
        return this;
    }
    ParagraphWithList(String paragraphText) {
        super(paragraphText);
    }
    ParagraphWithList addListItem(String text) {
        uL.add(new ListItem(text));
        return this;
    }
    void writeHTML(PrintStream out){
        if (content!=null) {
            out.println("<p>"+content+"</p>");
        }
        uL.writeHTML(out);
    }
}
