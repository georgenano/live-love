package com.appspot.livelove.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.appspot.livelove.model.UserAccount;
import com.appspot.livelove.service.UserAccountService;

public class InitUserRegistController extends Controller {

    private UserAccountService service = new UserAccountService();

    @Override
    public Navigation run() throws Exception {
        HttpSession sess = request.getSession();
        UserAccount ua = (UserAccount) sess.getAttribute("userAccount");
        service.registUserAccount(new RequestMap(request), ua);
        sessionScope("userAccount", ua);

        String _continue = asString("continue");
        if (StringUtils.isBlank(_continue)) {
            _continue = "/";
        }
        return redirect(_continue);
    }
}
