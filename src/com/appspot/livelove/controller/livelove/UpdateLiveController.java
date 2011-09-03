package com.appspot.livelove.controller.livelove;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.appspot.livelove.model.UserAccount;
import com.appspot.livelove.service.LiveService;
import com.google.appengine.api.datastore.Key;

public class UpdateLiveController extends Controller {

    private LiveService service = new LiveService();

    @Override
    public Navigation run() throws Exception {
        Key key = asKey("key");
        HttpSession sess = request.getSession();
        UserAccount ua = (UserAccount) sess.getAttribute("userAccount");
        if (service.inputCheck(new RequestMap(request)) && service.isEditableUser(key, ua)) {
            service.updateLive(key, new RequestMap(request), ua);
            String keyStr = asString("key");
            return redirect("/livelove/viewLiveDetail?key=" + keyStr);
        }
        return forward("/error");
    }
}
