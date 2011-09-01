package com.appspot.livelove.service;

import java.util.Date;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.appspot.livelove.meta.UserAccountMeta;
import com.appspot.livelove.model.UserAccount;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public class UserAccountService {

    private UserAccountMeta uam = new UserAccountMeta();

    public UserAccount registUserAccount(Map<String, Object> input,
            UserAccount ua) {
        BeanUtil.copy(input, ua);
        ua.setRegistDate(new Date());
        ua.setLastUpdateDate(new Date());
        ua.setDeleted(false);
        ua.setLastLoginDate(new Date());

        Transaction tx = Datastore.beginTransaction();
        Datastore.put(ua);
        tx.commit();

        return ua;
    }

    public UserAccount getUserAccount(Key key) {
        return Datastore.get(uam, key);
    }

    public boolean updateUserAccount(Key key, Map<String, Object> input, UserAccount ua) {
        if (isEditableUser(key, ua)) {
            BeanUtil.copy(input, ua);
            ua.setLastUpdateDate(new Date());
            Datastore.put(ua);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteUserAccount(Key key, UserAccount ua) {
        if (isEditableUser(key, ua)) {
            UserAccount target = Datastore.get(uam, key);
            target.setLastUpdateDate(new Date());
            target.setDeleted(true);
            Datastore.put(target);
            return true;
        } else {
            return false;
        }
    }

    public boolean isEditableUser(Key key, UserAccount ua) {
        UserAccount target = Datastore.get(uam, key);
        if (target.equals(ua)) {
            return true;
        } else {
            return false;
        }
    }
}
