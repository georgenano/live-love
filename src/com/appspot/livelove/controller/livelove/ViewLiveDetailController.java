package com.appspot.livelove.controller.livelove;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.appspot.livelove.model.Live;
import com.appspot.livelove.model.LiveComment;
import com.appspot.livelove.model.UserAccount;
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
        // 変更可能ユーザの設定
        HttpSession sess = request.getSession();
        UserAccount ua = (UserAccount) sess.getAttribute("userAccount");
        requestScope("isEditableUser", service.isEditableUser(key, ua));
        return forward("viewLiveDetail.jsp");
    }
}
