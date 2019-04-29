import java.util.List;
import java.util.Map;

public class FilterCondition {

    private String name;
    private String value;
    private boolean isEqual;

    public FilterCondition(String name, boolean isEqual, String value) {
        this.name = name;
        this.isEqual = isEqual;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public boolean isEqual() {
        return isEqual;
    }
}
