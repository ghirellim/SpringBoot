package ar.com.ghirelli.springboot.crud.converter;

import org.springframework.stereotype.Component;

import ar.com.ghirelli.springboot.crud.entity.Contact;
import ar.com.ghirelli.springboot.crud.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

	public Contact convertContactModel2ContactEntity(ContactModel contact) {
		return new Contact(contact.getId(), 
						  contact.getFirstName(), 
						  contact.getLastName(), 
						  contact.getTelephone(),
						  contact.getCity());
	}

	public ContactModel convertContactEntity2ContactModel(Contact contact) {
		return new ContactModel(contact.getId(), 
				  contact.getFirstName(), 
				  contact.getLastName(), 
				  contact.getTelephone(),
				  contact.getCity());
}
}
