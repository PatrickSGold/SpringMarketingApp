package com.example.SpringMarketingApp.controllers;

import com.example.SpringMarketingApp.models.Product;
import com.example.SpringMarketingApp.services.ProductService;
import com.example.SpringMarketingApp.services.StoreService;
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
public class ProductController {

    @Autowired
    ProductService service;

    @Autowired
    StoreService storeService;

    @RequestMapping("/products/{store_id}")
    public String showProducts(@PathVariable(name = "store_id") Long id, Model model) {
        List<Product> listOfProducts = storeService.get(id).getListOfProducts();

        model.addAttribute("listOfProducts", listOfProducts);
        model.addAttribute("storeId", id);

        return "products";
    }

    @RequestMapping("/new_product/{store_id}")
    public String newProduct(@PathVariable(name = "store_id") Long id, Model model) {
        Product product = new Product();
        product.setStore_id(id);

        model.addAttribute("Product", product);

        return "new_product";
    }

    @RequestMapping(value = "/save_product", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("Product") Product product) {
        service.save(product);
        Long id = product.getStore_id();

        return "redirect:/products/" + id;
    }

    @RequestMapping("/edit_product/{id}")
    public ModelAndView editProduct(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_product");

        Product product = service.get(id);
        mav.addObject("Product", product);

        return mav;
    }

    @RequestMapping("/delete_product/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        service.delete(id);
        Long storeId = service.get(id).getStore_id();

        return "redirect:/products/" + storeId;
    }
}
