package com.richardcalin.planitpoker.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rooms_seq")
    @SequenceGenerator(name = "rooms_seq", sequenceName = "rooms_SEQ", allocationSize = 1)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;
}
