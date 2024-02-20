package ObjectData;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommonObject {

    public List<String> getValueAsList(String value){
        String[] valuesSplit = value.split(",");

        return Arrays.stream(valuesSplit).collect(Collectors.toList());
    }

}
