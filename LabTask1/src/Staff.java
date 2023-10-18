import java.time.LocalDate;
import java.time.Period;
import java.time.Year;

public class Staff implements Employee{
    public String id;
    public String name;
    public LocalDate date_of_birth;
    public String email;
    public LocalDate joining_date;
    final private int Vacation =10;
    final private int sick = 7;
    public Staff(){}

    public Staff(String id, String name, LocalDate date_of_birth, String email, LocalDate joining_date) {
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
    public void showDetails(){
        System.out.println();
        System.out.println("--------------------------------------------");
        System.out.println("Position: Staff");
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Date of Birth: "+date_of_birth);
        System.out.println("Email: "+email);
        System.out.println("Joining Date: "+joining_date);
        System.out.println("Vacation Leave: "+vacationDaysCalculator());
        System.out.println("Sick Leave: "+sickDaysCalculator());
        System.out.println();
    }
    @Override
    public int sickDaysCalculator() {
        LocalDate endDate = Year.of(LocalDate.now().getYear()).atMonth(12).atEndOfMonth();
        Period p = Period.between(endDate, joining_date);
        int flag = 0;
        double temp = Math.abs(p.getDays())+1.0;
        int totalDaysInYear = Year.of(LocalDate.now().getYear()).length();
        double res = (temp)*sick/totalDaysInYear;
        if(res<0.5){
            flag = (int)Math.floor(res);
        }
        if(res>0.5){
            flag = (int)Math.ceil(res);
        }
        return flag;
    }

    @Override
    public int vacationDaysCalculator() {
        LocalDate endDate = Year.of(LocalDate.now().getYear()).atMonth(12).atEndOfMonth();
        Period p = Period.between(endDate, joining_date);
        int flag = 0;
        double temp = Math.abs(p.getDays())+1.0;
        int totalDaysInYear = Year.of(LocalDate.now().getYear()).length();
        double res = (temp)*Vacation/totalDaysInYear;
        if(res<0.5){
            flag = (int)Math.floor(res);
        }
        if(res>0.5){
            flag = (int)Math.ceil(res);
        }
        return flag;
    }
}
