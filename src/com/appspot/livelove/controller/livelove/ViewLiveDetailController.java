package com.appspot.livelove.controller.livelove;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.livelove.model.Artist;
import com.appspot.livelove.model.ArtistLive;
import com.appspot.livelove.model.Live;
import com.appspot.livelove.model.LiveComment;
import com.appspot.livelove.model.UserAccount;
import com.appspot.livelove.model.UserAccountLive;
import com.appspot.livelove.service.LiveService;
import com.google.appengine.api.datastore.Key;

public class ViewLiveDetailController extends Controller {

    private LiveService service = new LiveService();

    @Override
    public Navigation run() throws Exception {
        // live���̐ݒ�
        Key key = asKey("key");
        Live live = service.getLiveDetail(key);
        requestScope("live", live);

        // artistList�̐ݒ�
        List<ArtistLive> als = service.getArtistListJoinedLive(key);
        List<Artist> joinArtistList = new ArrayList<Artist>();
        for(ArtistLive al : als){
            joinArtistList.add(al.getArtistRef().getModel());
        }
        requestScope("joinArtistList", joinArtistList);

        // commentList�̐ݒ�
        if(live.getLiveCommentListRef() != null){
            List<LiveComment> comments = live.getLiveCommentListRef().getModelList();
            requestScope("commentList", comments);
        }

        //�Q��\���҃��X�g�̐ݒ�
        List<UserAccountLive> joinUserList = service.getUserListJoinedLive(key);
        requestScope("joinUserList", joinUserList);

        // �ύX�\���[�U�̐ݒ�
        HttpSession sess = request.getSession();
        UserAccount ua = (UserAccount) sess.getAttribute("userAccount");
        requestScope("isEditableUser", service.isEditableUser(key, ua));

        // �Q��\���[�U�̐ݒ�
        requestScope("canJoinLive", !service.joinedLive(key, ua.getKey()));

        return forward("viewLiveDetail.jsp");
    }
}
