package ino.web.freeBoard.dto;



public class PaginationDto {
	private int pageNum, amount;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public PaginationDto(){
		this(1,5);
	}

	@Override
	public String toString() {
		return "PaginationDto [pageNum=" + pageNum + ", amount=" + amount +  "]";
	}
	
	public PaginationDto(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}

}
