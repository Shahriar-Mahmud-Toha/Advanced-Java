package dev.domain;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.*;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.*;
import java.time.LocalDate;
@Entity
@Table(name = "studenttb")
public class Student {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @NotNull
    private int Id;
    @NotNull
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @NotNull
    @Size(max = 100)
    @Pattern(regexp = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message = "Incorrect email format")
    @Column(name = "email")
    private String email;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "dateOfBirth")
    private LocalDate dateOfBirth;
    @AssertTrue(message = "Age must be greater than or equal to 18")

    boolean isDateOfBirthValid() {
        if (dateOfBirth == null) {
            return false;  // Return false if dateOfBirth is null
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate eighteenYearsAgo = currentDate.minusYears(18);
        boolean flag = dateOfBirth.isBefore(eighteenYearsAgo) || dateOfBirth.equals(eighteenYearsAgo);

        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getSession();

        if (!flag) {
            session.setAttribute("dateOfBirthValidationMsg", "Date of birth must be greater than or equal to 18");
        }else {
            session.setAttribute("dateOfBirthValidationMsg", "");
        }
        return flag;
    }
    @NotNull
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "quota")
    private String quota = "N/A";
    @NotNull
    @Column(name = "country")
    private String country;

    public Student() {
    }

    // Constructor excluding ID
    public Student(String name, String email, LocalDate dateOfBirth, Gender gender, String quota, String country) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.quota = quota;
        this.country = country;
    }
    //without ID
    public Student(int id, String name, String email, LocalDate dateOfBirth, Gender gender, String quota, String country) {
    this.Id = id;
    this.name = name;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.gender = gender;
    this.quota = quota;
    this.country = country;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getQuota() {
        return quota;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
