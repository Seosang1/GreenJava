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
	
}
