package com.why.newsbeat.dao.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.why.newsbeat.base.history.bean.History;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "HISTORY".
*/
public class HistoryDao extends AbstractDao<History, String> {

    public static final String TABLENAME = "HISTORY";

    /**
     * Properties of entity History.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Username = new Property(0, String.class, "username", false, "USERNAME");
        public final static Property Uniquekey = new Property(1, String.class, "uniquekey", true, "UNIQUEKEY");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property Date = new Property(3, String.class, "date", false, "DATE");
        public final static Property Category = new Property(4, String.class, "category", false, "CATEGORY");
        public final static Property Author_name = new Property(5, String.class, "author_name", false, "AUTHOR_NAME");
        public final static Property Url = new Property(6, String.class, "url", false, "URL");
        public final static Property Thumbnail_pic_s = new Property(7, String.class, "thumbnail_pic_s", false, "THUMBNAIL_PIC_S");
        public final static Property Thumbnail_pic_s02 = new Property(8, String.class, "thumbnail_pic_s02", false, "THUMBNAIL_PIC_S02");
        public final static Property Thumbnail_pic_s03 = new Property(9, String.class, "thumbnail_pic_s03", false, "THUMBNAIL_PIC_S03");
    }


    public HistoryDao(DaoConfig config) {
        super(config);
    }
    
    public HistoryDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"HISTORY\" (" + //
                "\"USERNAME\" TEXT," + // 0: username
                "\"UNIQUEKEY\" TEXT PRIMARY KEY NOT NULL UNIQUE ," + // 1: uniquekey
                "\"TITLE\" TEXT," + // 2: title
                "\"DATE\" TEXT," + // 3: date
                "\"CATEGORY\" TEXT," + // 4: category
                "\"AUTHOR_NAME\" TEXT," + // 5: author_name
                "\"URL\" TEXT," + // 6: url
                "\"THUMBNAIL_PIC_S\" TEXT," + // 7: thumbnail_pic_s
                "\"THUMBNAIL_PIC_S02\" TEXT," + // 8: thumbnail_pic_s02
                "\"THUMBNAIL_PIC_S03\" TEXT);"); // 9: thumbnail_pic_s03
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HISTORY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, History entity) {
        stmt.clearBindings();
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(1, username);
        }
 
        String uniquekey = entity.getUniquekey();
        if (uniquekey != null) {
            stmt.bindString(2, uniquekey);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(4, date);
        }
 
        String category = entity.getCategory();
        if (category != null) {
            stmt.bindString(5, category);
        }
 
        String author_name = entity.getAuthor_name();
        if (author_name != null) {
            stmt.bindString(6, author_name);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(7, url);
        }
 
        String thumbnail_pic_s = entity.getThumbnail_pic_s();
        if (thumbnail_pic_s != null) {
            stmt.bindString(8, thumbnail_pic_s);
        }
 
        String thumbnail_pic_s02 = entity.getThumbnail_pic_s02();
        if (thumbnail_pic_s02 != null) {
            stmt.bindString(9, thumbnail_pic_s02);
        }
 
        String thumbnail_pic_s03 = entity.getThumbnail_pic_s03();
        if (thumbnail_pic_s03 != null) {
            stmt.bindString(10, thumbnail_pic_s03);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, History entity) {
        stmt.clearBindings();
 
        String username = entity.getUsername();
        if (username != null) {
            stmt.bindString(1, username);
        }
 
        String uniquekey = entity.getUniquekey();
        if (uniquekey != null) {
            stmt.bindString(2, uniquekey);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(4, date);
        }
 
        String category = entity.getCategory();
        if (category != null) {
            stmt.bindString(5, category);
        }
 
        String author_name = entity.getAuthor_name();
        if (author_name != null) {
            stmt.bindString(6, author_name);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(7, url);
        }
 
        String thumbnail_pic_s = entity.getThumbnail_pic_s();
        if (thumbnail_pic_s != null) {
            stmt.bindString(8, thumbnail_pic_s);
        }
 
        String thumbnail_pic_s02 = entity.getThumbnail_pic_s02();
        if (thumbnail_pic_s02 != null) {
            stmt.bindString(9, thumbnail_pic_s02);
        }
 
        String thumbnail_pic_s03 = entity.getThumbnail_pic_s03();
        if (thumbnail_pic_s03 != null) {
            stmt.bindString(10, thumbnail_pic_s03);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1);
    }    

    @Override
    public History readEntity(Cursor cursor, int offset) {
        History entity = new History( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // username
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // uniquekey
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // date
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // category
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // author_name
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // url
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // thumbnail_pic_s
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // thumbnail_pic_s02
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // thumbnail_pic_s03
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, History entity, int offset) {
        entity.setUsername(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setUniquekey(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDate(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setCategory(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setAuthor_name(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setUrl(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setThumbnail_pic_s(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setThumbnail_pic_s02(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setThumbnail_pic_s03(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
     }
    
    @Override
    protected final String updateKeyAfterInsert(History entity, long rowId) {
        return entity.getUniquekey();
    }
    
    @Override
    public String getKey(History entity) {
        if(entity != null) {
            return entity.getUniquekey();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(History entity) {
        return entity.getUniquekey() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
