package com.matthew.springbootgradle.service.impl;

import com.matthew.springbootgradle.dal.model.Contact;
import com.matthew.springbootgradle.dal.mybatis.ContactMyBatisRepository;
import com.matthew.springbootgradle.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zeyuan
 * Create Time : 2019/2/17 11:06 PM
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMyBatisRepository contactMyBatisRepository;

    @Override
    public List<Contact> queryAllContact() {
        return contactMyBatisRepository.selectAllContact();
    }

    @Override
    public Contact queryContactById(Long id) {
        return contactMyBatisRepository.selectContactById(id);
    }

    @Override
    public void insertContact(Contact contact) {
        contactMyBatisRepository.insertContact(contact);
    }

    @Override
    public void updateContactById(Contact contact) {
        contactMyBatisRepository.updateContact(contact);
    }

    @Override
    public void deleteContactById(Long id) {
        contactMyBatisRepository.deleteContactById(id);
    }
}
