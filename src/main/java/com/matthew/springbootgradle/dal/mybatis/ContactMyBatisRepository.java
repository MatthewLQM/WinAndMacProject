package com.matthew.springbootgradle.dal.mybatis;

import com.matthew.springbootgradle.dal.model.Contact;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zeyuan
 * Create Time : 2019/2/17 10:50 PM
 */
@Mapper
public interface ContactMyBatisRepository {

    @Select("SELECT * FROM contact")
    @Results({
            @Result(property = "englishName", column = "english_name"),
            @Result(property = "companyPhone", column = "company_phone"),
            @Result(property = "extInfo", column = "ext_info")
    })
    List<Contact> selectAllContact();

    @Select("SELECT * FROM contact WHERE id = #{id}")
    @Results({
            @Result(property = "englishName", column = "english_name"),
            @Result(property = "companyPhone", column = "company_phone"),
            @Result(property = "extInfo", column = "ext_info")
    })
    Contact selectContactById(@Param("id") Long id);

    @Insert("INSERT INTO contact(name, english_name, sex, birthday, phone, " +
            "email, wechat, qq, address, company, company_phone, memo, ext_info)" +
            "VALUE(#{name}, #{englishName}, #{sex}, #{birthday}, #{phone}, " +
            "#{email}, #{wechat}, #{qq}, #{address}, #{company}, #{companyPhone}, #{memo}, #{extInfo})")
    void insertContact(Contact contact);

    @Update("UPDATE contact SET name = #{name}, english_name = #{englishName}, sex = #{sex}, " +
            "birthday = #{birthday}, phone = #{phone}, email = #{email}, wechat = #{wechat}, " +
            "qq = #{qq}, address = #{address}, company = #{company}, company_phone = #{companyPhone}, " +
            "memo = #{memo}, ext_info = #{extInfo} WHERE id = #{id},")
    void updateContact(Contact contact);

    @Delete("DELETE FROM contact WHERE id = #{id}")
    void deleteContactById(@Param("id") Long id);
}
