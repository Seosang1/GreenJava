package kr.co.web.model.Product;

import java.util.List;

public interface productBiz {
	
	public List<productDto> selectList();

	public productDto productDetail(int seq);

	public void insertForm(productDto dto) throws Exception;

}
