package com.example.bookmyshow1.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

import java.util.Date;
import java.util.List;

public class Show  {
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
