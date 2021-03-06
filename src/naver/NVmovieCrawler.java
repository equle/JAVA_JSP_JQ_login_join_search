package naver;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dto.MovieDTO;

public class NVmovieCrawler {

	public static ArrayList<MovieDTO> moviesearch() throws IOException{
		
		ArrayList<MovieDTO> dtoList = new ArrayList<MovieDTO>();
		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";

		// GET 요청을 보내고 Document 객체를 변수 doc에 저장하기
		Document doc = Jsoup.connect(url).get();

		// CSS 선택자를 사용해 링크 추출하기
		//#old_content > table > tbody > tr:nth-child(3) > td.title > div > a
			Elements menus = doc.select("div.tit3 a");
			
			// 반복문 적용하기
			for (Element menu : menus) {
				
				// 링크의 "title" 속성 값 추출하기
				String title = menu.attr("title").trim();
//				System.out.println(title);
				
				// 링크의 URL 추출하기 (절대경로)
				String nextUrl = menu.absUrl("href");
//				System.out.println(nextUrl);
				
//				Elements images = doc2.select("#content > div.article > div.mv_info_area > div.poster > a > img");
//				for(Element e : images) {
//					String src = e.getElementsByAttribute("src").attr("src");
//				URL imgUrl = new URL(src);
//	            BufferedImage jpg = ImageIO.read(imgUrl);

				//#content > div.article > div.mv_info_area > div.poster > a > img
				Document doc2 = Jsoup.connect(nextUrl).get();
				
				String img = doc2.select("div.mv_info_area div.poster a img").attr("src");

				
				
				
				MovieDTO dto = new MovieDTO();
				dto.setTitle(title);
				dto.setUrl(nextUrl);
				dto.setSrc(img);
//			}
				dtoList.add(dto);
				}
				
				// log
//			System.out.println(String.format("%s\n\t%s", title, nextUrl));
				
				// 링크 대상 페이지에 접근하기
//			Document nextDoc = Jsoup.connect(nextUrl).get();
				
				// 상세 내용 추출하기
//			String content = nextDoc.select("div.mw-parser-output").html();
				
				// "<title>.html"이라는 이름으로 저장하기
//			Files.write(Paths.get(title + ".html"), content.getBytes("UTF-8"));
			
		
	return dtoList;
	}
}
