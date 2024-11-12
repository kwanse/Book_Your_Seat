package com.example.book_your_seat.concert.repository;

import com.example.book_your_seat.concert.controller.dto.ConcertListResponse;

import java.util.List;

public interface ConcertRepositoryCustom {
    List<ConcertListResponse> findAllConcerts(int pageNumber);
}
