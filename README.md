# OnlineMall [![](https://img.shields.io/badge/OnlineMall-1.0.0-red?style=plastic&logo=appveyor)](https://github.com/eternaleva/ProjectOne)
<br>
简易电商项目

## 设计架构:
按照三层模型

### UserInterfaceLayer（用户接口层）
Controller：控制器，处理用户操作逻辑，分发操作到对应业务
<br>
View：视图，将对应操作转换为对应的信息显示给用户
<br>
Filter：过滤器

### BusinessLogicLayer（业务逻辑层）
ServiceInterface：服务接口
ServiceInterfaceImp：服务接口实现类

### DataAccessLayer（数据接入层）
Bean：封装数据使用，内部包含Bo业务对象、Vo值对象和封装类
DaoInterface：数据接入对象接口
DaoImp：数据接入对象接口的实现类

### 后台管理系统

*login*
-----

接口说明：登陆后台管理系统

请求方式：Post

请求URI：/api/admin/admin/login

请求参数：Json
|参数名|参数类型|是否必须|说明|
|----|----|----|----|
|name|String|是|用户名|
|pwd|String|是|密码|

返回参数：Json
|参数名|参数类型|是否必须|说明|值|
|----|----|----|----|----|
|code|int|是|返回状态码|0:成功 10000:失败|
|data|Object|是|返回的数据对象|-|
|message|String|否|返回的消息说明|-|

*allAdmins*
-----

接口说明：显示所有管理员账户

请求方式：Get

请求URI：/api/admin/admin/allAdmins

请求参数：无

返回参数：Json
|参数名|参数类型|是否必须|说明|值|
|----|----|----|----|----|
|code|int|是|返回状态码|0:成功 10000:失败|
|data|Object|是|返回的数据对象|-|
|message|String|否|返回的消息说明|-|

data对象
|参数名|参数类型|是否必须|说明|
|----|----|----|----|
|id|int|是|用户ID|
|email|String|是|账户名|
|nickname|String|是|昵称|
|pwd|String|是|密码|

*addAdminss*
----

接口说明：增加管理员

请求方式：Post

请求URI：/api/admin/admin/addAdminss

请求参数：Json
|参数名|参数类型|是否必须|说明|
|----|----|----|----|
|email|String|是|账户名|
|nickname|String|是|昵称|
|pwd|String|是|密码|

返回参数：无

