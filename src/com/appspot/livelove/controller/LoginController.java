package com.appspot.livelove.controller;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.repackaged.com.google.common.collect.Sets;

public class LoginController extends Controller {

    @Override
    public Navigation run() throws Exception {
        String openid_identifier = asString("openid_identifier");
        String _continue = asString("continue");
        if (StringUtils.isBlank(_continue)) {
            _continue = "/";
        }

        UserService userService = UserServiceFactory.getUserService();
        User currentUser = userService.getCurrentUser();
        if (currentUser != null) {
            return redirect(_continue);
        }

        Set<String> attributesRequest =
            Sets.newHashSet(
                "openid.mode=checkid_immediate",
                "openid.ns=http://specs.openid.net/auth/2.0",
                "openid.return_to=" + _continue);

        String loginUrl =
            userService.createLoginURL(
                _continue,
                request.getServerName(),
                openid_identifier,
                attributesRequest);

        return redirect(loginUrl);
    }
}
