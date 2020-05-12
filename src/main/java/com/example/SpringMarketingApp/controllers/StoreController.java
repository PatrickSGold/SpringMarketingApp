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

import java.util.List;

@Controller
public class StoreController {

    @Autowired
    StoreService storeService;

    @Autowired
    AreaService areaService;


    @RequestMapping("/stores/{area_id}")
    public String showStores(@PathVariable(name = "area_id") Long id, Model model) {
        Area area = areaService.get(id);
        List<Store> listOfStores = area.getListOfStores();

        model.addAttribute("Area", area);
        model.addAttribute("listOfStores", listOfStores);

        return "stores";
    }


    /*
    @RequestMapping("/stores")
    public String showerStoresNew(Model model) {
        Store store = new Store();
        List<Store> listOfStores = storeService.listAll(store.getArea().getId());
        Area area = store.getArea();

        model.addAttribute("Area", area);
        model.addAttribute("listOfStores", listOfStores);

        return "stores";
    }
         */

    @RequestMapping("/stores/new_store")
    public String newStore(Model model) {
        Store store = new Store();
        model.addAttribute("Store", store);

        return "new_store";
    }

    @RequestMapping(value = "/save_store", method = RequestMethod.POST)
    public String saveArea(@ModelAttribute("Store") Store store) {

        storeService.save(store);
        return "redirect:/stores/{id}}";
    }

}