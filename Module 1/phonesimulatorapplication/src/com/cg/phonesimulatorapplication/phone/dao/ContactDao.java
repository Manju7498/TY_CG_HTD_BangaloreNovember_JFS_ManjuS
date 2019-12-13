package com.cg.phonesimulatorapplication.phone.dao;

import java.util.List;

import com.cg.phonesimulatorapplication.phone.bean.ContactBean;

public interface ContactDao {
	public List<ContactBean> getAllContacts();
	public ContactBean getContact(String name);
	public boolean addContact(ContactBean bean);
	public boolean deleteContact(String name);
	public boolean updateContact(String name);

}
