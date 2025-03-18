package com.example.demo.Models.Development;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@IdClass(ProgrammerId.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nsrId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pId;

    private String name;
    private Integer salary;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "programmers_projects",
            joinColumns = {
                    @JoinColumn(name = "programmer_id", referencedColumnName = "pId"),
//                    @JoinColumn(name = "nsr_id", referencedColumnName = "nsrId"),
            },
            inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"))
    private Set<Project> projects;
}
