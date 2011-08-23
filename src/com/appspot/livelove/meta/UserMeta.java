package com.appspot.livelove.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2011-08-23 09:29:40")
/** */
public final class UserMeta extends org.slim3.datastore.ModelMeta<com.appspot.livelove.model.User> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.User, java.lang.Boolean> deleted = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.User, java.lang.Boolean>(this, "deleted", "deleted", boolean.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.User, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.User, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.User, java.util.Date> lastUpdateDate = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.User, java.util.Date>(this, "lastUpdateDate", "lastUpdateDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.livelove.model.User> mail = new org.slim3.datastore.StringAttributeMeta<com.appspot.livelove.model.User>(this, "mail", "mail");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.livelove.model.User> nickname = new org.slim3.datastore.StringAttributeMeta<com.appspot.livelove.model.User>(this, "nickname", "nickname");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.User, java.util.Date> registDate = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.User, java.util.Date>(this, "registDate", "registDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.appspot.livelove.model.User> userId = new org.slim3.datastore.StringAttributeMeta<com.appspot.livelove.model.User>(this, "userId", "userId");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.User, java.lang.Long> version = new org.slim3.datastore.CoreAttributeMeta<com.appspot.livelove.model.User, java.lang.Long>(this, "version", "version", java.lang.Long.class);

    private static final UserMeta slim3_singleton = new UserMeta();

    /**
     * @return the singleton
     */
    public static UserMeta get() {
       return slim3_singleton;
    }

    /** */
    public UserMeta() {
        super("User", com.appspot.livelove.model.User.class);
    }

    @Override
    public com.appspot.livelove.model.User entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.appspot.livelove.model.User model = new com.appspot.livelove.model.User();
        model.setDeleted(booleanToPrimitiveBoolean((java.lang.Boolean) entity.getProperty("deleted")));
        model.setKey(entity.getKey());
        model.setLastUpdateDate((java.util.Date) entity.getProperty("lastUpdateDate"));
        model.setMail((java.lang.String) entity.getProperty("mail"));
        model.setNickname((java.lang.String) entity.getProperty("nickname"));
        model.setRegistDate((java.util.Date) entity.getProperty("registDate"));
        model.setUserId((java.lang.String) entity.getProperty("userId"));
        model.setVersion((java.lang.Long) entity.getProperty("version"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.appspot.livelove.model.User m = (com.appspot.livelove.model.User) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("deleted", m.isDeleted());
        entity.setProperty("lastUpdateDate", m.getLastUpdateDate());
        entity.setProperty("mail", m.getMail());
        entity.setProperty("nickname", m.getNickname());
        entity.setProperty("registDate", m.getRegistDate());
        entity.setProperty("userId", m.getUserId());
        entity.setProperty("version", m.getVersion());
        entity.setProperty("slim3.schemaVersion", 1);
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.appspot.livelove.model.User m = (com.appspot.livelove.model.User) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.appspot.livelove.model.User m = (com.appspot.livelove.model.User) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        com.appspot.livelove.model.User m = (com.appspot.livelove.model.User) model;
        return m.getVersion() != null ? m.getVersion().longValue() : 0L;
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
        com.appspot.livelove.model.User m = (com.appspot.livelove.model.User) model;
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
        com.appspot.livelove.model.User m = (com.appspot.livelove.model.User) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        writer.setNextPropertyName("deleted");
        encoder0.encode(writer, m.isDeleted());
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getLastUpdateDate() != null){
            writer.setNextPropertyName("lastUpdateDate");
            encoder0.encode(writer, m.getLastUpdateDate());
        }
        if(m.getMail() != null){
            writer.setNextPropertyName("mail");
            encoder0.encode(writer, m.getMail());
        }
        if(m.getNickname() != null){
            writer.setNextPropertyName("nickname");
            encoder0.encode(writer, m.getNickname());
        }
        if(m.getRegistDate() != null){
            writer.setNextPropertyName("registDate");
            encoder0.encode(writer, m.getRegistDate());
        }
        if(m.getUserId() != null){
            writer.setNextPropertyName("userId");
            encoder0.encode(writer, m.getUserId());
        }
        if(m.getVersion() != null){
            writer.setNextPropertyName("version");
            encoder0.encode(writer, m.getVersion());
        }
        writer.endObject();
    }

    @Override
    protected com.appspot.livelove.model.User jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.appspot.livelove.model.User m = new com.appspot.livelove.model.User();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("deleted");
        m.setDeleted(decoder0.decode(reader, m.isDeleted()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("lastUpdateDate");
        m.setLastUpdateDate(decoder0.decode(reader, m.getLastUpdateDate()));
        reader = rootReader.newObjectReader("mail");
        m.setMail(decoder0.decode(reader, m.getMail()));
        reader = rootReader.newObjectReader("nickname");
        m.setNickname(decoder0.decode(reader, m.getNickname()));
        reader = rootReader.newObjectReader("registDate");
        m.setRegistDate(decoder0.decode(reader, m.getRegistDate()));
        reader = rootReader.newObjectReader("userId");
        m.setUserId(decoder0.decode(reader, m.getUserId()));
        reader = rootReader.newObjectReader("version");
        m.setVersion(decoder0.decode(reader, m.getVersion()));
        return m;
    }
}