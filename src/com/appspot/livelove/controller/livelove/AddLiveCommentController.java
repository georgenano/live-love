package com.appspot.livelove.controller.livelove;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

import com.appspot.livelove.model.Live;
import com.appspot.livelove.model.UserAccount;
import com.appspot.livelove.service.LiveCommentService;
import com.appspot.livelove.service.LiveService;
import com.google.appengine.api.datastore.Key;

public class AddLiveCommentController extends Controller {

    LiveService ls = new LiveService();
    LiveCommentService lcs = new LiveCommentService();

    @Override
    public Navigation run() throws Exception {
        Key key = asKey("liveKey");
        Live live = ls.getLiveDetail(key);

        HttpSession sess = request.getSession();
        UserAccount ua = (UserAccount) sess.getAttribute("userAccount");
        lcs.addLiveComment(new RequestMap(request), live, ua);
        String keyStr = asString("liveKey");
        return forward("viewLiveDetail?key=" + keyStr);
    }
}
