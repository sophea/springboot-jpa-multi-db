package com.sma.backend.multidb.database.sqlserver.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Data
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String isoCode;

}
