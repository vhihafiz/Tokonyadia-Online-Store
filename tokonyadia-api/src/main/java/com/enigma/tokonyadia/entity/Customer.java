package com.enigma.tokonyadia.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String id;
    private String name;
    private String mobile_phone;
    private String email;
    private String address;
}
