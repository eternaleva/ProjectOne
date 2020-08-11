package BusinessLogicLayer.ServiceInterface;

import DataAccessLayer.Bean.Bo.AdminBo;
import DataAccessLayer.Bean.Bo.AdminChangePwdBo;
import DataAccessLayer.Bean.Vo.AdminInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
