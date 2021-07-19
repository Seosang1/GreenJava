package kr.co.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {
	
	
	private int listSize = 10;              
	
	private int rangeSize = 10;            

	private int page;

	private int range;

	private int listCnt;

	private int pageCnt;

	private int startPage;

	private int startList;

	private int endPage;

	private boolean prev;

	private boolean next;

	public void pageInfo(int page, int range, int listCnt) {

		this.page = page;

		this.range = range;

		this.listCnt = listCnt;

		// ��ü ��������
		this.pageCnt = (int)Math.ceil(listCnt/(double)listSize);

		// ���� ������
		this.startPage = (range - 1) * rangeSize + 1;

		// �� ������
		this.endPage = range * rangeSize;

		// �Խ��� ���۹�ȣ
		this.startList = (page - 1) * listSize;

		// ���� ��ư ����
		this.prev = range == 1 ? false : true;

		// ���� ��ư ����
		this.next = endPage > pageCnt ? false : true;

		if (this.endPage > this.pageCnt) {

			this.endPage = this.pageCnt;

			this.next = false;

		}

	}

}