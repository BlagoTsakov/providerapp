package com.example.providerapp.entity;

import java.time.Instant;

public interface IEntity {
    String getId();
    Instant getCreatedAt();
}
