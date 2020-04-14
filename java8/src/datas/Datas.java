package datas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		LocalDate olimpiadasDoRio = LocalDate.of(2016, Month.JUNE, 5);
		
		int anos = hoje.getYear() - olimpiadasDoRio.getYear();
		
		System.out.println(anos);
		
		Period periodo = Period.between(olimpiadasDoRio, hoje);
		System.out.println(periodo);
		System.out.println(String.format("%s anos, %s meses, %s dias", periodo.getYears(),periodo.getMonths(), periodo.getDays()));
		
		
		 LocalDate proximasOlimpiadas = olimpiadasDoRio.plusYears(4);
		 
		 System.out.println(proximasOlimpiadas);
		 
		 DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		 
		 System.out.println(proximasOlimpiadas.format(formatador));
		 
		 
		 LocalDateTime agora = LocalDateTime.now();
		 System.out.println(agora);
		 
		 DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
		 System.out.println(agora.format(formatadorComHoras));
		 
		 
		 
	}
}
