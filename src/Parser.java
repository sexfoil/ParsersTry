import java.util.*;

public class Parser {

    public static List<FilterCondition> getFilterConditions(String string) {
        List<FilterCondition> list = new ArrayList<>();
        String[] conditionsParts = string.split("(&&)|(\\|\\|)");
        for (String str : conditionsParts) {
            int attrIndex = str.indexOf(".a.");
            if (attrIndex > 0) {
                str = str.substring(attrIndex + 2);
            }
            str = str.trim().replaceAll("(\\(*\\.v*)|(\\))|(\")", "");
            String[] part = str.split(" ");
            FilterCondition fc = new FilterCondition(part[0].trim(), part[1].trim().equals("=="), part[2].trim());
            list.add(fc);
        }
        return list;
    }
}
