package com.zohocrm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entities.Contact;
import com.zohocrm.repository.ContactRepository;


@Service
public class contactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	@Override
	public void saveContact(Contact contact) {
		// TODO Auto-generated method stub
		contactRepo.save(contact);

	}

	@Override
	public List<Contact> getContacts() {
   List<Contact> contacts = contactRepo.findAll();
		return contacts;
	}

	@Override
	public Contact getContactByid(long id) {
   Optional<Contact> findById = contactRepo.findById(id);
   Contact contact = findById.get();
   return contact;
	}

}
