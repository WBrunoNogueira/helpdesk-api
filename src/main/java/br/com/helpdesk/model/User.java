package br.com.helpdesk.model;

import br.com.helpdesk.model.enums.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(
            name = "functional_code",
            nullable = false,
            unique = true,
            length = 30
    )
    private String functionalCode;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false, length = 100)
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRole role;

    public User() {
    }

    public User(
            String name,
            String functionalCode,
            String phone,
            String location,
            UserRole role
    ) {
        this.name = name;
        this.functionalCode = functionalCode;
        this.phone = phone;
        this.location = location;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunctionalCode() {
        return functionalCode;
    }

    public void setFunctionalCode(String functionalCode) {
        this.functionalCode = functionalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
