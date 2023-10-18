import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<Officer> officers = new Vector<Officer>(3);
        Vector<Staff> staffs = new Vector<Staff>(3);
        boolean flag = true;
        while (flag){
            System.out.println("Select your Post ->");
            System.out.println("Enter \"1\" for Officer");
            System.out.println("Enter \"2\" for Staff");
            Scanner sc_ = new Scanner(System.in);
            int choice = sc_.nextInt();

            System.out.println("Enter your ID: ");
            Scanner sc2 = new Scanner(System.in);
            String id = sc2.nextLine();

            System.out.println("Enter your Name: ");
            Scanner sc1 = new Scanner(System.in);
            String name = sc1.nextLine();

            System.out.println("Enter your Date of Birth -> ");
            System.out.println("Enter Year: ");
            Scanner sc3 = new Scanner(System.in);
            int year = sc3.nextInt();
            System.out.println("Enter Month: ");
            Scanner sc4 = new Scanner(System.in);
            int month = sc4.nextInt();
            System.out.println("Enter Date: ");
            Scanner sc5 = new Scanner(System.in);
            int date = sc5.nextInt();
            LocalDate dob = LocalDate.of(year,month,date);

            System.out.println("Enter your Email: ");
            Scanner sc6 = new Scanner(System.in);
            String email = sc6.nextLine();

            System.out.println("Enter your Joining Date -> ");
            System.out.println("Enter Year: ");
            Scanner sc7 = new Scanner(System.in);
            int year1 = sc7.nextInt();
            System.out.println("Enter Month: ");
            Scanner sc8 = new Scanner(System.in);
            int month1 = sc8.nextInt();
            System.out.println("Enter Date: ");
            Scanner sc9 = new Scanner(System.in);
            int date1 = sc9.nextInt();
            LocalDate joiningDate = LocalDate.of(year1,month1,date1);

            //close loop
            System.out.println("Press '=' to stop taking input\nPress Enter twice to continue taking input\n");
            Scanner exitInput = new Scanner(System.in);
            String input = exitInput.nextLine();
            if(input.equals("=")){
                flag = false;
            }

            switch (choice){
                case 1:
                {
                    Officer o = new Officer(id,name,dob,email,joiningDate);
                    officers.add(o);
                    break;
                }
                case 2:
                {
                    Staff s = new Staff(id,name,dob,email,joiningDate);
                    staffs.add(s);
                    break;
                }
                default:
                    break;
            }
        }
        if(!officers.isEmpty()){
            for (var i:officers){
                i.showDetails();
            }
        }
        if(!staffs.isEmpty()){
            for (var i:staffs){
                i.showDetails();
            }
        }
    }
}