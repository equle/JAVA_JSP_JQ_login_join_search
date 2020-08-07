package naver;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import dto.MovieInsertDTO;

public class NVmovieinsertCrawler {

	public static ArrayList<MovieInsertDTO> movieinsert() throws IOException{
		
		ArrayList<MovieInsertDTO> dtoList = new ArrayList<MovieInsertDTO>();
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

				//#content > div.article > div.mv_info_area > div.poster > a > img
				Document doc2 = Jsoup.connect(nextUrl).get();
				
				String img = doc2.select("div.mv_info_area div.poster a img").attr("src");
				
//				#content > div.article > div.wide_info_area > div.mv_info > div.info_spec2 > dl.step1 > dd > a
				String director = doc2.select("div.info_spec2 dl.step1 dd a").text();
				System.out.println(director);
//				#content > div.article > div.wide_info_area > div.mv_info > div.info_spec2 > dl.step2 > dd > a:nth-child(1)
				String actor = doc2.select("div.info_spec2 dl.step2 dd a:nth-child(1)").text();
				System.out.println(actor);
				
				
				
				MovieInsertDTO dto = new MovieInsertDTO();
				dto.setTitle(title);
				dto.setSrc(img);
				dto.setDt(director);
				dto.setAt(actor);
//			}
				dtoList.add(dto);
				}			
		
	return dtoList;
	}
}
