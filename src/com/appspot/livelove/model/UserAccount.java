package com.appspot.livelove.model;

import java.io.Serializable;
import java.util.Date;

import com.appspot.livelove.meta.LiveCommentMeta;
import com.appspot.livelove.meta.LiveMeta;
import com.appspot.livelove.meta.UserAccountLiveMeta;
import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String userId;

    private String accountType;

    private String nickname;

    private String mail;

    private Date lastLoginDate;

    @Attribute(persistent = false)
    private InverseModelListRef<Live, UserAccount> registLiveListRef =
        new InverseModelListRef<Live, UserAccount>(
            Live.class,
            LiveMeta.get().registUserAccountRef.getName(),
            this);

    @Attribute(persistent = false)
    private InverseModelListRef<Live, UserAccount> lastUpdateLiveListRef =
        new InverseModelListRef<Live, UserAccount>(
            Live.class,
            LiveMeta.get().lastUpdateUserAccountRef.getName(),
            this);

    @Attribute(persistent = false)
    private InverseModelListRef<LiveComment, UserAccount> registLiveCommentListRef =
        new InverseModelListRef<LiveComment, UserAccount>(
            LiveComment.class,
            LiveCommentMeta.get().registUserAccountRef.getName(),
            this);

    @Attribute(persistent = false)
    private InverseModelListRef<LiveComment, UserAccount> lastUpdateLiveCommentListRef =
        new InverseModelListRef<LiveComment, UserAccount>(
            LiveComment.class,
            LiveCommentMeta.get().registUserAccountRef.getName(),
            this);

    @Attribute(persistent = false)
    private InverseModelListRef<UserAccountLive, UserAccount> userAccoountLiveListRef =
        new InverseModelListRef<UserAccountLive, UserAccount>(
            UserAccountLive.class,
            UserAccountLiveMeta.get().userAccountRef.getName(),
            this);

    private Date registDate;

    private Date lastUpdateDate;

    private boolean isDeleted;

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public InverseModelListRef<Live, UserAccount> getRegistLiveListRef() {
        return registLiveListRef;
    }

    public InverseModelListRef<Live, UserAccount> getLastUpdateLiveListRef() {
        return lastUpdateLiveListRef;
    }

    public InverseModelListRef<LiveComment, UserAccount> getRegistLiveCommentListRef() {
        return registLiveCommentListRef;
    }

    public InverseModelListRef<LiveComment, UserAccount> getLastUpdateLiveCommentListRef() {
        return lastUpdateLiveCommentListRef;
    }

    public InverseModelListRef<UserAccountLive, UserAccount> getUserAccoountLiveListRef() {
        return userAccoountLiveListRef;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserAccount other = (UserAccount) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
}
