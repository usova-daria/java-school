package com.javaschool.entity.user;

import com.javaschool.entity.address.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "user")
@NamedQuery(
        name = "findUserWithEmail",
        query = "SELECT u from User u where u.email = :userEmail"
)
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "first_name")
    @Size(min = 1, max = 45)
    @NotNull
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 1, max = 45)
    @NotNull
    private String lastName;

    @Column(name = "email")
    @NotNull
    @Email
    private String email;

    @Column(name = "password")
    @Size(max = 80)
    @NotNull
    private String password;

    @Column(name = "birthday")
    @NotNull
    private LocalDate birthday;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_info_id", referencedColumnName = "customer_info_id")
    private CustomerInfo customerInfo;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                       CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                       CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "customer_has_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> addresses;

    public User(@Size(min = 1, max = 45) @NotNull String firstName,
                @Size(min = 1, max = 45) @NotNull String lastName,
                @NotNull @Email String email,
                @Size(max = 80) @NotNull String password,
                @NotNull LocalDate birthday,
                CustomerInfo customerInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.customerInfo = customerInfo;
    }


}
