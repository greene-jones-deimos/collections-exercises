package grocery;
import util.Input;

import java.util.HashMap;
import java.util.Scanner;

public class GroceryApp {
    private Scanner scan = new Scanner(System.in)
            .useDelimiter("\n");
    private Input input = new Input();
    private HashMap<String, List> collection = new HashMap<>(){{
        put("Produce", new List("produce"));
        put("Meat", new List("meat"));
        put("Deli", new List("deli"));
        put("Frozen", new List("frozen"));
        put("Grains", new List("grains"));
    }};

    public GroceryApp() {}

    public void startApp(){
        System.out.println("Would you like to create a grocery list?");
        boolean answer = input.getBoolean();
        if(answer) addItem();
        else System.out.println("Goodbye");
    }

    private  void
    addItem(){
        System.out.println("Would you like to add an item?(yes/no)");
        boolean answer = input.getBoolean();
        if(!answer) System.out.println("Goodbye");
        //!categories
        System.out.println("Please choose a category: " +
                "1 : Produce |" +
                "2 : Meat |" +
                "3 : Deli |" +
                "4 : Frozen |" +
                "5 : Grains");
        int department = input.getInt(1,5);
        String stringDep = convertDepartmentToString(department);
        System.out.print("Name of the item: ");
        String name = input.getString();
        System.out.print("Quantity: ");
        Integer quantity = input.getInt();
        collection.forEach((key,value)-> {
            System.out.println(key);
            if(stringDep.equalsIgnoreCase(key)) value.addItem(name, quantity);
        });

    }
    private String
    convertDepartmentToString(int num){
        String stringDep;
        switch(num){
            case 1: stringDep = "produce"; break;
            case 2: stringDep = "meat"; break;
            case 3: stringDep = "deli"; break;
            case 4: stringDep = "frozen"; break;
            case 5: stringDep = "grains"; break;
            default:
                throw new IllegalStateException("Unexpected value: " + num);
        }
        return stringDep;
    }


}
