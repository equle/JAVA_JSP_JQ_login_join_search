package dto;

public class ReviewViewDTO {

	private int num;
	private String m_title, id, r_title, r_text  ;
	private float r_score;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public float getR_score() {
		return r_score;
	}
	public void setR_score(float r_score) {
		this.r_score = r_score;
	}

}
