package ino.web.freeBoard.dto;

public class PageDto {
	private int startPage,endPage,total;
	private boolean prev,next;
	private PaginationDto pdto;
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	public PageDto(PaginationDto pdto,int total){
		
		this.pdto = pdto;
		this.total = total;
		System.out.println("------->"+pdto.getPageNum());
//		this.endPage = (int) (Math.ceil(pdto.getPageNum() / 10.0)) * 5;
		this.endPage = total / 5 ;
		this.startPage = this.endPage - 4;
		
		System.out.println("--end---->"+endPage);
		int realEnd = (int) (Math.ceil((total*1.0) / pdto.getAmount()));
		
//		if(realEnd < this.endPage){
//			this.endPage = realEnd;
//		}
		
		if(pdto.getPageNum() > this.endPage) {
			this.startPage = pdto.getPageNum();
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
		System.out.println(endPage+"/"+realEnd+"/"+prev+"/"+next);
	}
	public PaginationDto getPdto() {
		return pdto;
	}
	public void setPdto(PaginationDto pdto) {
		this.pdto = pdto;
	}
}
