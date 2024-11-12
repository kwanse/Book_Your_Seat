package com.example.book_your_seat.seat.redis;

import com.example.book_your_seat.reservation.contorller.dto.request.PaymentRequest;
import com.example.book_your_seat.seat.controller.dto.SeatResponse;
import com.example.book_your_seat.seat.domain.Seat;
import com.example.book_your_seat.seat.domain.SeatId;

import java.util.List;

public interface SeatRedisService {
    void cacheSeatIds(SeatResponse response, Long userId);

    void validateSeat(PaymentRequest request, Long userId);

    void deleteCache(final SeatId seatId);
}
