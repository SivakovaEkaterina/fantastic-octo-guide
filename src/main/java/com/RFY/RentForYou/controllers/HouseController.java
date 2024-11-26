package com.RFY.RentForYou.controllers;

import com.RFY.RentForYou.models.CityModel;
import com.RFY.RentForYou.models.HouseModel;
import com.RFY.RentForYou.service.CityServer;
import com.RFY.RentForYou.service.HouseServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/house")
public class HouseController {
    private final HouseServer houseServer;
    private final CityServer cityService; // Сервис для городов

    public HouseController(HouseServer houseServer, CityServer cityService) {
        this.houseServer = houseServer;
        this.cityService = cityService;
    }

    @GetMapping("")
    public String getAllHouses(Model model) {
        model.addAttribute("houses", houseServer.findAllHouses());
        model.addAttribute("house", new HouseModel());

        // Получаем список городов и добавляем в модель
        List<CityModel> cities = cityService.findAllCity();
        model.addAttribute("cities", cities);

        return "housePg"; // имя вашего HTML-шаблона
    }

    @PostMapping("/add")
    public String addHouse(@ModelAttribute HouseModel houseModel) {
        houseServer.addHouse(houseModel);
        return "redirect:/house";
    }

    @PostMapping("/update")
    public String updateHouse(@ModelAttribute HouseModel houseModel) {
        houseServer.updateHouse(houseModel);
        return "redirect:/house";
    }

    @PostMapping("/delete")
    public String deleteHouse(@RequestParam Long id) {
        houseServer.deleteHouse(id);
        return "redirect:/house";
    }
}
