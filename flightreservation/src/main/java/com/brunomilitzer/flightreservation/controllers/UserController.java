package com.brunomilitzer.flightreservation.controllers;

import com.brunomilitzer.flightreservation.entities.User;
import com.brunomilitzer.flightreservation.repository.UserRepository;
import com.brunomilitzer.flightreservation.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @RequestMapping("/showReg")
    public String showRegistrationPage() {

        LOGGER.info("Inside showRegistrationPage()");

        return "login/registerUser";
    }

    @RequestMapping("/showLogin")
    public String showLoginPage() {

        LOGGER.info("Inside showLoginPage()");

        return "login/login";
    }


    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") final User user) {

        LOGGER.info("Inside register() {}", user);
        user.setPassword(this.encoder.encode(user.getPassword()));

        this.repository.save(user);

        return "login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") final String email, @RequestParam("password") final String password, final ModelMap modelMap) {

        LOGGER.info("Inside login() the email is: {}", email);

        final boolean loginResponse = this.securityService.login(email, password);

        if (loginResponse) {

            return "findFlights";
        } else {

            modelMap.addAttribute("msg", "Invalid username or password.  Please try again.");
        }

        return "login/login";
    }

}
