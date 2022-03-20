package com.example.detail_storage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "technics")
public class Technica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    @Check(constraints = "cost >= 0")
    private Double cost;

    private String brand;

    @ManyToMany
    @JoinTable(
            name = "technica_detail",
            joinColumns = @JoinColumn(name = "technica_id"),
            inverseJoinColumns = @JoinColumn(name = "detail_id")
    )
    private Set<Detail> details;


}
