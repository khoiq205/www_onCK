package com.example.cuoiki.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "candidate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(length = 15)
    private String phone;
    private String email;
    @OneToMany(mappedBy = "candidate", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Experience> experiences;
}
