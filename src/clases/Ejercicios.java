package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Ejercicios {
		
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();	
		for(int i=0; i < 100;i++){
			numbers.add(i);
		}
		
		
		/*****************NUMEROS PARES-Multiplicarlos************************************/
		
		List<Integer> evenNumbers = numbers.stream()
				.filter(n -> n % 2 == 0)
				.map(n -> n*2)
				.collect(Collectors.toList());
	}//main 

}
