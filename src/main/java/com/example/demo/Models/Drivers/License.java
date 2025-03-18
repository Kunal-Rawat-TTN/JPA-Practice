package com.example.demo.Models.Drivers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String type;

    @Temporal(TemporalType.DATE)
    Date validFrom;

    @Temporal(TemporalType.DATE)
    Date validTo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    Person person;

    public License(String type, Date validFrom, Date validTo){
        this.validFrom=validFrom;
        this.validTo=validTo;
        this.type=type;
    }
}
