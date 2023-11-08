package com.example.bookmyshow1.service;

import com.example.bookmyshow1.exception.ShowSeatNotAvailableException;
import com.example.bookmyshow1.models.ShowSeat;
import com.example.bookmyshow1.models.ShowSeatState;
import com.example.bookmyshow1.models.Ticket;
import com.example.bookmyshow1.models.User;
import com.example.bookmyshow1.repository.ShowSeatRepo;
import com.example.bookmyshow1.repository.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private ShowSeatRepo showSeatRepo;
    private UserRepo userRepo;
    public TicketService(ShowSeatRepo showSeatRepo){
        this.showSeatRepo = showSeatRepo;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(long userId, long showId, List<Long> seatIds)
            throws ShowSeatNotAvailableException {


        //step 1: Fetch show seats from list of show seats ids without the lock :
        //doubt calling repo to get all the seat ids this method in repo has pessimistic lock
        List<ShowSeat> showSeats = showSeatRepo.findAllById(seatIds);

        //step 2: Fetch the status of show seats
        //step 3: if any of the show seats are not available, then throw an exception

        for(ShowSeat showSeat: showSeats){
            if(showSeat.getState()!= ShowSeatState.AVAILABLE){
                //throw exception
                throw new ShowSeatNotAvailableException(showSeat.getId());
            }
        }
        //step 1: Fetch show seats from list of show seats ids with the lock
        showSeats = showSeatRepo.findAllById(seatIds);

        //step:Lock the showSeats
        for(ShowSeat showSeat : showSeats){
            showSeat.setState(ShowSeatState.LOCKED);
            showSeatRepo.save(showSeat);
        }


        //payment will happen before booking the ticket.

        //step 4: if all the show seats are available, then book the ticket
        for(ShowSeat showSeat : showSeats){
            showSeat.setState(ShowSeatState.BOOKED);
            showSeatRepo.save(showSeat);
        }
        //Step 5:Return the ticket
        Ticket ticket = new Ticket();
        Optional<User> user = userRepo.findUserById(userId);
        if(user.isPresent()){
            //
        }
        ticket.setBookedBy(user.get());
        //set all the value of ticket
        return ticket;

    }
}
