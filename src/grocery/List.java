package grocery;

import java.util.HashMap;

public class List {
    private String name;
    private HashMap<String, Integer> groceryList = new HashMap<>();

    public List(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void
    addItem(String item, Integer amount){
        groceryList.forEach((key,value)-> {
            if(!key.equalsIgnoreCase(item)) groceryList.put(item, amount);
            else value++;
            System.out.println(value + key+"s on your list");
        });
    }
}
