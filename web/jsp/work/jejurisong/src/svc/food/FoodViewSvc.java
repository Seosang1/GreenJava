package svc.food;

import static db.JdbcUtil.*;
import java.util.*;
import java.sql.*;
import dao.food.*;
import vo.*;

public class FoodViewSvc {
	public FoodInfo getFoodInfo(String id) {
		FoodInfo foodInfo = null;
		Connection conn = getConnection();
		FoodDao foodDao = FoodDao.getInstance();
		foodDao.setConnection(conn);
		foodInfo = foodDao.getFoodInfo(id);
		close(conn);

		return foodInfo;
	}
}
