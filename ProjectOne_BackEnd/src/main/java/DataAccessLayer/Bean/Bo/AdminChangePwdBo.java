package DataAccessLayer.Bean.Bo;

/**
 * @auther tian
 * @date 2020/8/7 4:43 下午
 * @JDK_version JDK1.8
 */
public class AdminChangePwdBo
{
	private String adminToken;

	private String oldPwd;

	private String newPwd;

	private String confirmPwd;

	public String getAdminToken()
	{
		return adminToken;
	}

	public void setAdminToken(String adminToken)
	{
		this.adminToken = adminToken;
	}

	public String getOldPwd()
	{
		return oldPwd;
	}

	public void setOldPwd(String oldPwd)
	{
		this.oldPwd = oldPwd;
	}

	public String getNewPwd()
	{
		return newPwd;
	}

	public void setNewPwd(String newPwd)
	{
		this.newPwd = newPwd;
	}

	public String getConfirmPwd()
	{
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd)
	{
		this.confirmPwd = confirmPwd;
	}

	@Override
	public String toString()
	{
		return "AdminChangePwdBo{" +
				"adminToken='" + adminToken + '\'' +
				", oldPwd='" + oldPwd + '\'' +
				", newPwd='" + newPwd + '\'' +
				", confirmPwd='" + confirmPwd + '\'' +
				'}';
	}
}
