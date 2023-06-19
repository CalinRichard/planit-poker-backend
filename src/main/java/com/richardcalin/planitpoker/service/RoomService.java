package com.richardcalin.planitpoker.service;

import com.richardcalin.planitpoker.model.entity.Room;
import com.richardcalin.planitpoker.model.entity.User;
import com.richardcalin.planitpoker.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

       public Long createRoom(String name, String description, User user){
        Room room = new Room();
        room.setName(name);
        room.setDescription(description);
        room.setOwner(user);
        Room currentRoom = roomRepository.save(room);
        return currentRoom.getId();
    }
}
