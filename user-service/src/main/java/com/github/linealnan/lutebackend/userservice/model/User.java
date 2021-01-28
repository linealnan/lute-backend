package com.github.linealnan.lutebackend.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
public class User {
    @NonNull
    @Setter
    @Getter
    String userId;
    @NonNull
    @Setter
    @Getter
    String email;
}
