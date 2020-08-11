package BusinessLogicLayer.Utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @auther tian
 * @date 2020/8/8 5:28 下午
 * @JDK_version JDK1.8
 */
public class FileUploadUtils
{
	/**
	 * 文件上传方法
	 * 该方法内分发处理逻辑：form表单处理/文件上传处理
	 * @param request(类型: HttpServletRequest)
	 * @return postParameter(类型: Map<String, Object>)
	 */
	public static Map<String, Object> fileUpload(HttpServletRequest request)
	{
		//创建一个文件工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();

		//获取Context域的临时空间
		ServletContext servletContext = request.getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");

		//将临时空间设置为仓库
		factory.setRepository(repository);

		//创建upload对象，传递值为factory
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");

		//创建Map对象
		Map<String, Object> postParameter = new HashMap<>();

		//使用upload的方法parseRequeset方法，将request的参数封装到FileItem的List集合中
		//FileItem是commons-fielupload的类
		try
		{
			List<FileItem> fileItemList = upload.parseRequest(request);
			//迭代处理fileItemList
			Iterator<FileItem> fileItem = fileItemList.iterator();
			while(fileItem.hasNext())
			{
				FileItem item = fileItem.next();
				if(item.isFormField())
				{
					//执行处理Form表单逻辑
					processFormField(item, postParameter);
				}
				else
				{
					//执行处理文件上传逻辑
					processFileUpload(item, postParameter, request);
				}
			}
		} catch (FileUploadException e)
		{
			e.printStackTrace();
		}
		return postParameter;
	}

	/**
	 * 文件上传逻辑
	 * @param item
	 * @param postParameter
	 * @param request
	 */
	private static void processFileUpload(FileItem item, Map<String, Object> postParameter, HttpServletRequest request)
	{
		//获取上传文件的form里设置的字段名
		String fieldName = item.getFieldName();
		//获取上传文件的文件名
		String uploadFileName = item.getName();
		//创建随机文件名，作为上传文件实际的存储名
		String fileName = UUID.randomUUID().toString() + "-" + uploadFileName;
		//创建hashCode
		int hashCode = fileName.hashCode();
		//把该值转换为十六进制的字符串格式
		String hashCode_hex = Integer.toHexString(hashCode);
		//再把十六进制的String转换为char数组
		char[] hashCode_array = hashCode_hex.toCharArray();
		//创建路径（该路径为相对路径）
		//1.先创建最上级目录名称
		String filePath = "files";
		//2.再根据hashCode_array补全整个目录
		for(char i: hashCode_array)
		{
			filePath += "/" + i;
		}
		filePath += fileName;
		//3.要生成对应文件，所以需要创建部署路径的realPath(在ServletContext里）
		String realFilePath = request.getServletContext().getRealPath(filePath);
		File file = new File(realFilePath);
		//如果文件的各个父级目录不存在，则创建各级别目录
		if(!file.getParentFile().exists())
		{
			file.getParentFile().mkdirs();
		}
		//输出文件，并将文件信息放入Map中
		//(file是文件对象，realFilePath是实际上传文件后的路径）
		try
		{
			item.write(file);
			//filePath是相对路径
			postParameter.put("uploadFile", filePath);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * From表单处理逻辑
	 * @param item
	 * @param postParameter
	 */
	private static void processFormField(FileItem item, Map<String, Object> postParameter)
	{
		//获取对应form表单字段（此时form表单的一个字段值封装在item里）
		String fieldName = item.getFieldName();
		String value = null;

		try
		{
			//把form表单的一个字段值以utf-8编码格式放到value里
			value = item.getString("utf-8");
			//把对应健值对添加到Map里
			postParameter.put(fieldName, value);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}
}
