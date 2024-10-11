package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import dto.WordDTO;

public class WordDAO {
	private String username = "system";
	private String password = "11111111";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private Connection conn = null;
	
	public static WordDAO worddao = null;
		
		public  void WordDAO() {
			init();
		}
		public static WordDAO getInstance() {
			if(worddao == null) {
				worddao = new WordDAO(); // 자기 자신 객체 생성
			}
			return worddao;
		}
		private void init() { // 드라이버 로드, 최초 1회만
			try {
				Class.forName(driverName);
				System.out.println("오라클 드라이버 로드 성공");
				// 드라이버 로드가 제대로 됐다면(빌드가 제대로 됐다면), 오라클 드라이버 로드 성공 메세지 출력
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	
		private boolean conn() { // 커넥션 가져오는 공통 코드를 메서드로 정의
			try {
				conn = DriverManager.getConnection(url, username, password);
	//			System.out.println("커넥션 자원 획득 성공");
				return true; // 커넥션 자원을 정상적으로 획득할 시
			} catch (Exception e) {
			}
			return false; // 획득 실패시
		}
		public void insert(WordDTO worddTo) {
			if(conn()) {
				String sql ="insert into book values(book_seq.nextval,?,?,default)";
//				PreparedStatement psmt = conn.prepareStatement(sql);
//				psmt.setString(1, worddTo.getKorean());
//				psmt.setString(2, worddTo.getEnglish());
				
				
				
			}
			
		}
}

