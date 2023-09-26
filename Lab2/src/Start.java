/*
* Name: Md. Shahriar Mahmud
* ID: 21-44498-1
* */
import java.time.LocalDate;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {

        System.out.println("Enter your name: ");
        Scanner sc1 = new Scanner(System.in);
        String name = sc1.nextLine();
        System.out.println("Enter your ID: ");
        Scanner sc2 = new Scanner(System.in);
        String id = sc2.nextLine();
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

        Person p = new Person(name, id, dob);
        p.getDetails();
        System.out.println(p.calculateDate(LocalDate.now()));
    }
}
