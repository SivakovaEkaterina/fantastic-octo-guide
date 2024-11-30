package com.RFY.RentForYou.controllers;

import com.RFY.RentForYou.models.CityModel;
import com.RFY.RentForYou.models.FlatModel;
import com.RFY.RentForYou.models.HouseModel;
import com.RFY.RentForYou.service.CityServer;
import com.RFY.RentForYou.service.HouseServer;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@Controller
@RequestMapping("/house")
@PreAuthorize("hasAnyAuthority('User')")
public class HouseController {
    private final HouseServer houseServer;
    private final CityServer cityService; // Сервис для городов

    public HouseController(HouseServer houseServer, CityServer cityService) {
        this.houseServer = houseServer;
        this.cityService = cityService;
    }

    @GetMapping("")
    public String getAllHouses(Model model) {
        String currentUrl = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
        model.addAttribute("currentUrl", currentUrl);

        model.addAttribute("houses", houseServer.findAllHouses());
        model.addAttribute("house", new HouseModel());

        // Получаем список городов и добавляем в модель
        List<CityModel> cities = cityService.findAllCity();
        model.addAttribute("cities", cities);

        return "housePg"; // имя вашего HTML-шаблона
    }

    @PostMapping("/add")
    public String addHouse(@Valid @ModelAttribute("house") HouseModel houseModel, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("houses", houseServer.findAllHouses());
            return "housePg";
        }
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
