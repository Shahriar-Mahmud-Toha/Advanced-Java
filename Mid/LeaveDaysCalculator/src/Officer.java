import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
public class Officer extends Employee {
    final private int vacation =15;
    final private int sick = 10;
    public Officer(){}
    public Officer(String id, String name, LocalDate date_of_birth, String email, LocalDate joining_date) {
        super(id, name, date_of_birth, email, joining_date);
    }
    public int calculateSickDays() {
        LocalDate endDate = Year.of(LocalDate.now().getYear()).atMonth(12).atEndOfMonth();
        Period p = Period.between(endDate, joining_date);
        return sickDaysCalculator(sick, p);
    }
    public int vacationDaysCalculator() {
        LocalDate endDate = Year.of(LocalDate.now().getYear()).atMonth(12).atEndOfMonth();
        Period p = Period.between(endDate, joining_date);
        return vacationDaysCalculator(vacation, p);
    }
}
