package me.siyoon.dtolisttosettest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class Product {
    private Set<String> name;
}
