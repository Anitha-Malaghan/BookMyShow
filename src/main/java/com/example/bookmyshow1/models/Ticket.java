package com.example.bookmyshow1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    @ManyToOne
    private User bookedBy;

    @ManyToOne
    private Show show;

    @OneToMany
    private List<ShowSeat> showSeats;
    private double totalAmount;


    @Enumerated(EnumType.ORDINAL)
    private TicketStatus ticketStatus;

    private Date timeOfBooking;

    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;
}
