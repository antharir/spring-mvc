package com.rajeshanthari.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rajeshanthari.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	private LoginService service = new LoginService();

	@RequestMapping(method = RequestMethod.GET)
	public String getLogin() {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String validateLogin(@RequestParam String username, @RequestParam String password, ModelMap map) {
		boolean validateUser = service.validateUser(username, password);
		if (validateUser) {
			map.put("name", username);
			return "welcome";
		} else {
			map.put("errorMessage", "Invalid Creds");
			return "login";
		}
	}

}
