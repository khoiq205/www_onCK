package com.example.cuoiki.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "experience")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "to_date")
    private LocalDate toDate;
    @Column(name = "company")
    private String companyName;
    @Column(name = "work_desc",length = 400)
    private String workDescription;
    private Roles role;
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", companyName='" + companyName + '\'' +
                ", workDescription='" + workDescription + '\'' +
                ", role=" + role +
                '}';
    }
}
