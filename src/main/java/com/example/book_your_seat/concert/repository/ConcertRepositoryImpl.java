package com.example.book_your_seat.concert.repository;

import com.example.book_your_seat.concert.controller.dto.ConcertListResponse;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.QBean;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.example.book_your_seat.concert.domain.QConcert.concert;

@Repository
@RequiredArgsConstructor
public class ConcertRepositoryImpl implements ConcertRepositoryCustom {

    private static final long PAGE_SIZE = 10;
    private final JPAQueryFactory queryFactory;

    @Override
    public List<ConcertListResponse> findAllConcerts(int pageNumber) {

        List<Long> ids = queryFactory.select(concert.id)
                .from(concert)
                .orderBy(concert.id.desc())
                .limit(PAGE_SIZE)
                .offset(pageNumber * PAGE_SIZE)
                .fetch();

        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }


        return queryFactory
                .select(concertListProjection())
                .from(concert)
                .where(concert.id.in(ids))
                .fetch();
    }

    @NotNull
    private QBean<ConcertListResponse> concertListProjection() {
        return Projections.fields(ConcertListResponse.class,
                concert.id,
                concert.title,
                concert.totalStock,
                concert.startDate,
                concert.endDate,
                concert.price,
                concert.startHour,
                concert.reservationStartAt
        );
    }

}
