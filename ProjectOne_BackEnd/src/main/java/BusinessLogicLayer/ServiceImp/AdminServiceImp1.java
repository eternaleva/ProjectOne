package BusinessLogicLayer.ServiceImp;

import BusinessLogicLayer.ServiceInterface.AdminService;
import DataAccessLayer.Bean.Bo.AdminBo;
import DataAccessLayer.Bean.Bo.AdminChangePwdBo;
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
	//一个实现AdminDao接口的成员类，负责调用AdminDao的方法
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

	@Override
	public int deleteAdmin(String id)
	{
		return adminDao.deleteAdmin(id);
	}

	@Override
	public int alterAdminInfo(AdminInfo adminInfo)
	{
		return adminDao.alterAdminInfo(adminInfo);
	}

	@Override
	public AdminInfo getAdminInfo(String id)
	{
		return adminDao.getAdminInfo(id);
	}

	@Override
	public List<AdminInfo> getSearchAdmins(AdminInfo adminInfo)
	{
		return adminDao.getSearchAdmins(adminInfo);
	}

	@Override
	public int changePwd(AdminChangePwdBo adminChangePwdBo)
	{
		return adminDao.changePwd(adminChangePwdBo);
	}
}
