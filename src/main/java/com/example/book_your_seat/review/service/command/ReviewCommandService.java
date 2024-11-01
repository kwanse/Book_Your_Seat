package com.example.book_your_seat.review.service.command;


import com.example.book_your_seat.concert.domain.Concert;
import com.example.book_your_seat.concert.repository.ConcertRepository;
import com.example.book_your_seat.review.controller.dto.ReviewCreateReqDTO;
import com.example.book_your_seat.review.controller.dto.ReviewCreateResDTO;
import com.example.book_your_seat.review.domain.Review;
import com.example.book_your_seat.review.repository.ReviewRepository;
import com.example.book_your_seat.user.domain.User;
import com.example.book_your_seat.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.book_your_seat.concert.ConcertConst.INVALID_CONCERT_ID;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewCommandService {

    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;

    private final ConcertRepository concertRepository;


    public ReviewCreateResDTO createReview(Long userId, Long concertId, String content, int startCount){

        User user = getUser(userId);
        Concert concert = getConcert(concertId);

        Review review = Review.from(content, startCount, user, concert);

        Review saveReview = reviewRepository.save(review);

        return ReviewCreateResDTO.from(saveReview);
    }

    private Concert getConcert(Long concertId) {
       return concertRepository.findById(concertId).orElseThrow(() -> new IllegalArgumentException(INVALID_CONCERT_ID + concertId));
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException(INVALID_CONCERT_ID ));
    }


}
