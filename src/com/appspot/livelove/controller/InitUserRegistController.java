package com.appspot.livelove.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import com.appspot.livelove.model.UserAccount;
import com.google.appengine.api.datastore.Transaction;

public class InitUserRegistController extends Controller {

    @Override
    public Navigation run() throws Exception {
        String nickname = asString("nickname");
        String mail = asString("mail");

        HttpSession sess = request.getSession();
        UserAccount ua = (UserAccount) sess.getAttribute("userAccount");
        ua.setNickname(nickname);
        ua.setMail(mail);
        ua.setRegistDate(new Date());
        ua.setLastUpdateDate(new Date());
        ua.setDeleted(false);
        ua.setLastLoginDate(new Date());

        Transaction tx = Datastore.beginTransaction();
        Datastore.put(ua);
        tx.commit();

        sessionScope("userAccount", ua);

        String _continue = asString("continue");
        if (StringUtils.isBlank(_continue)) {
            _continue = "/";
        }
        return redirect(_continue);
    }
}
