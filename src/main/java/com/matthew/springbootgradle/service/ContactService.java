package com.matthew.springbootgradle.service;

import com.matthew.springbootgradle.dal.model.Contact;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;

/**
 * @author zeyuan
 * Create Time : 2019/2/17 11:04 PM
 */
public interface ContactService {

    List<Contact> queryAllContact();

    Contact queryContactById(Long id);

    void insertContact(Contact contact);

    void updateContactById(Contact contact);

    void deleteContactById(Long id);

    HSSFWorkbook saveContactToExcel();

}
