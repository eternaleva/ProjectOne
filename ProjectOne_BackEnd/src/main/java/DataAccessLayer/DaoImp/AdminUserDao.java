package DataAccessLayer.DaoImp;

import DataAccessLayer.Bean.Vo.AdminInfo;
import DataAccessLayer.DaoInterface.AdminDao;
import DataAccessLayer.Bean.Bo.AdminBo;
import org.apache.commons.dbutils.QueryRunner;
import BusinessLogicLayer.Utils.DruidUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.lang3.StringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @loginCode：-1，登陆失败；0，登陆成功
 * @auther tian
 * @date 2020/8/6 5:33 下午
 * @JDK_version JDK1.8
 */
public class AdminUserDao implements AdminDao
{
	QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());

	@Override
	public int login(AdminBo adminBo)
	{
		Long loginCode = null;
		try
		{
			//count(id)，就使用ScalarHandler来获取，数值类型是Long
			loginCode = (Long) runner.query("select count(id) from admin_users where email = ? and pwd = ?", new ScalarHandler(),
					adminBo.getEmail(),
					adminBo.getPwd());
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		return loginCode == 0 ? -1 : 0;
	}

	@Override
	public List<AdminInfo> getAllAdmins()
	{
		List<AdminInfo> allAdmins = new ArrayList<>();
		try
		{
			allAdmins = runner.query("select * from admin_users", new BeanListHandler<>(AdminInfo.class));
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		return allAdmins;
	}

	@Override
	public int addAdmin(AdminInfo adminInfo)
	{

		try
		{
			runner.update("insert into admin_users (email, nickname, pwd) values (?, ?, ?)",
					adminInfo.getEmail(),
					adminInfo.getNickname(),
					adminInfo.getPwd());
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public int deleteAdmin(String id)
	{

		try
		{
			runner.update("delete from admin_users where id = ?",
					id);
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public int alterAdminInfo(AdminInfo adminInfo)
	{
		try
		{
			runner.update("update admin_users set email = ?, nickname = ?, pwd = ? where id = ?",
					adminInfo.getEmail(),
					adminInfo.getNickname(),
					adminInfo.getPwd(),
					adminInfo.getId());
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
			return -1;
		}
		return 0;
	}

	@Override
	public AdminInfo getAdminInfo(String id)
	{
		AdminInfo adminInfo = new AdminInfo();
		try
		{
			adminInfo = runner.query("select * from admin_users where id = ?",
					new BeanHandler<AdminInfo>(AdminInfo.class),
					id);
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		return adminInfo;
	}

	@Override
	public List<AdminInfo> getSearchAdmins(AdminInfo adminInfo)
	{
		List<AdminInfo> adminUsers = new ArrayList<>();
		try
		{
			//sql拼接
			//只输入email
			//只输入nickName
			//两个都输入
			String baseSql = "select * from admin_users where 1 = 1 ";
			//list用来存放参数
			List<Object> list = new ArrayList<>();
			if(!StringUtils.isEmpty(adminInfo.getEmail()))
			{
				baseSql += "and email like ?";
				//% % sql语句，模糊搜索，要用like
				list.add("%"+ adminInfo.getEmail() + "%");
			}
			if(!StringUtils.isEmpty(adminInfo.getNickname()))
			{
				baseSql += "and nickname like ?";
				list.add("%"+ adminInfo.getNickname() + "%");
			}
			adminUsers = runner.query(baseSql,
					new BeanListHandler<AdminInfo>(AdminInfo.class),
					list.toArray());
		} catch (SQLException throwables)
		{
			throwables.printStackTrace();
		}
		return adminUsers;
	}
}
