package com.appspot.livelove.controller.livelove;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.appspot.livelove.model.UserAccount;
import com.appspot.livelove.service.ArtistService;

public class RegistArtistController extends Controller {

    ArtistService service = new ArtistService();

    @Override
    public Navigation run() throws Exception {
        if (service.inputCheck(new RequestMap(request))) {
            HttpSession sess = request.getSession();
            UserAccount ua = (UserAccount) sess.getAttribute("userAccount");
            service.registArtist(new RequestMap(request), ua);
            return redirect(basePath);
        }
        return forward("/error");
    }
}
