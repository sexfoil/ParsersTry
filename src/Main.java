import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream is = Main.class.getResourceAsStream("/rule.json");
        Map<String, String> recordFilters = JsonPath.read(is, "$.recordFilters");
        Map<String, List<FilterCondition>> filters = new HashMap<>();

        for (Map.Entry<String, String> map : recordFilters.entrySet()) {
            filters.put(map.getKey(), Parser.getFilterConditions(map.getValue()));
        }

        for (Map.Entry<String, List<FilterCondition>> map : filters.entrySet()) {
            System.out.println("\n[recordFilters] = " + map.getKey());
            for (FilterCondition item : map.getValue()) {
                System.out.println("Should field name: '" + item.getName()
                        + "' equal field value: '" + item.getValue()
                        + "' ? Answer: " + item.isEqual());
            }
        }

    }
}
