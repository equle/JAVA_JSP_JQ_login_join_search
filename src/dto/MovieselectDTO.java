package dto;

public class MovieselectDTO {
	private String title, src, dt, at;
	private int num;


	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
//입력
	public String getDt() {
		return dt;
	}
	
	public void setDt(String dt) {
		this.dt = dt;
	}
	
	public String getAt() {
		return at;
	}
	
	public void setAt(String at) {
		this.at = at;
	}
}
