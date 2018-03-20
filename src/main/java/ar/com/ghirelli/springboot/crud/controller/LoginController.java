package ar.com.ghirelli.springboot.crud.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.ghirelli.springboot.crud.constant.ViewConstant;
import ar.com.ghirelli.springboot.crud.model.UserCredential;

@Controller
public class LoginController {
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@GetMapping("/")
	public String redirectToLogin() {
		LOG.info("METHOD: redirectToLogin()");
		return "redirect:/login";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOG.info("METHOD: showLoginForm() -- PARAMS: error=" + error + ", logout=" + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentias", new UserCredential());
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}

	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name = "userCredentias") UserCredential userCredential) {
		LOG.info("METHOD: logincheck() -- PARAMS: userCredentias=" + userCredential.toString());
		if (userCredential.getUser().equals("user") && userCredential.getPassw().equals("user")) {
			LOG.info("Returning to contacts view");
			return "redirect:/contacts/showcontacts";
		}
		LOG.info("Redirect to login?error");
		return "redirect:/login?error=true	";
	}

}
