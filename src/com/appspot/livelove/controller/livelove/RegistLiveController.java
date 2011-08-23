package com.appspot.livelove.controller.livelove;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.appspot.livelove.model.UserAccount;
import com.appspot.livelove.service.LiveService;

public class RegistLiveController extends Controller {

    private LiveService service = new LiveService();

    @Override
    public Navigation run() throws Exception {
        HttpSession sess = request.getSession();
        UserAccount ua = (UserAccount) sess.getAttribute("userAccount");
        service.registLive(new RequestMap(request), ua);
        return redirect(basePath);
    }
}
