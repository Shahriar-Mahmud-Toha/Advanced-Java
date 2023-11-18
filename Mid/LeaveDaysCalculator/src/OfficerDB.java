import java.util.ArrayList;
        import java.util.List;
        import java.util.stream.Collectors;

public class OfficerDB {

    static List<Officer> officers = new ArrayList<>();

    public static List<Officer> getAll() {
        return officers;
    }
    public static Officer getOfficer(String id){
        Officer flag = null;
        for (Officer i: officers) {
            if(i.getId().equals(id)){
                flag = i;
                break;
            }
        }
        return flag;
    }
    public static void create(Officer o) {
        officers.add(new Officer(o.getId(), o.getName(), o.getDate_of_birth(), o.getEmail(), o.getJoining_date()));
    }

    public static void update(Officer officer) {
        officers.stream()
                .filter(o -> officer.id.equals(o.id))
                .findFirst()
                .ifPresent(o -> {
                    o.name = officer.name;
                    o.date_of_birth = officer.date_of_birth;
                    o.email = officer.email;
                    o.joining_date = officer.joining_date;
                });
    }

    public static void delete(String id) {
        officers = officers.stream()
                .filter(officer -> !id.equals(officer.id))
                .collect(Collectors.toList());
    }
}
