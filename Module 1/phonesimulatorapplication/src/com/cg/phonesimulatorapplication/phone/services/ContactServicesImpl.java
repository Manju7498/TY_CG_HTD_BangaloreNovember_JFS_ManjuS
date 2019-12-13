package com.cg.phonesimulatorapplication.phone.services;

import java.util.List;

import com.cg.phonesimulatorapplication.phone.bean.ContactBean;
import com.cg.phonesimulatorapplication.phone.dao.ContactDao;
import com.cg.phonesimulatorapplication.phone.factory.ContactFactory;

public class ContactServicesImpl implements ContactServices {
	ContactDao dao=ContactFactory.instanceofContactDao();
	@Override
	public List<ContactBean> getAllContacts() {
		return dao.getAllContacts();
	}

	@Override
	public ContactBean getContact(String name) {
		return dao.getContact(name);
	}

	@Override
	public boolean addContact(ContactBean bean) {
		return dao.addContact(bean);
	}

	@Override
	public boolean deleteContact(String name) {
		return dao.deleteContact(name);
	}

	@Override
	public boolean updateContact(String name) {
		return dao.updateContact(name);
	}

}
