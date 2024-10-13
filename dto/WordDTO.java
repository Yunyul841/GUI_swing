package dto;

public class WordDTO {
	
	private int num;
	private String english;
	private String korean;
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getKorean() {
		return korean;
	}
	public void setKorean(String korean) {
		this.korean = korean;
		
	}
	// 디버깅용
	@Override
	public String toString() {
		return "WordDTO [num=" + num + ", english=" + english + ", korean=" + korean + "]";
	}

}