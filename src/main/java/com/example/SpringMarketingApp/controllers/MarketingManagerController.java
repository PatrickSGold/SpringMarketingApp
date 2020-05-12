package com.example.SpringMarketingApp.controllers;

import com.example.SpringMarketingApp.models.MarketingManager;
import com.example.SpringMarketingApp.services.MarketingManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MarketingManagerController {

    @Autowired
    MarketingManagerService service;

    @RequestMapping("/")
    public String showHomePage(Model model) {
        List<MarketingManager> listOfManagers = service.listAll();
        model.addAttribute("listOfManagers", listOfManagers);

        return "index";
    }

    @RequestMapping("/new_manager")
    public String newManager(Model model) {
    MarketingManager manager = new MarketingManager();
    model.addAttribute("Manager", manager);

    return "new_manager";
    }

    @RequestMapping("/save_manager")
    public String saveManager(@ModelAttribute("Manager") MarketingManager manager) {
        service.save(manager);

        return "redirect:/";
    }

    @RequestMapping("/edit_manager/{id}")
    public ModelAndView editManager(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_manager");
        MarketingManager manager = service.get(id);
        mav.addObject("Manager", manager);

        return mav;
    }

    @RequestMapping("/delete_manager/{id}")
    public String deleteManager(@PathVariable(name = "id") Long id) {
        service.delete(id);

        return "redirect:/";
    }
}
