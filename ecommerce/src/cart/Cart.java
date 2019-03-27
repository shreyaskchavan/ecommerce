package cart;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import product.ProductBo;
import product.ProductDto;

public class Cart {
	
	
	public void addToCart(HttpServletRequest request)
	{
		String pid = request.getParameter("pid");
		ProductBo pbo = new ProductBo();
		pbo.setScontext(request.getServletContext());
		ProductDto pdto = pbo.searchById(pid);
		HttpSession hs = request.getSession(false);
		
		if(hs != null) {
			//logged in
			Object obj = hs.getAttribute("cart");
			if(obj == null) {
				//purchasing for the first time
				ArrayList<ProductDto> ar = new ArrayList<>();
				ar.add(pdto);
				hs.setAttribute("cart", ar);
			}
			else {
				//purchasing for the consequent time
				ArrayList<ProductDto> ar = (ArrayList<ProductDto>) obj;
				ar.add(pdto);
				hs.setAttribute("cart", ar);
			}
		}
		else {
			//not logged in
		}
	}
	
}
