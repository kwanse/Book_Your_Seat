package com.example.book_your_seat.concert.controller;

import com.example.book_your_seat.concert.controller.dto.ConcertListResponse;
import com.example.book_your_seat.concert.controller.dto.ConcertResponse;
import com.example.book_your_seat.concert.controller.dto.ResultRedisConcert;
import com.example.book_your_seat.concert.service.query.ConcertQueryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/concerts")
@RestController
public class ConcertController {

    private final ConcertQueryService concertQueryService;

    @Operation(
            summary = "콘서트를 조회 합니다.",
            description = "concertId로 특정한 콘서트를 조회합니다."
    )
    @GetMapping("/{concertId}")
    public ResponseEntity<ConcertResponse> findConcert(@PathVariable final Long concertId) {
        ConcertResponse response = concertQueryService.findById(concertId);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "모든 콘서트를 조회합니다.",
            description = "존재 하는 모든 콘서트를 조회합니다."
    )
    @GetMapping("/list/{pageNumber}")
    public ResponseEntity<List<ConcertListResponse>> findAllConcertList(
            @PathVariable("pageNumber") int pageNumber
    ){
        List<ConcertListResponse> responses = concertQueryService.findAllConcertList(pageNumber);
        return ResponseEntity.ok(responses);
    }
}
