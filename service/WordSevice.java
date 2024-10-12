package service;

import java.util.Scanner;

import dao.WordDAO;
import dto.WordDTO;

public class WordSevice {
	private WordDAO worddao = WordDAO.getInstance();
	
	public WordSevice() {
		menu();
	}
	private void menu() {
		Scanner in = new Scanner(System.in);
		boolean flag = true;
		while(flag) {
			System.out.println("1.등록, 2.수정, 3.전체보기, 4.삭제, 5.종료" );
			int selNum = in.nextInt();
			in.nextLine();
			switch (selNum) {
			case 1: WordAdd(); break;
			case 2: WordMod(); break;
			case 3: WordAll(); break;
			case 4: WordDel(); break;
			case 5: break;
			}
		}
	}
	private void WordAdd() {
		WordDTO worddto = new WordDTO();
		Scanner in = new Scanner(System.in);
		System.out.println("한국어 입력");
		String korean = in.nextLine();
		System.out.println("영어 입력");
		String english = in.nextLine();
		worddto.setKorean(korean);
		worddto.setEnglish(english);
		worddao.insert(worddto);
		System.out.println("등록완료");
	
	}
	private void WordMod() {
		Scanner in = new Scanner(System.in);
		System.out.println("수정할 한국어 입력");
		String modkor = in.nextLine();
		
	}
	
	private void WordAll() {
		// TODO Auto-generated method stub
		
	}
	private void WordDel() {
		Scanner in = new Scanner(System.in);
		System.out.println("삭제할 한국어 입력");
		String delkor = in.nextLine();
		worddao.delete(delkor);
		System.out.println("삭제 완료");
	}
	private void wordlist() {
	ArrayList<WordDTO> wordlist = worddao.
	}
}	
