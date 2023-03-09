package com.kej.project.board;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board board = new Board();
		board.setScanner(sc);
		board.run();
		sc.close();

	}
}

class Board {
	Scanner sc;

	int userId = 0; // 게시물 갯수 증가
	List<Article> articles = new ArrayList<>();

	void run() {
		System.out.println("============게시판=============");
		System.out.println("=============================");
		System.out.println("[번호]  [제목]  [작성자]  [ 작성일  ]");
		System.out.println("-----------------------------");
		System.out.println("1.목록  2.등록  3.내용  4.삭제  0.종료");

		while (true) {

			System.out.printf("번호를 입력해주세요. > ");

			String cmd = sc.nextLine().trim();

			if (cmd.equals("0")) {
				System.out.println("==========프로그램 종료===========\n");
				break;
			} else if (cmd.equals("1")) {
				System.out.println("==========게시물 목록============");
				System.out.println("-----------------------------");
				System.out.println("No. / 제목  / 작성자  / 날짜 ");
				System.out.println("-----------------------------");

				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d / %s / %s / %s \n", article.getId(), article.getTitle(),
							article.getUserName(), article.getDate());
				}
			} else if (cmd.equals("3")) { // 내용확인
				System.out.print("내용을 확인할 게시글 번호를 입력해주세요. \n명령 > ");
				String num = sc.nextLine();

				if (articles.isEmpty()) {
					System.out.println("게시물이 존재하지 않습니다.");
					continue;
				}
				boolean b = false;
				for (Article article : articles) {
					try {
						if (article.getId() == Integer.parseInt(num)) {
							b = true;
							System.out.println("=========게시물 상세보기===========");
							System.out.printf("No.: %s\n", article.getId());
							System.out.printf("제목 : %s\n", article.getTitle());
							System.out.printf("내용 : %s\n", article.getBody());
							System.out.printf("작성자 : %s\n", article.getUserName());
							System.out.printf("작성일 : %s\n", article.getDate());
							break;
						}
					} catch (Exception e) {
						System.out.println("잘못된 입력값입니다.");
					}
				}
				if (!b) {
					System.out.println("게시물이 없습니다.");
				}

			} else if (cmd.equals("2")) { // 입력

				CmdAdd();

			} else if (cmd.equals("4")) {
				// 삭제
				System.out.println("삭제할  글 번호");
				String s = sc.nextLine();
				for (Article a : articles) {
					try {
						if (a.getId() == Integer.parseInt(s)) {
							articles.remove(a);
							System.out.println(a.getId() + " 번 글 " + a.getTitle() + " 이 정상적으로 삭제되었습니다.");
							break;
						}
					} catch (Exception e) {
						System.out.println("잘못된 입력값");
					}
				}
			} else {
				System.out.printf("입력된 명령어 : %s\n", cmd);
			}
		}
	}

	private void CmdAdd() {

		System.out.println("==========게시물 등록============");
		System.out.printf("제목 : ");
		String title = sc.nextLine();
		System.out.printf("내용 : ");
		String body = sc.nextLine();
		System.out.printf("작성자 : ");
		String userName = sc.nextLine();
	
		SimpleDateFormat dt = new SimpleDateFormat("yy/MM/dd [HH:mm:ss]");
		String date = dt.format(new Date());

		int id = userId + 1;
		userId = id;

		Article article = new Article(id, title, body, date, userName); // 데이터 저장 객체 생성

		articles.add(article); // 생성된 게시물 목록 추가

		System.out.println("생성된 게시물 : " + article);

		System.out.printf("%d번 게시물이 등록 되었습니다.\n", article.getId());
	}

	void setScanner(Scanner sc) {
		this.sc = sc;

	}
}
