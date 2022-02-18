package project.usermanager.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="num")
    private Long num;

    @Column(name="id", nullable = false)
    private String id;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="age", nullable = false)
    private int age;

    @Column(name="gender", nullable = false)
    private Gender gender;

    @Column(name="joindate", nullable = false)
    private LocalDateTime joinDate;

    @Column(name="appenddate", nullable = false)
    private LocalDateTime appendDate;

    @Column(name="updatedate", nullable = false)
    private LocalDateTime updateDate;

    @Column(name="state", nullable = false)
    private boolean state;

}
