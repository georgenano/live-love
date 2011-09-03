package com.appspot.livelove.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.appspot.livelove.meta.LiveCommentMeta;
import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

@Model(schemaVersion = 1)
public class Live implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    private String liveName;

    private List<String> artists;

    private String pref;

    private String livePlace;

    private Date liveOpenDate;

    private Date liveStartDate;

    private Date liveEndDate;

    private Integer advanceCharge;

    private Integer todayCharge;

    private boolean isIncludeDrink;

    private String note;

    @Attribute(persistent = false)
    private InverseModelListRef<LiveComment, Live> liveCommentListRef =
        new InverseModelListRef<LiveComment, Live>(
            LiveComment.class,
            LiveCommentMeta.get().targetLiveRef.getName(),
            this);

    private ModelRef<UserAccount> registUserAccountRef =
        new ModelRef<UserAccount>(UserAccount.class);

    private Date registDate;

    private Date lastUpdateDate;

    private ModelRef<UserAccount> lastUpdateUserAccountRef =
        new ModelRef<UserAccount>(UserAccount.class);

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

    public String getLiveName() {
        return liveName;
    }

    public void setLiveName(String liveName) {
        this.liveName = liveName;
    }

    public List<String> getArtists() {
        return artists;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public String getPref() {
        return pref;
    }

    public void setPref(String pref) {
        this.pref = pref;
    }

    public String getLivePlace() {
        return livePlace;
    }

    public void setLivePlace(String livePlace) {
        this.livePlace = livePlace;
    }

    public Date getLiveOpenDate() {
        return liveOpenDate;
    }

    public void setLiveOpenDate(Date liveOpenDate) {
        this.liveOpenDate = liveOpenDate;
    }

    public Date getLiveStartDate() {
        return liveStartDate;
    }

    public void setLiveStartDate(Date liveStartDate) {
        this.liveStartDate = liveStartDate;
    }

    public Date getLiveEndDate() {
        return liveEndDate;
    }

    public void setLiveEndDate(Date liveEndDate) {
        this.liveEndDate = liveEndDate;
    }

    public Integer getAdvanceCharge() {
        return advanceCharge;
    }

    public void setAdvanceCharge(Integer advanceCharge) {
        this.advanceCharge = advanceCharge;
    }

    public Integer getTodayCharge() {
        return todayCharge;
    }

    public void setTodayCharge(Integer todayCharge) {
        this.todayCharge = todayCharge;
    }

    public boolean isIncludeDrink() {
        return isIncludeDrink;
    }

    public void setIncludeDrink(boolean isIncludeDrink) {
        this.isIncludeDrink = isIncludeDrink;
    }

    public void setIsIncludeDrink(Boolean isIncludeDrink) {
        this.isIncludeDrink = isIncludeDrink;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public InverseModelListRef<LiveComment, Live> getLiveCommentListRef() {
        return liveCommentListRef;
    }

    public ModelRef<UserAccount> getRegistUserAccountRef() {
        return registUserAccountRef;
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

    public ModelRef<UserAccount> getLastUpdateUserAccountRef() {
        return lastUpdateUserAccountRef;
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
        Live other = (Live) obj;
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
