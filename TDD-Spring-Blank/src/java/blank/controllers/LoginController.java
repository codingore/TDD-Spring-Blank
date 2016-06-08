package blank.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import blank.Crypto;
import blank.models.User;
import blank.models.UserService;

@Controller
@EnableTransactionManagement
public class LoginController {

	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService){
		this.userService = userService;
	}

	private void prepare(ModelMap model, HttpServletRequest request) {
		String ROOT = request.getContextPath();
		if (ROOT.equalsIgnoreCase("/")) {
			ROOT = "";
		}
		model.addAttribute("ROOT", ROOT);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String pageINDEX(ModelMap model, HttpServletRequest request) {
		prepare(model, request);
		model.addAttribute("message", "");
		model.addAttribute("user", new User());
		return "Login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String pageGET(ModelMap model, HttpServletRequest request) {
		prepare(model, request);
		model.addAttribute("message", "");
		model.addAttribute("user", new User());
		return "Login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String pagePOST(@ModelAttribute("user") User user, ModelMap model, HttpServletRequest request) {
		prepare(model, request);
		try {
			User u = this.userService.getUserByEmail(user.getEmail());
			if (u == null) {
				model.addAttribute("message", "Email is not found!");
				return "Login";
			}
			if (!u.getPassword().equals(Crypto.encryptPassword(user.getPassword()))) {
				model.addAttribute("message", "Password does not match!");
				return "Login";
			}
			model.addAttribute("message", "");
			model.clear();
			return "redirect:/index.yo";
		} catch (Exception e) {
			model.addAttribute("message", e.toString() + "");
		}
		return "Login";
	}
	
}
