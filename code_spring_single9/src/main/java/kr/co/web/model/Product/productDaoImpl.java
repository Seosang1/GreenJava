package kr.co.web.model.Product;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class productDaoImpl implements productDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<productDto> selectList() {

		List<productDto> list = new ArrayList<productDto>();
		
		try {
			
		list = sqlSession.selectList(NAMESPACE+"selectList");
		}catch (Exception e) {
			System.out.println("[error: select list" );
			e.printStackTrace();
		}
		
		
		return list;
		
}
}