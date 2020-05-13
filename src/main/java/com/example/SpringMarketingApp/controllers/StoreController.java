package com.example.SpringMarketingApp.controllers;

import com.example.SpringMarketingApp.models.Area;
import com.example.SpringMarketingApp.models.Store;
import com.example.SpringMarketingApp.services.AreaService;
import com.example.SpringMarketingApp.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.PreUpdate;
import java.util.List;

@Controller
public class StoreController {

    @Autowired
    StoreService storeService;

    @Autowired
    AreaService areaService;


    @RequestMapping("/stores/{area_id}")
    public String showStores(@PathVariable(name = "area_id") Long id, Model model) {
        List<Store> listOfStores = areaService.get(id).getListOfStores();
        Long area_id = areaService.get(id).getId();

        model.addAttribute("listOfStores", listOfStores);
        model.addAttribute("areaId", area_id);

        return "stores";
    }

    @RequestMapping("/new_store/{area_id}")
    public String newStore(@PathVariable(name = "area_id") Long id, Model model) {
        Store store = new Store();
        store.setArea_id(id);
        model.addAttribute("Store", store);

        return "new_store";
    }

    @RequestMapping(value = "/save_store", method = RequestMethod.POST)
    public String saveArea(@ModelAttribute("Store") Store store) {
        storeService.save(store);
        Long area_id = store.getArea_id();
        return "redirect:/stores/" + area_id;
    }

    @RequestMapping("/edit_store/{id}")
    public ModelAndView editStore(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_store");

        Store store = storeService.get(id);
        mav.addObject("Store", store);

        return mav;
    }

}