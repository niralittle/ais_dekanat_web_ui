package com.kma.ais_dekanat.controller;

import com.kma.ais_dekanat.model.Room;
import com.kma.ais_dekanat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    RoomService roomService;

    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
    public String helloWorld(Model model) {
        List<Room> roomList = roomService.getAllRooms();
        String message = "";
        if (roomList!=null) {
           message = roomList.get(0).getName();
        }

        model.addAttribute("message", message);
        return "/index";
    }

}
