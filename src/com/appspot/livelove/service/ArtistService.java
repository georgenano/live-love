package com.appspot.livelove.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.appspot.livelove.meta.ArtistMeta;
import com.appspot.livelove.model.Artist;
import com.appspot.livelove.model.UserAccount;
import com.google.appengine.api.datastore.Key;

public class ArtistService {

    private ArtistMeta am = new ArtistMeta();

    public Artist registArtist(Map<String, Object> input, UserAccount ua) {
        Artist artist = new Artist();

        BeanUtil.copy(input, artist);

        // �ʖ����X�g��ݒ�
        String anothersStr = (String) input.get("anotherNameList");
        if (anothersStr != null) {
            String[] anothers = anothersStr.split(",");
            List<String> anotherNameList = new ArrayList<String>();
            for (String another : anothers) {
                anotherNameList.add(another);
            }
            artist.setAnotherNames(anotherNameList);
        } else {
            artist.setAnotherNames(new ArrayList<String>());
        }

        // �o�^���A�o�^���[�U�A�ŏI�X�V���A�ŏI�X�V���[�U�A�폜�t���O��ݒ�
        artist.setRegistDate(new Date());
        artist.getRegistUserAccountRef().setModel(ua);
        artist.setLastUpdateDate(new Date());
        artist.getLastUpdateUserAccountRef().setModel(ua);
        artist.setDeleted(false);

        Datastore.put(ua, artist);

        return artist;
    }

    public Artist getArtist(Key key){
        return Datastore.get(am, key);
    }

    public Artist getArtist(String name){
        List<Artist> artists = Datastore
                .query(am)
                .filter(
                    am.name.equal(name),
                    am.deleted.equal(false))
                .sort(am.lastUpdateDate.asc)
                .asList();
                return artists.get(0);
    }

    public Key getKey(String name){
        return getArtist(name).getKey();
    }

    public boolean isEditableUser(Key key, UserAccount ua) {
        Artist target = Datastore.get(am, key);
        if (target.getRegistUserAccountRef().getModel().equals(ua)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean inputCheck(Map<String, Object> input) {
        String name = (String) input.get("name");
        if (name != "") {
            return true;
        }
        return false;
    }
}