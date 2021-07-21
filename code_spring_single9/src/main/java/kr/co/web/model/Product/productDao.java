package kr.co.web.model.Product;

import java.util.List;

public interface productDao {
	
	String NAMESPACE = "product.";

	public List<productDto> selectList();

	public productDto productDetail(int seq);

	public void insertForm(productDto dto) throws Exception;

	

}
