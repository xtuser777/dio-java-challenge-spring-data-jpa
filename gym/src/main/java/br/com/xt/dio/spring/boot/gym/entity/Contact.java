package br.com.xt.dio.spring.boot.gym.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 14)
    private String phone;

    @Column(nullable = false, length = 15)
    private String cellphone;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

}
