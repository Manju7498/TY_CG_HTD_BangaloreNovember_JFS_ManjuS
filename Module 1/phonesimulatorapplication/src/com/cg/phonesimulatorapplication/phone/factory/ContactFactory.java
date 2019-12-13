package com.cg.phonesimulatorapplication.phone.factory;

import com.cg.phonesimulatorapplication.phone.dao.ContactDao;
import com.cg.phonesimulatorapplication.phone.dao.ContactDaoImpl;
import com.cg.phonesimulatorapplication.phone.services.ContactServices;
import com.cg.phonesimulatorapplication.phone.services.ContactServicesImpl;

public class ContactFactory {
	private ContactFactory() {

	}
	public static ContactDao instanceofContactDao() {
		ContactDao dao=new ContactDaoImpl();
		return dao;
	}
	public static ContactServices instanceofContactServices() {
		ContactServices services=new ContactServicesImpl();
		return services;
	}
}
