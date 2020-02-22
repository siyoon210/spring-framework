package me.siyoon.simplechat;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class EnteringUserResponse {
    private String name;

    @Builder
    public EnteringUserResponse(String name) {
        this.name = name;
    }
}
