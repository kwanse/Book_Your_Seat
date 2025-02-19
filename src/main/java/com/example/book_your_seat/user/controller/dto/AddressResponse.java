package com.example.book_your_seat.user.controller.dto;

import com.example.book_your_seat.user.domain.Address;
import lombok.Getter;

@Getter
public final class AddressResponse {

    private final String postcode;

    private final String detail;

    public AddressResponse(String postcode, String detail) {
        this.postcode = postcode;
        this.detail = detail;
    }

    public static AddressResponse from(Address address) {
        return new AddressResponse(address.getPostcode(), address.getDetail());
    }
}
