package DataAccessLayer.DaoInterface;

import DataAccessLayer.Bean.Bo.AdminBo;
import DataAccessLayer.Bean.Vo.AdminInfo;

import java.util.List;

/**
 * @auther tian
 * @date 2020/8/6 5:25 下午
 * @JDK_version JDK1.8
 */
public interface AdminDao
{
	int login(AdminBo adminBo);

	List<AdminInfo> getAllAdmins();

	int addAdmin(AdminInfo adminInfo);

	int deleteAdmin(String id);

	int alterAdminInfo(AdminInfo adminInfo);

	AdminInfo getAdminInfo(String id);
}
