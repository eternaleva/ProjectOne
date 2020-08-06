package BusinessLogicLayer.ServiceImp;

import BusinessLogicLayer.ServiceInterface.AdminService;
import DataAccessLayer.Bean.Bo.AdminBo;
import DataAccessLayer.Bean.Vo.AdminInfo;
import DataAccessLayer.DaoInterface.AdminDao;
import DataAccessLayer.DaoImp.AdminUserDao;

import java.util.List;

/**
 * @auther tian
 * @date 2020/8/6 5:58 下午
 * @JDK_version JDK1.8
 */
public class AdminServiceImp1 implements AdminService
{
	private AdminDao adminDao = new AdminUserDao();

	public int login(AdminBo adminBo)
	{
		int loginResult = adminDao.login(adminBo);
		return loginResult;
	}

	public List<AdminInfo> getAllAdmins()
	{
		//再交给AdminUserDao来处理
		return adminDao.getAllAdmins();
	}

	@Override
	public int addAdmin(AdminInfo adminInfo)
	{
		return adminDao.addAdmin(adminInfo);
	}
}
