package com.appspot.livelove.controller.livelove;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.livelove.model.ArtistLive;
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

        // artistListÇÃê›íË
        List<ArtistLive> als = service.getArtistListJoinedLive(key);
        List<String> joinArtistList = new ArrayList<String>();
        for(ArtistLive al : als){
            joinArtistList.add(al.getArtistRef().getModel().getName());
        }
        requestScope("joinArtistStr", StringUtils.join(joinArtistList, ','));

        return forward("viewUpdateLive.jsp");
    }
}
