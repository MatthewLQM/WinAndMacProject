package com.matthew.springbootgradle.controller;

import com.matthew.springbootgradle.dal.model.Contact;
import com.matthew.springbootgradle.dal.model.Test;
import com.matthew.springbootgradle.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author zeyuan
 * Create Time : 2019/2/17 11:10 PM
 */
@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping
    public String index(Model model) {
        List<Contact> contacts = contactService.queryAllContact();
        model.addAttribute("contacts", contacts);
        model.addAttribute("contact", new Contact());
        model.addAttribute("action", "create");
        return "contact/index";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute Contact contact) {
        contactService.insertContact(contact);
        return "redirect:/contact/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        contactService.deleteContactById(id);
        return "redirect:/contact/";
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
