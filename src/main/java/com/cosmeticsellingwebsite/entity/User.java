package com.cosmeticsellingwebsite.entity;

import com.cosmeticsellingwebsite.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "[User]")
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;
    @Column(unique = true)
    protected String username;
    protected String password;
    @Column(unique = true)
    protected String email;
    protected String fullname;
    protected String phone;
    @Enumerated(EnumType.STRING)
    protected Gender gender;
    protected String image;

    protected Boolean active = true;

    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    protected Role role;
}
