package com.appspot.livelove.controller.livelove;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.appspot.livelove.model.UserAccount;
import com.appspot.livelove.service.UserAccountService;
import com.google.appengine.api.datastore.Key;

public class UpdateUserAccountController extends Controller {

    private UserAccountService service = new UserAccountService();

    @Override
    public Navigation run() throws Exception {
        if (inputCheck()) {
            HttpSession sess = request.getSession();
            UserAccount ua = (UserAccount) sess.getAttribute("userAccount");
            Key key = ua.getKey();
            service.updateUserAccount(key, new RequestMap(request), ua);

            String nickname = asString("nickname");
            String mail = asString("mail");
            ua.setNickname(nickname);
            ua.setMail(mail);
            sessionScope("userAccount", ua);
            return redirect(basePath);
        }
        return forward("/error");
    }

    private boolean inputCheck() {
        String liveName = asString("nickname");
        String artistList = asString("mail");
        if (liveName != ""
            && artistList != "") {
            return true;
        }
        return false;
    }
}
