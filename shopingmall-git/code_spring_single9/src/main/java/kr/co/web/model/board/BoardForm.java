package kr.co.web.model.board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public  class BoardForm {
	private Integer seq;
	private String category;
	private String u_id;
	private String title;
	private String contents;
	private Integer view_count;
	private String photo;
	private String create_date;
	private String response_yn;
	
}
