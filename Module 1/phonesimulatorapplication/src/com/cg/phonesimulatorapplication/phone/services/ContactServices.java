package com.cg.phonesimulatorapplication.phone.services;

import java.util.List;

import com.cg.phonesimulatorapplication.phone.bean.ContactBean;

public interface ContactServices {
	public List<ContactBean> getAllContacts();
	public ContactBean getContact(String name);
	public boolean addContact(ContactBean bean);
	public boolean deleteContact(String name);
	public boolean updateContact(String name);
}
