package com.appspot.livelove.controller.livelove;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.livelove.model.Live;
import com.appspot.livelove.service.LiveService;
import com.google.appengine.api.datastore.Key;

public class ViewUpdateLiveController extends Controller {

    private LiveService service = new LiveService();

    @Override
    public Navigation run() throws Exception {
        Key key = asKey("key");
        Live live = service.getLiveDetail(key);
        requestScope("live", live);

        return forward("viewUpdateLive.jsp");
    }
}
