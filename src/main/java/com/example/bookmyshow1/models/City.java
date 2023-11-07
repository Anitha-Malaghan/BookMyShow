package com.example.bookmyshow1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class City extends BaseModel{
    private  String name;

    @OneToMany(mappedBy = "Theatre")
    private List<Theatre> threatres;
}
