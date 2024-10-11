package dto;

public class WordDTO {
	

	private String english = null;
	private String korean = null;
	
	
	
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
		return "WordDAO [english=" + english + ", korean=" + korean + "]";
	}
}