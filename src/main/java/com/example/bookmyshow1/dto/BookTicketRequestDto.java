package com.example.bookmyshow1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookTicketRequestDto {
    private long userId;
    private long showId;
    private List<Long> seatIds;
}
