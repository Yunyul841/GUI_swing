package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

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
		public void insert(WordDTO worddto) {
			if(conn()) {
				try {
				String sql ="insert into wordlove values(?,?)";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.setString(1, worddto.getKorean());
				psmt.setString(2, worddto.getEnglish());
				int resultInt = psmt.executeUpdate();
				if(resultInt > 0) {
					conn.commit();
				}else {
					conn.rollback();
				}
				
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if(conn != null) {
							conn.close();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		}
		public void delete(String delkor) {
			if(conn()) {
				try {
					String sql = "delete from wordlove where korean=?";
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setString(1, delkor);
					psmt.executeUpdate();
				} catch (Exception e) {
				}finally {
					try {
						if(conn != null) {
							conn.close();
						}
					} catch (Exception e2) {
					}
				}
			}
		}
		public void mod(WordDTO modkor) {
			if(conn()) {
				try {
					String sql = "update wordlove set korean=? where = english";
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setString(1, modkor.getKorean());
					psmt.setString(2, modkor.getEnglish());
					psmt.executeUpdate();
				} catch (Exception e) {
				} finally {
					try {
						if(conn != null) {
							conn.close();
						}
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			}
		}
		public ArrayList<WordDTO> selectAll(){
			ArrayList<WordDTO> wlist = new ArrayList<>();
//			if()
			return null;
			
		}
}

