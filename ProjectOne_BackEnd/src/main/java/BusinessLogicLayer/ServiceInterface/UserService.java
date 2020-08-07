package BusinessLogicLayer.ServiceInterface;

import DataAccessLayer.Bean.Vo.AdminVo;
import DataAccessLayer.Bean.Vo.UserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @auther tian
 * @date 2020/8/7 3:20 下午
 * @JDK_version JDK1.8
 */
public interface UserService
{
	List<UserVo> getAllUsers();

	int deleteUser(String id);

	List<UserVo> searchUser(String nickname);
}
