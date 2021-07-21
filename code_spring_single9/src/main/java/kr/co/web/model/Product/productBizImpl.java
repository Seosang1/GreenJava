package kr.co.web.model.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productBizImpl implements productBiz{

	@Autowired
	private productDao dao;
	
	@Override
	public List<productDto> selectList(){
		return dao.selectList();
		
		
	}

	@Override
	public productDto productDetail(int seq) {
		return dao.productDetail(seq);
	}

	@Override
	public void insertForm(productDto dto) throws Exception {
		dao.insertForm(dto);		
	}

	
	
}
