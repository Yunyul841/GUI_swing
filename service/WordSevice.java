package service;

import java.util.Scanner;

import dao.WordDAO;

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
			case 3: WordDel(); break;
			case 4: break;
			}
		}
	}
	private void WordAdd() {
		WordDAO worddao = new WordDAO();
//		worddao.insert();
		
	}
	private void WordMod() {
		
	}
	private void WordDel() {
		
	}
}
