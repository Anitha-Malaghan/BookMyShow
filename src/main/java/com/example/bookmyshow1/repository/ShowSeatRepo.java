package com.example.bookmyshow1.repository;

import com.example.bookmyshow1.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;
import java.util.List;

public interface ShowSeatRepo extends JpaRepository<ShowSeat, Long> {

    public Optional<ShowSeat> findById(Long showSeatId);
    //JPA handling implementation of the query: Select * from show_seat where id = ?

    @Lock(LockModeType.PESSIMISTIC_READ)
    public List<ShowSeat> findAllByIdIn(List<Long> showSeatIds);
    //select * from show_seat where id in(?, ?, ?)

    //public List<ShowSeat> findAllByIdInWithoutLock(List<Long> showSeatIds);

    //return null - NPE check
    //Optional is a wrapper which enforces to do the null check

}
