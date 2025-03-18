package se.iths.entity;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastname;
    @NotEmpty
    private String email;
    private String phoneNumber;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Subject> subjects = new HashSet<>();

    public Student(@NotEmpty String firstName, @NotEmpty  String lastName, @NotEmpty String email) {
        this.firstName = firstName;
        this.lastname = lastName;
        this.email = email;
    }

    public Student() {
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.getStudents().add(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
