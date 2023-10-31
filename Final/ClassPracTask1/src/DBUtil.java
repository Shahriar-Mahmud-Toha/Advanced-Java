import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
enum Gender{
    Male,
    Female
}
public class DBUtil {
    public static List<Person> getAll() {
        LocalDate dateOfBirth1 = LocalDate.of(1991,1,16);
        LocalDate dateOfBirth2 = LocalDate.of(2001,2,5);
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "abc", Gender.Male, dateOfBirth1));
        persons.add(new Person(2, "xyz", Gender.Female, dateOfBirth2));
        return persons;
    }
}