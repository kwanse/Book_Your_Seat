package com.example.book_your_seat;

import com.example.book_your_seat.concert.domain.Concert;
import com.example.book_your_seat.concert.repository.ConcertRepository;
import com.example.book_your_seat.concert.service.command.ConcertCommandService;
import com.example.book_your_seat.seat.domain.Seat;
import com.example.book_your_seat.seat.domain.SeatId;
import com.example.book_your_seat.seat.repository.SeatRepository;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import static com.example.book_your_seat.concert.ConcertConst.TOTAL_STOCK;

@RequiredArgsConstructor
@Component
public class Setup {

    private final ConcertRepository concertRepository;
    private final SeatRepository seatRepository;

    /*@EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void insertDummyData() {

        for (int i = 0; i < 1000; i++) {
            Concert concert = new Concert(
                    "title" + i,
                    LocalDate.now().plusDays(5),
                    LocalDate.now().plusDays(15),
                    10000,
                    14
            );

            concertRepository.save(concert);

            List<Seat> seats = IntStream.rangeClosed(1, TOTAL_STOCK)
                    .mapToObj(index -> new SeatId(concert.getId(), (long) index))
                    .map(Seat::new)
                    .toList();
            seatRepository.insertBulkSeats(seats);
        }


    }
*/

    /*@PreDestroy
    @Transactional
    public void removeDummyData() {
        seatRepository.deleteAll();
        concertRepository.deleteAll();
    }*/


}
