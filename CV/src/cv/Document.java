package cv;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Document {
    String title;
    Photo photo;
    List<Section> sections = new ArrayList<>();
    Document(String title) {
        this.title = title;
    }
    Document setTitle(String title){
        this.title = title;
        return this;
    }

    Document setPhoto(String photoUrl){
        this.photo = new Photo(photoUrl);
        return this;
    }

    Section addSection(String sectionTitle){
        Section temp = new Section(sectionTitle);
        sections.add(temp);
        return temp;
    }
    Document addSection(Section s){
        sections.add(s);
        return this;
    }

    void writeHTML(PrintStream out){
        out.println("<html>\n<head>\n</head>\n<body>");
        out.println("<h1>"+title+"</h1>");
        photo.writeHTML(out);
        for(Section i:sections) {
            i.writeHTML(out);
        }
        out.println("</body>\n</html>");
    }

    public static void main(String[] args) {
        Document cv = new Document("Jana Kowalski - CV");
        cv.setPhoto("zdjecieCV.png");
        cv.addSection("Wykształcenie")
                .addParagraph("2000-2005 Przedszkole im. Królewny Snieżki w ...")
                .addParagraph("2006-2012 SP7 im Ronalda Regana w ...")
                .addParagraph("...");
        cv.addSection("Umiejętności")
                .addParagraph(
                        new ParagraphWithList().setContent("Umiejętności")
                                .addListItem("C")
                                .addListItem("C++")
                                .addListItem("Java")
                );
        //cv.writeHTML(System.out);
        try {
            cv.writeHTML(new PrintStream("cv.html", "ISO-8859-2"));
        }
        catch (Exception e){}
    }
}
