package com.appspot.livelove.controller.livelove;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.livelove.model.Artist;
import com.appspot.livelove.service.ArtistService;
import com.google.appengine.api.datastore.Key;

public class ViewUpdateArtistController extends Controller {

    private ArtistService service = new ArtistService();

    @Override
    public Navigation run() throws Exception {
        Key key = asKey("key");
        Artist artist = service.getArtist(key);
        requestScope("artist", artist);

        // anotherNameListÇÃê›íË
        List<String> antoherNameList = new ArrayList<String>();
        for(String anotherName : artist.getAnotherNames()){
            antoherNameList.add(anotherName);
        }
        requestScope("anotherNameStr", StringUtils.join(antoherNameList, ','));

        return forward("viewUpdateArtist.jsp");
    }
}
