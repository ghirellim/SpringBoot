package ar.com.ghirelli.springboot.crud.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.ghirelli.springboot.crud.constant.ViewConstant;
import ar.com.ghirelli.springboot.crud.entity.Contact;
import ar.com.ghirelli.springboot.crud.model.ContactModel;
import ar.com.ghirelli.springboot.crud.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController {
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	@GetMapping("/contactform")
	public String redirectContactForm(@RequestParam(name="id", required=false)int id ,
			Model model) {
		ContactModel contact = new ContactModel();
		if(id != 0) {
			contact=contactService.findContactModelById(id);
		}else {
		model.addAttribute("contactModel", contact);
		}
		return ViewConstant.CONTACT_FORM;
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/showcontacts";
	}
	
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name="contactModel")ContactModel contactModel, Model model) {
		LOG.info("METHOD: addcontact() -- PARAMS: contactModel=" + contactModel.toString());
		if(null!=contactService.addContact(contactModel)) {
			model.addAttribute("result", 0);
		}else {
			model.addAttribute("result", 1);
		}
		return "redirect:/contacts/showcontacts";
	}
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		ModelAndView mav= new ModelAndView(ViewConstant.CONTACTS);
		mav.addObject("contacts", contactService.listAllContacts());
		return mav;
	}
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id", required=true)int id ) {
		contactService.removeContact(id);
		return showContacts();
	}
}
