package cv;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class UnorderedList {
    private List<ListItem> unorderedList = new ArrayList<>();
    UnorderedList add(ListItem item) {
        unorderedList.add(item);
        return this;
    }
    void writeHTML(PrintStream out) {
        out.println("<ul>");
        for(ListItem i:unorderedList) {
            i.writeHTML(out);
        }
        out.println("</ul>");
    }
}
