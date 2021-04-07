package test.project.ko.board;

public class ReplyDTO {

	int reno;
	String rewriter;
	String rememo;
	
	public int getReno() {
		return reno;
	}
	public void setReno(int reno) {
		this.reno = reno;
	}
	public String getRewriter() {
		return rewriter;
	}
	public void setRewriter(String rewriter) {
		this.rewriter = rewriter;
	}
	public String getRememo() {
		return rememo;
	}
	public void setRememo(String rememo) {
		this.rememo = rememo;
	}
	@Override
	public String toString() {
		return "ReplyDTO [reno=" + reno + ", rewriter=" + rewriter + ", rememo=" + rememo + "]";
	}
	
	
	
	
}
