package vo;

import static db.JdbcUtil.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;
import vo.*;

public class FoodInfo {
// 음식점 정보를 저장할 클래스 
	private int food_idx, food_like, food_review_cnt ;
	private String food_code, food_name, food_addr, food_zip, food_tel, food_type, food_area, 
    	food_open ,food_close, food_park_yn, food_open_yn, food_detail, food_isview, food_reg_date, food_isadd,
    	food_img1, food_img2, food_img3, food_desc;
    private double food_score;
	
	
    public String getFood_img1() {
		return food_img1;
	}
	public void setFood_img1(String food_img1) {
		this.food_img1 = food_img1;
	}
	public String getFood_img2() {
		return food_img2;
	}
	public void setFood_img2(String food_img2) {
		this.food_img2 = food_img2;
	}
	public String getFood_img3() {
		return food_img3;
	}
	public void setFood_img3(String food_img3) {
		this.food_img3 = food_img3;
	}
	public String getFood_desc() {
		return food_desc;
	}
	public void setFood_desc(String food_desc) {
		this.food_desc = food_desc;
	}
	public double getFood_score() {
		return food_score;
	}
	public void setFood_score(double food_score) {
		this.food_score = food_score;
	}
	public int getFood_idx() {
		return food_idx;
	}
	public void setFood_idx(int food_idx) {
		this.food_idx = food_idx;
	}
	public int getFood_like() {
		return food_like;
	}
	public void setFood_like(int food_like) {
		this.food_like = food_like;
	}
	public int getFood_review_cnt() {
		return food_review_cnt;
	}
	public void setFood_review_cnt(int food_review_cnt) {
		this.food_review_cnt = food_review_cnt;
	}
 
	public String getFood_code() {
		return food_code;
	}
	public void setFood_code(String food_code) {
		this.food_code = food_code;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	} 
	public String getFood_addr() {
		return food_addr;
	}
	public void setFood_addr(String food_addr) {
		this.food_addr = food_addr;
	}
	public String getFood_zip() {
		return food_zip;
	}
	public void setFood_zip(String food_zip) {
		this.food_zip = food_zip;
	}
	public String getFood_tel() {
		return food_tel;
	}
	public void setFood_tel(String food_tel) {
		this.food_tel = food_tel;
	}
	public String getFood_type() {
		return food_type;
	}
	public void setFood_type(String food_type) {
		this.food_type = food_type;
	}
	public String getFood_area() {
		return food_area;
	}
	public void setFood_area(String food_area) {
		this.food_area = food_area;
	}
	public String getFood_open() {
		return food_open;
	}
	public void setFood_open(String food_open) {
		this.food_open = food_open;
	}
	public String getFood_close() {
		return food_close;
	}
	public void setFood_close(String food_close) {
		this.food_close = food_close;
	}
	public String getFood_park_yn() {
		return food_park_yn;
	}
	public void setFood_park_yn(String _food_park_yn) {
		this.food_park_yn = _food_park_yn;
	}
	public String getFood_open_yn() {
		return food_open_yn;
	}
	public void setFood_open_yn(String food_open_yn) {
		this.food_open_yn = food_open_yn;
	}
	public String getFood_detail() {
		return food_detail;
	}
	public void setFood_detail(String food_detail) {
		this.food_detail = food_detail;
	}
	public String getFood_isview() {
		return food_isview;
	}
	public void setFood_isview(String food_isview) {
		this.food_isview = food_isview;
	}
	public String getFood_reg_date() {
		return food_reg_date;
	}
	public void setFood_reg_date(String food_reg_date) {
		this.food_reg_date = food_reg_date;
	}
	public String getFood_isadd() {
		return food_isadd;
	}
	public void setFood_isadd(String food_isadd) {
		this.food_isadd = food_isadd;
	}

}
