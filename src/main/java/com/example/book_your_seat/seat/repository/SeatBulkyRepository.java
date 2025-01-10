package com.example.book_your_seat.seat.repository;

import com.example.book_your_seat.seat.domain.Seat;

import java.util.List;

public interface SeatBulkyRepository {

    void insertBulkSeats(List<Seat> seats);
}
