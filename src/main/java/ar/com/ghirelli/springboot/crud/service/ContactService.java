package ar.com.ghirelli.springboot.crud.service;

import java.util.List;

import ar.com.ghirelli.springboot.crud.entity.Contact;
import ar.com.ghirelli.springboot.crud.model.ContactModel;

public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllContacts();
	
	public abstract Contact findContactById(int id);
	
	public abstract ContactModel findContactModelById(int id);
	
	public abstract void removeContact(int id);
}
