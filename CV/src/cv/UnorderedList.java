package cv;

import java.util.ArrayList;
import java.util.List;

public class UnorderedList {
    List<ListItem> unorderedList = new ArrayList<>();
    UnorderedList add(ListItem item) {
        unorderedList.add(item);
        return this;
    }
}
