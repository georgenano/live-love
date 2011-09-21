package com.appspot.livelove.controller.livelove;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.livelove.model.Artist;
import com.appspot.livelove.model.UserAccount;
import com.appspot.livelove.service.ArtistService;
import com.google.appengine.api.datastore.Key;

public class ViewArtistDetailController extends Controller {

    private ArtistService service = new ArtistService();

    @Override
    public Navigation run() throws Exception {
        // artistèÓïÒÇÃê›íË
        Key key = asKey("key");
        Artist artist = service.getArtist(key);
        requestScope("artist", artist);

        return forward("viewArtistDetail.jsp");
    }
}
