package com.appspot.livelove.controller;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class LogoutController extends Controller {

    @Override
    public Navigation run() throws Exception {
        HttpSession session = request.getSession();
        session.removeAttribute("userAccount");

        UserService userService = UserServiceFactory.getUserService();
        return redirect(userService.createLogoutURL(basePath));
    }
}
