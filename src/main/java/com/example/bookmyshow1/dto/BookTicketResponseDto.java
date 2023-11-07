package com.example.bookmyshow1.dto;

import com.example.bookmyshow1.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDto {
    private Ticket ticket;
    private ResponseStatus responseStatus;
}
