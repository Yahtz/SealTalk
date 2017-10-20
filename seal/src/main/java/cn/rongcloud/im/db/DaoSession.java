package cn.rongcloud.im.db;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;


/**
 * {@inheritDoc}
 *
 * @see AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig friendDaoConfig;
    private final DaoConfig groupsDaoConfig;
    private final DaoConfig groupMemberDaoConfig;
    private final DaoConfig blackListDaoConfig;

    private final FriendDao friendDao;
    private final GroupsDao groupsDao;
    private final BlackListDao blackListDao;
    private final GroupMemberDao groupMemberDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
                      daoConfigMap) {
        super(db);

        friendDaoConfig = daoConfigMap.get(FriendDao.class).clone();
        friendDaoConfig.initIdentityScope(type);

        groupsDaoConfig = daoConfigMap.get(GroupsDao.class).clone();
        groupsDaoConfig.initIdentityScope(type);

        groupMemberDaoConfig = daoConfigMap.get(GroupMemberDao.class).clone();
        groupMemberDaoConfig.initIdentityScope(type);

        blackListDaoConfig = daoConfigMap.get(BlackListDao.class).clone();
        blackListDaoConfig.initIdentityScope(type);


        friendDao = new FriendDao(friendDaoConfig, this);
        groupsDao = new GroupsDao(groupsDaoConfig, this);
        groupMemberDao = new GroupMemberDao(groupMemberDaoConfig, this);
        blackListDao = new BlackListDao(blackListDaoConfig, this);

        registerDao(Friend.class, friendDao);
        registerDao(Groups.class, groupsDao);
        registerDao(BlackList.class, blackListDao);
        registerDao(GroupMember.class, groupMemberDao);
    }

    public void clear() {
        friendDaoConfig.getIdentityScope().clear();
        groupsDaoConfig.getIdentityScope().clear();
        groupMemberDaoConfig.getIdentityScope().clear();
        blackListDaoConfig.getIdentityScope().clear();
    }

    public FriendDao getFriendDao() {
        return friendDao;
    }


    public GroupsDao getGroupsDao() {
        return groupsDao;
    }

    public BlackListDao getBlackListDao() {
        return blackListDao;
    }

    public GroupMemberDao getGroupMemberDao() {
        return groupMemberDao;
    }

}
