package com.russ4stall.critter.db;

import com.russ4stall.critter.core.User;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
 * Date: 10/15/14
 * Time: 11:45 AM
 *
 * @author Russ Forstall
 */
@RegisterMapper(UserMapper.class)
public interface UserDao {
    @SqlQuery("SELECT * FROM User WHERE email = :email")
    User getUserByEmail(@Bind("email") String email);

    @SqlUpdate("insert into User (name, email, password) values (:name, :email, :password)")
    @GetGeneratedKeys
    int insert(@Bind("name") String name, @Bind("email") String email, @Bind("password") String password);



    void close();
}
