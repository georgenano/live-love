package com.appspot.livelove.controller.livelove;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

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
        // live情報の設定
        Key key = asKey("key");
        Live live = service.getLiveDetail(key);
        requestScope("live", live);

        // commentListの設定
        if(live.getLiveCommentListRef() != null){
            List<LiveComment> comments = live.getLiveCommentListRef().getModelList();
            requestScope("commentList", comments);
        }

        //参戦表明者リストの設定
        List<UserAccountLive> joinUserList = service.getUserListJoinedLive(key);
        requestScope("joinUserList", joinUserList);

        // 変更可能ユーザの設定
        HttpSession sess = request.getSession();
        UserAccount ua = (UserAccount) sess.getAttribute("userAccount");
        requestScope("isEditableUser", service.isEditableUser(key, ua));

        // 参戦可能ユーザの設定
        requestScope("canJoinLive", !service.joinedLive(key, ua.getKey()));

        return forward("viewLiveDetail.jsp");
    }
}
