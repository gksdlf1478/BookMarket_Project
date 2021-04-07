package test.project.ko.board;

public class BoardDTO {

	int bno;
	String boardname;
	String boardtext;
	String boardreguser;
	String boardregdate;
	String boardupdateuser;
	String boardupdatedate;
	String SearchData;
	int boardreadcnt;
	
	
	
	public String getSearchData() {
		return SearchData;
	}
	public void setSearchData(String searchData) {
		SearchData = searchData;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	public String getBoardtext() {
		return boardtext;
	}
	public void setBoardtext(String boardtext) {
		this.boardtext = boardtext;
	}
	public String getBoardreguser() {
		return boardreguser;
	}
	public void setBoardreguser(String boardreguser) {
		this.boardreguser = boardreguser;
	}
	public String getBoardregdate() {
		return boardregdate;
	}
	public void setBoardregdate(String boardregdate) {
		this.boardregdate = boardregdate;
	}
	public String getBoardupdateuser() {
		return boardupdateuser;
	}
	public void setBoardupdateuser(String boardupdateuser) {
		this.boardupdateuser = boardupdateuser;
	}
	public String getBoardupdatedate() {
		return boardupdatedate;
	}
	public void setBoardupdatedate(String boardupdatedate) {
		this.boardupdatedate = boardupdatedate;
	}
	public int getBoardreadcnt() {
		return boardreadcnt;
	}
	public void setBoardreadcnt(int boardreadcnt) {
		this.boardreadcnt = boardreadcnt;
	}
	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", boardname=" + boardname + ", boardtext=" + boardtext + ", boardreguser="
				+ boardreguser + ", boardregdate=" + boardregdate + ", boardupdateuser=" + boardupdateuser
				+ ", boardupdatedate=" + boardupdatedate + ", boardreadcnt=" + boardreadcnt + "]";
	}
	
	
	
}
