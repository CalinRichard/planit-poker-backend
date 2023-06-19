package com.richardcalin.planitpoker.repository;

import com.richardcalin.planitpoker.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
