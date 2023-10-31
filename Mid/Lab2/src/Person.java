/*
 * Name: Md. Shahriar Mahmud
 * ID: 21-44498-1
 * */
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    private String name;
    private String id;
    private LocalDate dob;

    public Person(String name, String id, LocalDate dob){
        this.name = name;
        this.id =id;
        this.dob = dob;
    }
    public void getDetails(){
        System.out.println("Name: "+name);
        System.out.println("ID: "+id);
        System.out.println("Date of Birth: "+dob.format(DateTimeFormatter.ofPattern("dd MMM, yyyy")));
        System.out.print("Difference between from today to your birth day is: ");
    }
    public String calculateDate(LocalDate currentDate){
        Period p = Period.between(currentDate, dob);
       return Math.abs(p.getYears()) + " Years " + Math.abs(p.getMonths()) + " Month " + Math.abs(p.getDays()) + " Days ";
    }
}
