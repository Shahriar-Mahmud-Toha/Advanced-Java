import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

public class Employee {
    public String id;
    public String name;
    public LocalDate date_of_birth;
    public String email;
    public LocalDate joining_date;

    public Employee(){}

    public Employee(String id, String name, LocalDate date_of_birth, String email, LocalDate joining_date) {
        this.id = id;
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.joining_date = joining_date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJoining_date(LocalDate joining_date) {
        this.joining_date = joining_date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getJoining_date() {
        return joining_date;
    }
    public int sickDaysCalculator(int sickDays, Period period) {
        int flag = 0;
        double temp = Math.abs(period.getDays())+1.0;
        int totalDaysInYear = Year.of(LocalDate.now().getYear()).length();
        double res = (temp)*sickDays/totalDaysInYear;
        if(res<0.5){
            flag = (int)Math.floor(res);
        }
        if(res>0.5){
            flag = (int)Math.ceil(res);
        }
        return flag;
    }

    public int vacationDaysCalculator(int vacationDays, Period period) {
        int flag = 0;
        double temp = Math.abs(period.getDays())+1.0;
        int totalDaysInYear = Year.of(LocalDate.now().getYear()).length();
        double res = (temp)*vacationDays/totalDaysInYear;
        if(res<0.5){
            flag = (int)Math.floor(res);
        }
        if(res>0.5){
            flag = (int)Math.ceil(res);
        }
        return flag;
    }
}
