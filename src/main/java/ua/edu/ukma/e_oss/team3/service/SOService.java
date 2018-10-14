package ua.edu.ukma.e_oss.team3.service;

import ua.edu.ukma.e_oss.team3.entity.SO;
import ua.edu.ukma.e_oss.team3.entity.User;
import ua.edu.ukma.e_oss.team3.utils.ContactData;

import java.util.List;

public interface SOService {

    SO get(int so);
    int insert(SO so);
    void update(SO so);
    ContactData getContactDataOfSOById(int id);
    List<User> getListOfMembersById(int id);

}
