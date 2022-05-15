package com.example.detail_storage.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import javax.persistence.CascadeType;
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
@Setter
@Entity
@NoArgsConstructor
@Table(name = "details")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    @Check(constraints = "cost >= 0")
    private Double cost;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "details_technics",
            joinColumns = {@JoinColumn(name = "DETAIL_ID")},
            inverseJoinColumns = {@JoinColumn(name = "TECHNICA_ID")}

    )
    private Set<Technica> technics;

}
