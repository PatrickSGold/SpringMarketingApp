package com.example.SpringMarketingApp.controllers;

import com.example.SpringMarketingApp.models.WorkTask;
import com.example.SpringMarketingApp.services.StoreService;
import com.example.SpringMarketingApp.services.WorkTaskService;
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
public class WorkTaskController {

    @Autowired
    WorkTaskService service;

    @Autowired
    StoreService storeService;

    @RequestMapping("/work_tasks/{store_id}")
    public String showWorkTasks(@PathVariable(name = "store_id") Long id, Model model) {
        List<WorkTask> listOfWorkTasks = storeService.get(id).getListOfWorkTasks();

        model.addAttribute("listOfWorkTasks", listOfWorkTasks);
        model.addAttribute("storeId", id);

        return "work_tasks";
    }

    @RequestMapping("/new_work_task/{store_id}")
    public String saveWorkTask(@PathVariable(name = "store_id") Long id, Model model) {
        WorkTask workTask = new WorkTask();
        workTask.setStore_id(id);

        model.addAttribute("WorkTask", workTask);

        return "new_work_task";
    }

    @RequestMapping( value = "/save_work_task", method = RequestMethod.POST)
    public String saveWorkTask(@ModelAttribute("WorkTask") WorkTask workTask) {
        service.save(workTask);
        final Long storeId = workTask.getStore_id();

        return "redirect:/work_tasks/" + storeId;
    }

    @RequestMapping("/edit_work_task/{id}")
    public ModelAndView editWorkTask(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_work_task");

        WorkTask workTask = service.get(id);
        mav.addObject("WorkTask", workTask);

        return mav;
    }

    @RequestMapping("/delete_work_task/{id}")
    public String deleteWorkTask(@PathVariable(name = "id") Long id) {
        final Long storeId = storeService.get(id).getArea_id();
        service.delete(id);

        return "redirect:/work_tasks/" + storeId;
    }
}
