package clases;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneLog {
	
	public static void main(String[] args) {
		Contact me = new Contact("Griselda","Buenos Aires","555 55 55 55",LocalDate.of(1979, Month.JANUARY, 4));
		Contact martin = new Contact("Martin","Mendoza","666 66 66 66",LocalDate.of(1963, Month.OCTOBER, 14));
		Contact roberto = new Contact("Roberto","Tucuman","888 55 88 55",LocalDate.of(1989, Month.MAY, 25));
		Contact heinz = new Contact("Heinz","Madrid","559 99 95 35",LocalDate.of(1977, Month.MAY, 28));
		Contact michael = new Contact("Michael","Santiago","444 45 44 55",LocalDate.of(1983, Month.JULY, 9));
		
		
		List<PhoneCall> phoneCallLog = Arrays.asList(
				new PhoneCall(heinz, LocalDate.of(2014, Month.MAY, 28), Duration.ofSeconds(1500)),
				new PhoneCall(martin, LocalDate.of(2014, Month.MAY, 18), Duration.ofMinutes(15)),
				new PhoneCall(roberto, LocalDate.of(2014, Month.MAY, 18), Duration.ofMinutes(30)),
				new PhoneCall(michael, LocalDate.of(2014, Month.MAY, 21), Duration.ofMinutes(10)),
				new PhoneCall(michael, LocalDate.of(2014, Month.JUNE, 13), Duration.ofMinutes(7)),
				new PhoneCall(martin, LocalDate.of(2014, Month.JUNE, 21), Duration.ofSeconds(315))
				);
		
		/**************************************PERSONAS A LAS QUE LLAMÉ EN JUNIO**************************/
		
		 phoneCallLog.stream()
				.filter(c -> c.getTime().getMonth() == Month.JUNE)
				.map(c -> c.getContact().getName())
				.distinct()
				.forEach(System.out::println);
		 
		 /********************************SEGUNDOS HABLADOS EN MAYO*****************************************/
		 
		  long total = phoneCallLog.stream()
				 .filter(c -> c.getTime().getMonth() == Month.MAY)
				 .map(PhoneCall::getDuration)
				 .collect(Collectors.summingLong(Duration::getSeconds));
		  System.out.println(total);
		  
		  /********************************SEGUNDOS HABLADOS EN MAYO-OPTIONAL OBJECT*****************************************/
				 
		 Optional<Duration> totalOptional = phoneCallLog.stream()
				 .filter(c -> c.getTime().getMonth() == Month.MAY)
				 .map(PhoneCall::getDuration)
				 .reduce(Duration::plus); // reduce es un acumulador hace esto : n = n + x
		 								 // plus retorna una copia de la duracion con la suma
		 								 // de otra duracion Duration.plus(Duration)
		 
		 totalOptional.ifPresent( duration -> System.out.println(duration.getSeconds()));
		 
		 /**********************LLAME A PARIS******************************************************/
		 
		boolean callToParis =  phoneCallLog.stream()
		 .anyMatch(c -> "Paris".equals(c.getContact().getCity()));
		
		System.out.println(callToParis);
		
		/******************LAS 3 TRES LLAMADAS MAS CORTAS EN MAYO *********************************/
		
		phoneCallLog.stream()
		.filter(c -> c.getTime().getMonth() == Month.MAY)
		.sorted(Comparator.comparing(PhoneCall::getDuration))
		.limit(3)
		.forEach(System.out::println);
		
		/*************LAS TRES LLAMADAS MAS LARGAS EN MAYO*******************************************/
		
		phoneCallLog.stream()
		.filter(c -> c.getTime().getMonth() == Month.MAY)
		.sorted(Comparator.comparing(PhoneCall::getDuration).reversed())
		.limit(3)
		.forEach(System.out::println);
		
		/*****************CREADORES DE STREAMS*************************************************/
		
		/*************DESDE COLECCIONES ***********************************/
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			numbers.add((int) Math.round(Math.random()*100));
			
		Stream<Integer> evenNumber = numbers.stream();
		
		// or parallelStream
		
		Stream<Integer> evenNumber2 = numbers.parallelStream();
		
		/******************DIRECTAMENTE DESDE VALORES ************************/
		Stream.of("Using", "Stream","API","from","Java8");
		
		//can convert parallelStream
		
		Stream.of("Using", "Stream","API","from","Java8").parallel()
		
		//En java8 las interfaces además de métodos por defecto pueden tener metodos estaticos
		
		
		;
		
		}
		
		 
	}

}
