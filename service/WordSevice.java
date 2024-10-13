package service;

import java.util.ArrayList;
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
	private void WordAdd() { // 등록
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
	private void WordMod() { // 수정
		WordDTO worddto = new WordDTO();
		Scanner in = new Scanner(System.in);
		System.out.println("수정할 번호 입력");
		int num = in.nextInt();
		in.nextLine();
		worddto.setNum(num);
		System.out.println("수정할 한국어");
		String k = in.nextLine();
		worddto.setKorean(k);
		System.out.println("수정할 영문");
		String e = in.nextLine();
		worddto.setEnglish(e);
		worddao.update(worddto);
//		System.out.println("수정완료");
	}
	
	private void WordAll() {
		ArrayList<WordDTO> wordlist = worddao.selectAll();
//		for(WordDTO : k wordlist) {
//			System.out.println(t);
		}
		
//	}
	private void WordDel() { // 삭제
		Scanner in = new Scanner(System.in);
		System.out.println("삭제할 번호 입력");
		int delNu = in.nextInt();
		in.nextLine();
		worddao.delete(delNu);
		
//		System.out.println("삭제 완료");
	}
	private void wordlist() {
		ArrayList<WordDTO> wordlist = worddao.selectAll();
		for(WordDTO K : wordlist) {
			System.out.println(K.toString());
		}
	}
	
}	
