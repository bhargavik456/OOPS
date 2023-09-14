package com.visa.prj.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
    @Builder.Default
    private int id = 0;
    private String name;
    private double price;
    private int quantity;
}
