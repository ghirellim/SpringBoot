package ar.com.ghirelli.springboot.crud.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ghirelli.springboot.crud.entity.Contact;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable>{

	public abstract Contact findById(int id);
	
}
