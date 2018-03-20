package ar.com.ghirelli.springboot.crud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.com.ghirelli.springboot.crud.converter.ContactConverter;
import ar.com.ghirelli.springboot.crud.entity.Contact;
import ar.com.ghirelli.springboot.crud.model.ContactModel;
import ar.com.ghirelli.springboot.crud.repository.ContactRepository;
import ar.com.ghirelli.springboot.crud.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;
	
	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact	=contactRepository.save(contactConverter.convertContactModel2ContactEntity(contactModel));
		return contactConverter.convertContactEntity2ContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<ContactModel> contactsModels=new ArrayList<ContactModel>();
		List<Contact> contacts=contactRepository.findAll();
		for(Contact contact:contacts) {
			contactsModels.add(contactConverter.convertContactEntity2ContactModel(contact));
		}
		return contactsModels;
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}

	@Override
	public void removeContact(int id) {
		Contact contact= findContactById(id);
		if(null!=contact){
			contactRepository.delete(contact);
		}
	}

	@Override
	public ContactModel findContactModelById(int id) {
	return contactConverter.convertContactEntity2ContactModel(findContactById(id));
	
	}
	
	

}
