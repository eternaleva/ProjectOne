package BusinessLogicLayer.ServiceInterface;

import DataAccessLayer.Bean.Bo.Admin.AdminBo;
import DataAccessLayer.Bean.Bo.Admin.AdminChangePwdBo;
import DataAccessLayer.Bean.Bo.Admin.TokenBo;
import DataAccessLayer.Bean.Vo.Admin.AdminInfo;

import java.util.List;

/**
 * @auther tian
 * @date 2020/8/6 5:58 下午
 * @JDK_version JDK1.8
 */
public interface AdminService
{
	int login(AdminBo adminBo);

	List<AdminInfo> getAllAdmins();

	int addAdmin(AdminInfo adminInfo);

	int deleteAdmin(String id);

	int alterAdminInfo(AdminInfo adminInfo);

	AdminInfo getAdminInfo(String id);

	List<AdminInfo> getSearchAdmins(AdminInfo adminInfo);

	int changePwd(AdminChangePwdBo adminChangePwdBo);
}
