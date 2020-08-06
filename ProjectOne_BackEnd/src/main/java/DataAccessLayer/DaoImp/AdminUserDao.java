package DataAccessLayer.DaoImp;

import DataAccessLayer.Bean.Vo.AdminInfo;
import DataAccessLayer.DaoInterface.AdminDao;
import DataAccessLayer.Bean.Bo.AdminBo;
import org.apache.commons.dbutils.QueryRunner;
import BusinessLogicLayer.Utils.DruidUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

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
	@Override
	public int login(AdminBo adminBo)
	{
		QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
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
		QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
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
		QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
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

}
