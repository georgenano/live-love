package com.appspot.livelove.controller.livelove;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.livelove.model.UserAccount;
import com.appspot.livelove.service.LiveService;
import com.google.appengine.api.datastore.Key;

public class JoinLiveController extends Controller {

    private LiveService liveService = new LiveService();

    @Override
    public Navigation run() throws Exception {
        Key liveKey = asKey("liveKey");
        HttpSession sess = request.getSession();
        UserAccount ua = (UserAccount) sess.getAttribute("userAccount");
        Key userAccountKey = ua.getKey();
        liveService.joinLive(liveKey, userAccountKey);

        String keyStr = asString("liveKey");
        return forward("viewLiveDetail?key=" + keyStr);
    }
}
