package com.appspot.livelove.controller;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;

import twitter4j.auth.AccessToken;

import com.appspot.livelove.meta.UserAccountMeta;
import com.appspot.livelove.model.UserAccount;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class LoginController extends Controller {

    @Override
    public Navigation run() throws Exception {
        String userId = null;
        String accountType = null;

        String type = asString("type");
        if ("openid".equals(type)) {
            UserService userService = UserServiceFactory.getUserService();
            User user = userService.getCurrentUser();
            if (user == null) {
                return forward("/loginError.jsp");
            }
            userId = user.getUserId();
            accountType = "openid";
        } else if ("twitter".equals(type)) {
            AccessToken accessToken = sessionScope("accessToken");
            if (accessToken == null) {
                return forward("/loginError.jsp");
            }
            userId = accessToken.getScreenName();
            accountType = "twitter";
        }

        UserAccountMeta uam = UserAccountMeta.get();
        UserAccount ua =
            Datastore
                .query(uam)
                .filter(
                    uam.userId.equal(userId),
                    uam.accountType.equal(accountType))
                .asSingle();

        if (ua == null) {
            ua = new UserAccount();
            ua.setUserId(userId);
            ua.setAccountType(accountType);
            ua.setNickname(null);
            ua.setMail(null);
            ua.setRegistDate(new Date());
            ua.setLastUpdateDate(new Date());
            ua.setDeleted(false);
        }

        // 最終ログイン日時を更新
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
