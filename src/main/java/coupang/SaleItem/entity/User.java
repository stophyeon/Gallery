package coupang.SaleItem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue
    Long id;
    @Column(name = "username")
    String userName;
    @Size(min=7)
    @Column(name = "password")
    String password;
    @Email
    @Column(name = "email")
    String email;
    @Pattern(regexp="^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$")
    @Column(name = "phoneNumber")
    String phoneNumber;
}
