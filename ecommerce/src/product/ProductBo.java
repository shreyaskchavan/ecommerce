package product;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import db.DatabaseManager;
import member.MemberDao;
import member.MemberDaoImpl;
import member.MemberDto;
import member.MemberForm;

public class ProductBo {

	ServletContext scontext;

	public ServletContext getScontext() {
		return scontext;
	}

	public void setScontext(ServletContext scontext) {
		this.scontext = scontext;
	}

	
	public String insert(HttpServletRequest req) {
		ProductForm pform = uploadImageReturnForm(req);
		ProductDto pdto = formToDto(pform);

		Connection con = getConnection();
		ProductDao pdao = new ProductDaoImpl(con);
		String result = pdao.insert(pdto);

		return result;
	}
	// this function will parse the request object to get all the text boxes data
	// and create a ProductForm
	// type of object as well as upload the files

	public ProductForm uploadImageReturnForm(HttpServletRequest req) {
		ProductForm pform = new ProductForm();

		// We got this from apache file upload webpage
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		try {
			List<FileItem> items = upload.parseRequest(req);

			for (FileItem fitem : items) {
				if (fitem.isFormField()) {
					// it is a text input
					String fieldName = fitem.getFieldName();
					String fieldValue = fitem.getString();

					if (fieldName.equals("catid")) {
						pform.setCatid(fieldValue);
					}
					if (fieldName.equals("subcatid")) {
						pform.setSubcatid(fieldValue);
					}
					if (fieldName.equals("title")) {
						pform.setTitle(fieldValue);
					}
					if (fieldName.equals("description")) {
						pform.setDescription(fieldValue);
					}
					if (fieldName.equals("price")) {
						pform.setPrice(fieldValue);
					}

				} else {
					// it is a file
					String fieldName = fitem.getFieldName();
					String imageName = fitem.getName();

					imageName = imageName.substring(imageName.lastIndexOf('\\') + 1, imageName.length());

					System.out.println("Image name = " + imageName);
					if (fieldName.equals("picture1")) {
						pform.setPicture1(imageName);
					}
					if (fieldName.equals("picture2")) {
						pform.setPicture2(imageName);
					}

					String imageLocation = (String) scontext.getAttribute("imageLocation");
					File file = new File(imageLocation + imageName);
					try {
						fitem.write(file);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//the above method will upload to the desired location

					// upload image to tomcat. don't upload image to database; this will reduce
					// performance
					// in database store picture name only.
				}

			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pform;
	}

	public ProductDto formToDto(ProductForm pform) {
		java.util.Date d1 = new java.util.Date();
		java.sql.Date dou = new Date(d1.getTime());

		ProductDto pdto = new ProductDto(1, pform.getCatid(), pform.getSubcatid(), "Shreyas", pform.getTitle(),
				pform.getDescription(), pform.getPicture1(), pform.getPicture2(), "successful",
				Double.parseDouble(pform.getPrice()), dou);
		return pdto;
	}

	public Connection getConnection() {
		String dburl = (String) scontext.getAttribute("dburl");
		String dbuname = (String) scontext.getAttribute("dbuname");
		String dbpass = (String) scontext.getAttribute("dbpassword");

		Connection con = DatabaseManager.getConnection(dburl, dbuname, dbpass);
		return con;

	}
	public List<ProductDto> searchByKey(String searchKey) {
		
		Connection con = getConnection();
		ProductDao pdao = new ProductDaoImpl(con);
		List<ProductDto> list = pdao.searchByKey(searchKey);
		
		return list;
	}
	
public ProductDto searchById(String searchId) {
		
		Connection con = getConnection();
		ProductDao pdao = new ProductDaoImpl(con);
		ProductDto pdto = pdao.searchById(searchId);
		
		return pdto;
	}
}
