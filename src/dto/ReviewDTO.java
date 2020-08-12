package dto;

public class ReviewDTO {

	private int u_num, m_num;
	private String r_title, r_text ;
	private float r_score;

	public float getR_score() {
		return r_score;
	}
	public void setR_score(float r_score) {
		this.r_score = r_score;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getR_title() {
		return r_title;
	}
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}
	public String getR_text() {
		return r_text;
	}
	public void setR_text(String r_text) {
		this.r_text = r_text;
	}
	public int getU_num() {
		return u_num;
	}
	public void setU_num(int u_num) {
		this.u_num = u_num;
	}
	
	
}
