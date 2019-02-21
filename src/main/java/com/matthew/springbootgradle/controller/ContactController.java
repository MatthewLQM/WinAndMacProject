package com.matthew.springbootgradle.controller;

import com.alibaba.fastjson.JSON;
import com.matthew.springbootgradle.dal.model.Contact;
import com.matthew.springbootgradle.service.ContactService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    private final static Logger LOGGER = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    private ContactService contactService;

    @RequestMapping
    public String index(Model model) {
        List<Contact> contacts = contactService.queryAllContact();
        model.addAttribute("contacts", contacts);
        model.addAttribute("createObject", new Contact());
        model.addAttribute("action", "create");
        return "contact/index";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute Contact contact) {
        LOGGER.info("contact=" + JSON.toJSONString(contact));
        contactService.insertContact(contact);
        return "redirect:/contact/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id) {
        contactService.deleteContactById(id);
        return "redirect:/contact/";
    }

    @RequestMapping(value = "/jumpToUpdate/{id}", method = RequestMethod.GET)
    public String jumpToUpdate(Model model, @PathVariable Long id) {
        Contact contact = contactService.queryContactById(id);
        model.addAttribute("contact", contact);
        return "contact/update";
    }

    @RequestMapping(value = "/jumpToCreate", method = RequestMethod.GET)
    public String jumpToCreate(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact/create";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detail(Model model, @PathVariable Long id) {
        Contact contact = contactService.queryContactById(id);
        model.addAttribute("contact", contact);
        return "contact/detail";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute Contact contact) {
        contactService.updateContactById(contact);
        return "redirect:/contact/";
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public void downloadExcelFile(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");
        try {
            HSSFWorkbook workbook = contactService.saveContactToExcel();
            response.setHeader("Content-Disposition", "attachment; filename=contact.xls");
            workbook.write(response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
