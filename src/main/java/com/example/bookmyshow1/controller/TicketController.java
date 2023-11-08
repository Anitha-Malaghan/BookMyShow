package com.example.bookmyshow1.controller;

import com.example.bookmyshow1.dto.BookTicketRequestDto;
import com.example.bookmyshow1.dto.BookTicketResponseDto;
import com.example.bookmyshow1.dto.ResponseStatus;
import com.example.bookmyshow1.exception.ShowSeatNotAvailableException;
import com.example.bookmyshow1.models.Ticket;
import com.example.bookmyshow1.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//in a Spring how do you specify it is a controller
@Controller
public class TicketController {
    TicketService ticketService;

    public BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto){

        Ticket ticket = null;
        try {
            ticket = ticketService.bookTicket(bookTicketRequestDto.getUserId(),
                    bookTicketRequestDto.getShowId(),
                    bookTicketRequestDto.getSeatIds());
            BookTicketResponseDto bookTicketResponseDto = new BookTicketResponseDto();
            bookTicketResponseDto.setTicket(ticket);
            bookTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            //bookTicket should return DTO
            return bookTicketResponseDto;
            //check this with catch parameter
        } catch (ShowSeatNotAvailableException e) {
            BookTicketResponseDto bookTicketResponseDto = new BookTicketResponseDto();
            bookTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            //bookTicket should return DTO
            return bookTicketResponseDto;
        }

    }
}
