package com.appspot.livelove.controller.livelove;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.appspot.livelove.model.UserAccount;
import com.appspot.livelove.service.ArtistService;
import com.google.appengine.api.datastore.Key;

public class UpdateArtistController extends Controller {

    private ArtistService service = new ArtistService();

    @Override
    public Navigation run() throws Exception {
        Key key = asKey("key");
        HttpSession sess = request.getSession();
        UserAccount ua = (UserAccount) sess.getAttribute("userAccount");
        service.updateArtist(key, new RequestMap(request), ua);
        String keyStr = asString("key");
        return redirect("/livelove/viewArtistDetail?key=" + keyStr);
    }
}
