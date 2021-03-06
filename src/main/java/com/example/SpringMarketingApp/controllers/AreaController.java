package com.example.SpringMarketingApp.controllers;

import com.example.SpringMarketingApp.models.Area;
import com.example.SpringMarketingApp.models.MarketingManager;
import com.example.SpringMarketingApp.services.AreaService;
import com.example.SpringMarketingApp.services.MarketingManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class AreaController {

    @Autowired
    AreaService service;

    @Autowired
    MarketingManagerService managerService;

    @RequestMapping("/areas/{id}")
    public String viewPage(@PathVariable(name = "id") Long id, Model model) {
        List<Area> listOfAreas = managerService.get(id).getListOfAreas();

        model.addAttribute("listOfAreas", listOfAreas);
        model.addAttribute("managerId", id);

        return "areas";
    }

    @RequestMapping("/new_area/{id}")
    public String newAreaForm(@PathVariable(name = "id") Long id, Model model) {
        Area area = new Area();
        area.setManager_id(id);
        model.addAttribute("Area", area);

        return "new_area";
    }

    @RequestMapping(value = "/save_area", method = RequestMethod.POST)
    public String saveArea(@ModelAttribute("Area") Area area) {
        service.save(area);
        Long manager_id = area.getManager_id();

        return "redirect:/areas/" + manager_id;
    }

    @RequestMapping("/edit_area/{id}")
    public ModelAndView editArea(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_area");

        Area area = service.get(id);
        mav.addObject("Area", area);

        return mav;
    }

    // figure out why this wont work
    @RequestMapping("/delete_area/{id}")
    public String deleteArea(@PathVariable(name = "id") Long id) {
        Long manager_id = service.get(id).getManager_id();
         service.delete(id);

         return "redirect:/areas/" + manager_id;
    }



}
