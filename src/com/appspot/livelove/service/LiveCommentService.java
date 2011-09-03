package com.appspot.livelove.service;

import java.util.Date;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.appspot.livelove.model.Live;
import com.appspot.livelove.model.LiveComment;
import com.appspot.livelove.model.UserAccount;

public class LiveCommentService {

    public LiveComment addLiveComment(Map<String, Object> input, Live live,
            UserAccount ua) {
        LiveComment liveComment = new LiveComment();
        BeanUtil.copy(input, liveComment);

        // 対象ライブを設定
        liveComment.getTargetLiveRef().setModel(live);

        // 登録日、登録ユーザ、最終更新日、最終更新ユーザ、削除フラグを設定
        liveComment.setRegistDate(new Date());
        liveComment.getRegistUserAccountRef().setModel(ua);
        liveComment.setLastUpdateDate(new Date());
        liveComment.getLastUpdateUserAccountRef().setModel(ua);
        liveComment.setDeleted(false);

        Datastore.put(liveComment, live, ua);
        return liveComment;
    }

}
