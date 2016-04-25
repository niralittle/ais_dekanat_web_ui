package com.kma.ais_dekanat.service;

import com.kma.ais_dekanat.dao.GenericDAO;
import com.kma.ais_dekanat.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by denysburlakov on 07.02.16.
 */
@Service
public class RoomService {
    @Autowired
    GenericDAO genericDAO;

    @Transactional
    public List<Room> getAllRooms(){
        return genericDAO.getAll(Room.class);
    }

    @Transactional
    public void createRoom(Room room){
        genericDAO.save(room);
    }

    @Transactional
    public Room getRoomById(int id) {
        return genericDAO.get(Room.class, id);
    }

    @Transactional
    public void deleteRoom(Room room) {
        genericDAO.delete(room);
    }
}
