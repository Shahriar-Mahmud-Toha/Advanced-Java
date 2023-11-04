import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StaffDB {
    static List<Staff> staffs = new ArrayList<>();

    public static List<Staff> getAll() {
        return staffs;
    }
    public static Staff getStaff(String id){
        Staff flag = null;
        for (Staff i: staffs) {
            if(i.getId().equals(id)){
                flag = i;
                break;
            }
        }
        return flag;
    }
    public static void create(Staff staff) {
        staffs.add(new Staff(staff.id, staff.name, staff.date_of_birth, staff.email, staff.joining_date));
    }

    public static void update(Staff staff) {
        staffs.stream()
                .filter(s -> staff.id.equals(s.id))
                .findFirst()
                .ifPresent(s -> {
                    s.name = staff.name;
                    s.date_of_birth = staff.date_of_birth;
                    s.email = staff.email;
                    s.joining_date = staff.joining_date;
                });
    }

    public static void delete(String id) {
        staffs = staffs.stream()
                .filter(staff -> !id.equals(staff.id))
                .collect(Collectors.toList());
    }
}
