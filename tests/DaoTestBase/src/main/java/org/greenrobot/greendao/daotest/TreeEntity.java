package org.greenrobot.greendao.daotest;

import org.greenrobot.greendao.annotation.*;

import java.util.List;
import org.greenrobot.greendao.daotest.DaoSession;
import org.greenrobot.greendao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "TREE_ENTITY".
 */
@Entity(active = true)
public class TreeEntity {

    @Id
    private Long id;
    private Long parentId;

    /** Used to resolve relations */
    @Generated
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated
    private transient TreeEntityDao myDao;

    @ToOne(joinProperty = "parentId")
    private TreeEntity parent;

    @Generated
    private transient Long parent__resolvedKey;

    @ToMany(joinProperties = {
        @JoinProperty(name = "id", referencedName = "parentId")
    })
    private List<TreeEntity> children;

    @Generated
    public TreeEntity() {
    }

    public TreeEntity(Long id) {
        this.id = id;
    }

    @Generated
    public TreeEntity(Long id, Long parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTreeEntityDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated
    public TreeEntity getParent() {
        Long __key = this.parentId;
        if (parent__resolvedKey == null || !parent__resolvedKey.equals(__key)) {
            __throwIfDetached();
            TreeEntityDao targetDao = daoSession.getTreeEntityDao();
            TreeEntity parentNew = targetDao.load(__key);
            synchronized (this) {
                parent = parentNew;
            	parent__resolvedKey = __key;
            }
        }
        return parent;
    }

    @Generated
    public void setParent(TreeEntity parent) {
        synchronized (this) {
            this.parent = parent;
            parentId = parent == null ? null : parent.getId();
            parent__resolvedKey = parentId;
        }
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    @Generated
    public List<TreeEntity> getChildren() {
        if (children == null) {
            __throwIfDetached();
            TreeEntityDao targetDao = daoSession.getTreeEntityDao();
            List<TreeEntity> childrenNew = targetDao._queryTreeEntity_Children(id);
            synchronized (this) {
                if(children == null) {
                    children = childrenNew;
                }
            }
        }
        return children;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated
    public synchronized void resetChildren() {
        children = null;
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void delete() {
        __throwIfDetached();
        myDao.delete(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void update() {
        __throwIfDetached();
        myDao.update(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void refresh() {
        __throwIfDetached();
        myDao.refresh(this);
    }

    @Generated
    private void __throwIfDetached() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
    }

}
