package com.example.book_your_seat.service.seat;

import com.example.DbCleaner;
import com.example.book_your_seat.IntegralTestSupport;
import com.example.book_your_seat.concert.controller.dto.AddConcertRequest;
import com.example.book_your_seat.concert.service.command.ConcertCommandService;
import com.example.book_your_seat.seat.controller.dto.SeatResponse;
import com.example.book_your_seat.seat.service.facade.SeatFacade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

class SeatQueryServiceTest extends IntegralTestSupport {

    @Autowired
    DbCleaner dbCleaner;

    @Autowired
    private ConcertCommandService concertCommandService;
    @Autowired
    private SeatFacade seatFacade;

    @AfterEach
    void tearDown() {
        dbCleaner.cleanDatabase();
    }

    @Test
    void findAllSeatsTest() {
        AddConcertRequest request = new AddConcertRequest(
                "제목1",
                LocalDate.of(2024, 9, 24),
                LocalDate.of(2024, 9, 25),
                10000,
                20
        );

        Long concertId = concertCommandService.add(request);
        SeatResponse response = seatFacade.findAllSeats(concertId);
        Assertions.assertThat(response).isNotNull();
    }
}
