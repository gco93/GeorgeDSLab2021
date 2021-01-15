package array_list;

import java.util.ArrayList;

public class TestJavaArrayList {

    public static void main(String[] args) {
        // Create a list to store cities
        ArrayList<String> cityList = new ArrayList<>();

        // Add some cities in the list
        cityList.add("London");
        // cityList now contains [London]
        cityList.add("Denver");
        // cityList now contains [London, Denver]
        cityList.add("Paris");
        // cityList now contains [London, Denver, Paris]
        cityList.add("Miami");
        // cityList now contains [London, Denver, Paris, Miami]
        cityList.add("Seoul");
        // contains [London, Denver, Paris, Miami, Seoul]
        cityList.add("Tokyo");
        // contains [London, Denver, Paris, Miami, Seoul, Tokyo]

        // Display the contents in the list
        System.out.println(cityList.toString());

        System.out.println("List size? " + cityList.size());
        System.out.println("Is Miami in the list? "
                + cityList.contains("Miami"));
        System.out.println("The location of Denver in the list? "
                + cityList.indexOf("Denver"));
        System.out.println("Is the list empty? "
                + cityList.isEmpty()); // Print false

        // Insert a new city at index 2
        cityList.add(2, "Xian");
        // contains [London, Denver, Xian, Paris, Miami, Seoul, Tokyo]

        System.out.println("Adding Xian to index 2 of city list.");
        cityList.toString();

        // Remove a city from the list
        cityList.remove("Miami");
        // contains [London, Denver, Xian, Paris, Seoul, Tokyo]

        System.out.println("Removing Miami from list.");
        cityList.toString();

        // Remove a city at index 1
        cityList.remove(1);
        // contains [London, Xian, Paris, Seoul, Tokyo]

        System.out.println("Removing city at index 1.");
        cityList.toString();

        System.out.println("Displaying list in reverse order.");
        // Display the contents in the list in reverse order
        for (int i = cityList.size() - 1; i >= 0; i--) {
            System.out.print(cityList.get(i) + " ");
        }
        System.out.println();
    }
}
