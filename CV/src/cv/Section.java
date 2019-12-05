package cv;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class Section {
    private String title;
    private List<Paragraph> paragraps = new ArrayList<>();
    Section(String title) {
        this.title = title;
    }
    Section setTitle(String title){
        this.title = title;
        return this;
    }

    Section addParagraph(String paragraphText){
        paragraps.add(new Paragraph(paragraphText));
        return this;
    }

    Section addParagraph(Paragraph p){
        paragraps.add(p);
        return this;
    }
    void writeHTML(PrintStream out){
        out.println("<div>\n<h2>"+title+"</h2>");
        for(Paragraph i:paragraps) {
            i.writeHTML(out);
        }
        out.println("</div>");
    }
}
