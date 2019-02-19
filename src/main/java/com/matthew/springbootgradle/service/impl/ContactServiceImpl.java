package com.matthew.springbootgradle.service.impl;

import com.matthew.springbootgradle.dal.model.Contact;
import com.matthew.springbootgradle.dal.mybatis.ContactMyBatisRepository;
import com.matthew.springbootgradle.service.ContactService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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

    @Override
    public HSSFWorkbook saveContactToExcel() {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("联系人信息");
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("英文名");
        row.createCell(3).setCellValue("性别");
        row.createCell(4).setCellValue("生日");
        row.createCell(5).setCellValue("电话");
        row.createCell(6).setCellValue("邮箱");
        row.createCell(7).setCellValue("微信号");
        row.createCell(8).setCellValue("QQ号");
        row.createCell(9).setCellValue("联系地址");
        row.createCell(10).setCellValue("工作单位");
        row.createCell(11).setCellValue("单位电话");
        row.createCell(12).setCellValue("简要描述");
        row.createCell(13).setCellValue("额外信息");
        List<Contact> contactList = queryAllContact();
        for(int i = 1; i <= contactList.size(); i++) {
            Contact contact = contactList.get(i - 1);
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(contact.getId());
            row.createCell(1).setCellValue(contact.getName());
            row.createCell(2).setCellValue(contact.getEnglishName());
            row.createCell(3).setCellValue(contact.getSex());
            if(contact.getBirthday() != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String data = simpleDateFormat.format(contact.getBirthday());
                row.createCell(4).setCellValue(data);
            }
            row.createCell(5).setCellValue(contact.getPhone());
            row.createCell(6).setCellValue(contact.getEmail());
            row.createCell(7).setCellValue(contact.getWechat());
            row.createCell(8).setCellValue(contact.getQq());
            row.createCell(9).setCellValue(contact.getAddress());
            row.createCell(10).setCellValue(contact.getCompany());
            row.createCell(11).setCellValue(contact.getCompanyPhone());
            row.createCell(12).setCellValue(contact.getMemo());
            row.createCell(13).setCellValue(contact.getExtInfo());
        }
        return workbook;
    }

}
