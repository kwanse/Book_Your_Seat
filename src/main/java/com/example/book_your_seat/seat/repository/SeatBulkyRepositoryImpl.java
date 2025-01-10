package com.example.book_your_seat.seat.repository;

import com.example.book_your_seat.seat.domain.Seat;
import com.kwanse.bulky.BulkyTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SeatBulkyRepositoryImpl implements SeatBulkyRepository {

    private final BulkyTemplate bulkyTemplate;

    @Override
    public void insertBulkSeats(List<Seat> seats) {
        bulkyTemplate.batchInsert(seats);
    }
}