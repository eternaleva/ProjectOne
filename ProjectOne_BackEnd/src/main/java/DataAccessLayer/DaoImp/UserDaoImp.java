package DataAccessLayer.DaoImp;

import BusinessLogicLayer.Utils.DruidUtils;
import DataAccessLayer.Bean.Vo.User.UserVo;
import DataAccessLayer.DaoInterface.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther tian
 * @date 2020/8/7 3:20 下午
 * @JDK_version JDK1.8
 */
public class UserDaoImp implements UserDao
{
	QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());

	@Override
	public List<UserVo> getAllUsers()
	{
		List<UserVo> users = new ArrayList<>();
		try
		{
			users = runner.query("select * from Users", new BeanListHandler<UserVo>(UserVo.class));
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		return users;
	}

	@Override
	public int deleteUser(String id)
	{
		try
		{
			runner.update("delete from users where id = ?", id);
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public List<UserVo> searchUser(String nickname)
	{
		List<UserVo> users = new ArrayList<>();
		try
		{
			users = runner.query("select * from users where nickname like ?",
					new BeanListHandler<UserVo>(UserVo.class),
					"%" + nickname + "%");
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		return users;
	}
}
