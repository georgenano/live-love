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

        // �Ώۃ��C�u��ݒ�
        liveComment.getTargetLiveRef().setModel(live);

        // �o�^���A�o�^���[�U�A�ŏI�X�V���A�ŏI�X�V���[�U�A�폜�t���O��ݒ�
        liveComment.setRegistDate(new Date());
        liveComment.getRegistUserAccountRef().setModel(ua);
        liveComment.setLastUpdateDate(new Date());
        liveComment.getLastUpdateUserAccountRef().setModel(ua);
        liveComment.setDeleted(false);

        Datastore.put(liveComment, live, ua);
        return liveComment;
    }

}
