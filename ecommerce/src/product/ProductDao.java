package product;

import java.util.List;

public interface ProductDao {

	public String insert(ProductDto pdto);
	public List<ProductDto> searchByKey(String searchKey);
	public ProductDto searchById(String searchId);

}
