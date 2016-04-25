package com.kma.ais_dekanat.controller;

import com.kma.ais_dekanat.model.Room;
import com.kma.ais_dekanat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 25.04.2016 7:40.
 */
@Controller
public class RoomsController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public String getRoom (Model model) {
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "/rooms";
    }


    @RequestMapping(value = "/createRoom", method = RequestMethod.POST)
    public String createRoom(Model model, @ModelAttribute("newRoom") Room newRoom) {
        if (newRoom.getName().length()<1) {
            model.addAttribute("error","Fill all fields");
            List<Room> rooms = roomService.getAllRooms();
            model.addAttribute("rooms", rooms);
            return "/rooms";
        }
        roomService.createRoom(newRoom);
        return "redirect:/rooms";
    }

    @RequestMapping(value = "/createRoom", method = RequestMethod.GET)
    public String getCreateRoomPage(Model model, HttpServletRequest request) {
        return "/createRoom";
    }


    @RequestMapping(value = "/deleteRoom/{id}", method = RequestMethod.GET)
    public String deleteRoom(Model model, @PathVariable int id) {
        //TODO: add method delete by id
        try {
            roomService.deleteRoom(roomService.getRoomById(id));
        }
        catch (Exception e) {
            List<Room> rooms = roomService.getAllRooms();
            model.addAttribute("rooms", rooms);
            model.addAttribute("error","Can not delete room");
            return "/rooms";
        }
        return "redirect:/rooms";
    }

}
