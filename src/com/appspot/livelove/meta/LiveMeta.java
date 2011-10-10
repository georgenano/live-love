package com.appspot.livelove.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-10-10 16:04:33")
/** */
public final class LiveMeta extends org.slim3.datastore.ModelMeta<com.appspot.livelove.model.Live> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.lang.Integer> advanceCharge = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.lang.Integer>(this, "advanceCharge", "advanceCharge", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.lang.Boolean> deleted = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.lang.Boolean>(this, "deleted", "deleted", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.lang.Boolean> includeDrink = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.lang.Boolean>(this, "includeDrink", "includeDrink", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.util.Date> lastUpdateDate = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.util.Date>(this, "lastUpdateDate", "lastUpdateDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.appspot.livelove.model.Live, org.slim3.datastore.ModelRef<com.appspot.livelove.model.UserAccount>, com.appspot.livelove.model.UserAccount> lastUpdateUserAccountRef = new org.slim3.datastore.ModelRefAttributeMeta<com.appspot.livelove.model.Live, org.slim3.datastore.ModelRef<com.appspot.livelove.model.UserAccount>, com.appspot.livelove.model.UserAccount>(this, "lastUpdateUserAccountRef", "lastUpdateUserAccountRef", org.slim3.datastore.ModelRef.class, com.appspot.livelove.model.UserAccount.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.util.Date> liveEndDate = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.util.Date>(this, "liveEndDate", "liveEndDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.livelove.model.Live> liveName = new org.slim3.datastore.StringAttributeMeta<com.appspot.livelove.model.Live>(this, "liveName", "liveName");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.util.Date> liveOpenDate = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.util.Date>(this, "liveOpenDate", "liveOpenDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.livelove.model.Live> livePlace = new org.slim3.datastore.StringAttributeMeta<com.appspot.livelove.model.Live>(this, "livePlace", "livePlace");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.util.Date> liveStartDate = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.util.Date>(this, "liveStartDate", "liveStartDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.livelove.model.Live> note = new org.slim3.datastore.StringAttributeMeta<com.appspot.livelove.model.Live>(this, "note", "note");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.livelove.model.Live> pref = new org.slim3.datastore.StringAttributeMeta<com.appspot.livelove.model.Live>(this, "pref", "pref");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.util.Date> registDate = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.util.Date>(this, "registDate", "registDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<com.appspot.livelove.model.Live, org.slim3.datastore.ModelRef<com.appspot.livelove.model.UserAccount>, com.appspot.livelove.model.UserAccount> registUserAccountRef = new org.slim3.datastore.ModelRefAttributeMeta<com.appspot.livelove.model.Live, org.slim3.datastore.ModelRef<com.appspot.livelove.model.UserAccount>, com.appspot.livelove.model.UserAccount>(this, "registUserAccountRef", "registUserAccountRef", org.slim3.datastore.ModelRef.class, com.appspot.livelove.model.UserAccount.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.lang.Integer> todayCharge = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.lang.Integer>(this, "todayCharge", "todayCharge", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.Live, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final LiveMeta slim3_singleton = new LiveMeta();

    /**
     * @return the singleton
     */
    public static LiveMeta get() {
       return slim3_singleton;
    }

    /** */
    public LiveMeta() {
        super("Live", com.appspot.livelove.model.Live.class);
    }

    @Override
    public com.appspot.livelove.model.Live entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.appspot.livelove.model.Live model = new com.appspot.livelove.model.Live();
        model.setAdvanceCharge(longToInteger((java.lang.Long) entity.getProperty("advanceCharge")));
        model.setDeleted(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("deleted")));
        model.setIncludeDrink(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("includeDrink")));
        model.setKey(entity.getKey());
        model.setLastUpdateDate((java.util.Date) entity.getProperty("lastUpdateDate"));
        if (model.getLastUpdateUserAccountRef() == null) {
            throw new NullPointerException("The property(lastUpdateUserAccountRef) is null.");
        }
        model.getLastUpdateUserAccountRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("lastUpdateUserAccountRef"));
        model.setLiveEndDate((java.util.Date) entity.getProperty("liveEndDate"));
        model.setLiveName((java.lang.String) entity.getProperty("liveName"));
        model.setLiveOpenDate((java.util.Date) entity.getProperty("liveOpenDate"));
        model.setLivePlace((java.lang.String) entity.getProperty("livePlace"));
        model.setLiveStartDate((java.util.Date) entity.getProperty("liveStartDate"));
        model.setNote((java.lang.String) entity.getProperty("note"));
        model.setPref((java.lang.String) entity.getProperty("pref"));
        model.setRegistDate((java.util.Date) entity.getProperty("registDate"));
        if (model.getRegistUserAccountRef() == null) {
            throw new NullPointerException("The property(registUserAccountRef) is null.");
        }
        model.getRegistUserAccountRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("registUserAccountRef"));
        model.setTodayCharge(longToInteger((java.lang.Long) entity.getProperty("todayCharge")));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.appspot.livelove.model.Live m = (com.appspot.livelove.model.Live) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("advanceCharge", m.getAdvanceCharge());
        entity.setProperty("deleted", m.isDeleted());
        entity.setProperty("includeDrink", m.isIncludeDrink());
        entity.setProperty("lastUpdateDate", m.getLastUpdateDate());
        if (m.getLastUpdateUserAccountRef() == null) {
            throw new NullPointerException("The property(lastUpdateUserAccountRef) must not be null.");
        }
        entity.setProperty("lastUpdateUserAccountRef", m.getLastUpdateUserAccountRef().getKey());
        entity.setProperty("liveEndDate", m.getLiveEndDate());
        entity.setProperty("liveName", m.getLiveName());
        entity.setProperty("liveOpenDate", m.getLiveOpenDate());
        entity.setProperty("livePlace", m.getLivePlace());
        entity.setProperty("liveStartDate", m.getLiveStartDate());
        entity.setProperty("note", m.getNote());
        entity.setProperty("pref", m.getPref());
        entity.setProperty("registDate", m.getRegistDate());
        if (m.getRegistUserAccountRef() == null) {
            throw new NullPointerException("The property(registUserAccountRef) must not be null.");
        }
        entity.setProperty("registUserAccountRef", m.getRegistUserAccountRef().getKey());
        entity.setProperty("todayCharge", m.getTodayCharge());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.appspot.livelove.model.Live m = (com.appspot.livelove.model.Live) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.appspot.livelove.model.Live m = (com.appspot.livelove.model.Live) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.appspot.livelove.model.Live m = (com.appspot.livelove.model.Live) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        com.appspot.livelove.model.Live m = (com.appspot.livelove.model.Live) model;
        if (m.getLastUpdateUserAccountRef() == null) {
            throw new NullPointerException("The property(lastUpdateUserAccountRef) must not be null.");
        }
        m.getLastUpdateUserAccountRef().assignKeyIfNecessary(ds);
        if (m.getRegistUserAccountRef() == null) {
            throw new NullPointerException("The property(registUserAccountRef) must not be null.");
        }
        m.getRegistUserAccountRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
        com.appspot.livelove.model.Live m = (com.appspot.livelove.model.Live) model;
        long version = m.getVersion() != null ? m.getVersion().longValue() : 0L;
        m.setVersion(Long.valueOf(version + 1L));
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.appspot.livelove.model.Live m = (com.appspot.livelove.model.Live) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getAdvanceCharge() != null){
            writer.setNextPropertyName("advanceCharge");
            encoder0.encode(writer, m.getAdvanceCharge());
        }
        if(m.getArtistLiveListRef() != null){
            writer.setNextPropertyName("artistLiveListRef");
            encoder0.encode(writer, m.getArtistLiveListRef());
        }
        writer.setNextPropertyName("deleted");
        encoder0.encode(writer, m.isDeleted());
        writer.setNextPropertyName("includeDrink");
        encoder0.encode(writer, m.isIncludeDrink());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getLastUpdateDate() != null){
            writer.setNextPropertyName("lastUpdateDate");
            encoder0.encode(writer, m.getLastUpdateDate());
        }
        if(m.getLastUpdateUserAccountRef() != null && m.getLastUpdateUserAccountRef().getKey() != null){
            writer.setNextPropertyName("lastUpdateUserAccountRef");
            encoder0.encode(writer, m.getLastUpdateUserAccountRef(), maxDepth, currentDepth);
        }
        if(m.getLiveCommentListRef() != null){
            writer.setNextPropertyName("liveCommentListRef");
            encoder0.encode(writer, m.getLiveCommentListRef());
        }
        if(m.getLiveEndDate() != null){
            writer.setNextPropertyName("liveEndDate");
            encoder0.encode(writer, m.getLiveEndDate());
        }
        if(m.getLiveName() != null){
            writer.setNextPropertyName("liveName");
            encoder0.encode(writer, m.getLiveName());
        }
        if(m.getLiveOpenDate() != null){
            writer.setNextPropertyName("liveOpenDate");
            encoder0.encode(writer, m.getLiveOpenDate());
        }
        if(m.getLivePlace() != null){
            writer.setNextPropertyName("livePlace");
            encoder0.encode(writer, m.getLivePlace());
        }
        if(m.getLiveStartDate() != null){
            writer.setNextPropertyName("liveStartDate");
            encoder0.encode(writer, m.getLiveStartDate());
        }
        if(m.getNote() != null){
            writer.setNextPropertyName("note");
            encoder0.encode(writer, m.getNote());
        }
        if(m.getPref() != null){
            writer.setNextPropertyName("pref");
            encoder0.encode(writer, m.getPref());
        }
        if(m.getRegistDate() != null){
            writer.setNextPropertyName("registDate");
            encoder0.encode(writer, m.getRegistDate());
        }
        if(m.getRegistUserAccountRef() != null && m.getRegistUserAccountRef().getKey() != null){
            writer.setNextPropertyName("registUserAccountRef");
            encoder0.encode(writer, m.getRegistUserAccountRef(), maxDepth, currentDepth);
        }
        if(m.getTodayCharge() != null){
            writer.setNextPropertyName("todayCharge");
            encoder0.encode(writer, m.getTodayCharge());
        }
        if(m.getUserAccountLiveListRef() != null){
            writer.setNextPropertyName("userAccountLiveListRef");
            encoder0.encode(writer, m.getUserAccountLiveListRef());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.appspot.livelove.model.Live jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.appspot.livelove.model.Live m = new com.appspot.livelove.model.Live();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("advanceCharge");
        m.setAdvanceCharge(decoder0.decode(reader, m.getAdvanceCharge()));
        reader = rootReader.newObjectReader("artistLiveListRef");
        reader = rootReader.newObjectReader("deleted");
        m.setDeleted(decoder0.decode(reader, m.isDeleted()));
        reader = rootReader.newObjectReader("includeDrink");
        m.setIncludeDrink(decoder0.decode(reader, m.isIncludeDrink()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("lastUpdateDate");
        m.setLastUpdateDate(decoder0.decode(reader, m.getLastUpdateDate()));
        reader = rootReader.newObjectReader("lastUpdateUserAccountRef");
        decoder0.decode(reader, m.getLastUpdateUserAccountRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("liveCommentListRef");
        reader = rootReader.newObjectReader("liveEndDate");
        m.setLiveEndDate(decoder0.decode(reader, m.getLiveEndDate()));
        reader = rootReader.newObjectReader("liveName");
        m.setLiveName(decoder0.decode(reader, m.getLiveName()));
        reader = rootReader.newObjectReader("liveOpenDate");
        m.setLiveOpenDate(decoder0.decode(reader, m.getLiveOpenDate()));
        reader = rootReader.newObjectReader("livePlace");
        m.setLivePlace(decoder0.decode(reader, m.getLivePlace()));
        reader = rootReader.newObjectReader("liveStartDate");
        m.setLiveStartDate(decoder0.decode(reader, m.getLiveStartDate()));
        reader = rootReader.newObjectReader("note");
        m.setNote(decoder0.decode(reader, m.getNote()));
        reader = rootReader.newObjectReader("pref");
        m.setPref(decoder0.decode(reader, m.getPref()));
        reader = rootReader.newObjectReader("registDate");
        m.setRegistDate(decoder0.decode(reader, m.getRegistDate()));
        reader = rootReader.newObjectReader("registUserAccountRef");
        decoder0.decode(reader, m.getRegistUserAccountRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("todayCharge");
        m.setTodayCharge(decoder0.decode(reader, m.getTodayCharge()));
        reader = rootReader.newObjectReader("userAccountLiveListRef");
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}