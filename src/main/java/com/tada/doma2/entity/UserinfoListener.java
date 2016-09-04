package com.tada.doma2.entity;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostDeleteContext;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PostUpdateContext;
import org.seasar.doma.jdbc.entity.PreDeleteContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;
import org.seasar.doma.jdbc.entity.PreUpdateContext;

/**
 * 
 */
public class UserinfoListener implements EntityListener<Userinfo> {

    @Override
    public void preInsert(Userinfo entity, PreInsertContext<Userinfo> context) {
    }

    @Override
    public void preUpdate(Userinfo entity, PreUpdateContext<Userinfo> context) {
    }

    @Override
    public void preDelete(Userinfo entity, PreDeleteContext<Userinfo> context) {
    }

    @Override
    public void postInsert(Userinfo entity, PostInsertContext<Userinfo> context) {
    }

    @Override
    public void postUpdate(Userinfo entity, PostUpdateContext<Userinfo> context) {
    }

    @Override
    public void postDelete(Userinfo entity, PostDeleteContext<Userinfo> context) {
    }
}