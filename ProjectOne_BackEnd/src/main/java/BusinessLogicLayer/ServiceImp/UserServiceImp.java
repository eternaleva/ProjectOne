package BusinessLogicLayer.ServiceImp;

import BusinessLogicLayer.ServiceInterface.UserService;
import DataAccessLayer.Bean.Vo.UserVo;
import DataAccessLayer.DaoImp.UserDaoImp;
import DataAccessLayer.DaoInterface.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @auther tian
 * @date 2020/8/7 3:21 下午
 * @JDK_version JDK1.8
 */
public class UserServiceImp implements UserService
{
	//一个实现UserDao的成员类，负责调用UserDao的方法
	private UserDao userDao = new UserDaoImp();

	@Override
	public List<UserVo> getAllUsers()
	{
		return userDao.getAllUsers();
	}

	@Override
	public int deleteUser(String id)
	{
		return userDao.deleteUser(id);
	}

	@Override
	public List<UserVo> searchUser(String nickname)
	{
		return userDao.searchUser(nickname);
	}
}
