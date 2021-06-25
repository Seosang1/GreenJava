package vo;

public class PageInfo {
// 게시판 페이징에 필요한 값들을 저장할 클래스
	private int cpage, pcnt, spage, epage, rcnt, psize, bsize;
	// 현재 페이지번호, 페이지수, 시작페이지, 종료페이지, 게시글수, 페이지크기, 블록크기
	private String schtype, keyword, bn_idx, bn_ismem, bn_pwd, ai_idx, bn_title,
		bn_content, bn_reply, bn_read, bn_date;
	
	public String getBn_idx() {
		return bn_idx;
	}
	public void setBn_idx(String bn_idx) {
		this.bn_idx = bn_idx;
	}
	public String getBn_ismem() {
		return bn_ismem;
	}
	public void setBn_ismem(String bn_ismem) {
		this.bn_ismem = bn_ismem;
	}
	public String getBn_pwd() {
		return bn_pwd;
	}
	public void setBn_pwd(String bn_pwd) {
		this.bn_pwd = bn_pwd;
	}
	public String getAi_idx() {
		return ai_idx;
	}
	public void setAi_idx(String ai_idx) {
		this.ai_idx = ai_idx;
	}
	public String getBn_title() {
		return bn_title;
	}
	public void setBn_title(String bn_title) {
		this.bn_title = bn_title;
	}
	public String getBn_content() {
		return bn_content;
	}
	public void setBn_content(String bn_content) {
		this.bn_content = bn_content;
	}
	public String getBn_reply() {
		return bn_reply;
	}
	public void setBn_reply(String bn_reply) {
		this.bn_reply = bn_reply;
	}
	public String getBn_read() {
		return bn_read;
	}
	public void setBn_read(String bn_read) {
		this.bn_read = bn_read;
	}
	public String getBn_date() {
		return bn_date;
	}
	public void setBn_date(String bn_date) {
		this.bn_date = bn_date;
	}
	public int getCpage() {
		return cpage;
	}
	public void setCpage(int cpage) {
		this.cpage = cpage;
	}
	public int getPcnt() {
		return pcnt;
	}
	public void setPcnt(int pcnt) {
		this.pcnt = pcnt;
	}
	public int getSpage() {
		return spage;
	}
	public void setSpage(int spage) {
		this.spage = spage;
	}
	public int getEpage() {
		return epage;
	}
	public void setEpage(int epage) {
		this.epage = epage;
	}
	public int getRcnt() {
		return rcnt;
	}
	public void setRcnt(int rcnt) {
		this.rcnt = rcnt;
	}
	public int getPsize() {
		return psize;
	}
	public void setPsize(int psize) {
		this.psize = psize;
	}
	public int getBsize() {
		return bsize;
	}
	public void setBsize(int bsize) {
		this.bsize = bsize;
	}
	public String getSchtype() {
		return schtype;
	}
	public void setSchtype(String schtype) {
		this.schtype = schtype;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
