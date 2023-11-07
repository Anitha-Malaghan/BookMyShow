package com.example.bookmyshow1.controller;

import com.example.bookmyshow1.dto.BookTicketRequestDto;
import com.example.bookmyshow1.dto.BookTicketResponseDto;
import org.springframework.stereotype.Controller;

//in a Spring how do you specify it is a controller
@Controller
public class TicketController {

    public BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto){
        //bookTicket should return DTO
        return null;

    }
}
