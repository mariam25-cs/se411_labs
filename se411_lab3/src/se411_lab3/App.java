package se411_lab3;

import java.util.List;
import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] names = {"Mariam", "Sara", "Noura"};
		PrintableList<String> stringList = new PrintableList<>(names);
		stringList.printItems();

		Integer[] numbers = {10, 20, 30};
		PrintableList<Integer> intList = new PrintableList<>(numbers);
		intList.printItems();
		
		NumberBox<Integer> intBox = new NumberBox<>();
		intBox.setItem(50);
		System.out.println("Item: " + intBox.getItem());
		System.out.println("Sum:  " + intBox.sum(10));    // 60.0

		NumberBox<Double> doubleBox = new NumberBox<>();
		doubleBox.setItem(3.5);
		System.out.println("Item: " + doubleBox.getItem());
		System.out.println("Sum:  " + doubleBox.sum(1.5)); // 5.0
		
		
		List<String> words = Arrays.asList("apple", "banana", "cherry");
		printList(words);

		List<Integer> nums = Arrays.asList(1, 2, 3, 4);
		System.out.println("Total: " + sumNumbers(nums));   // 10.0

	}
	
	
	public static void printList(List<?> list) {
	    for (Object item : list) {
	        System.out.println(item);
	    }
	}

	public static double sumNumbers(List<? extends Number> list) {
	    double total = 0;
	    for (Number n : list) {
	        total += n.doubleValue();
	    }
	    return total;
	}

}
