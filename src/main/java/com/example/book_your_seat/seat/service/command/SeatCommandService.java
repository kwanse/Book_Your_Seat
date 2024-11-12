package com.example.book_your_seat.seat.service.command;

import com.example.book_your_seat.reservation.domain.Reservation;
import com.example.book_your_seat.seat.SeatConst;
import com.example.book_your_seat.seat.controller.dto.SeatResponse;
import com.example.book_your_seat.seat.controller.dto.SelectSeatRequest;
import com.example.book_your_seat.seat.domain.Seat;
import com.example.book_your_seat.seat.repository.SeatRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.book_your_seat.seat.SeatConst.SEAT_SOLD;

@Component
@RequiredArgsConstructor
@Transactional
@Primary
@Slf4j
public class SeatCommandService {

    private final SeatRepository seatRepository;

    public SeatResponse selectSeat(final SelectSeatRequest request) {
        int affectedRows = seatRepository.reserveSeat(request.concertId(), request.seatNumbers());
        if (affectedRows != request.seatNumbers().size()) {
            throw new IllegalArgumentException(SEAT_SOLD);
        }
        return new SeatResponse(request.concertId(), request.seatNumbers());
    }
}
