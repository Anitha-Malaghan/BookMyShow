package com.example.bookmyshow1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel  {
    private  String name;
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Auditorium auditorium;
    @ManyToOne
    private Movie movie;
    private String language;
    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> showFeatures;
}
