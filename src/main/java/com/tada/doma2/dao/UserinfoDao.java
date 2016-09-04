package com.tada.doma2.dao;

import com.peridotto.testcase.AppConfig;
import com.tada.doma2.entity.Userinfo;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Update;

/**
 */
@Dao(config = AppConfig.class)
public interface UserinfoDao {

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Userinfo entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Userinfo entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Userinfo entity);
}