import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class spider {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.ptt.cc/bbs/index.html").get();
            System.out.println(doc.title());
            Elements items = doc.getElementsByClass("b-ent");
            for (Element item1 : items) {
                String num = item1.getElementsByClass("board-name").get(0).text();
                String title = item1.getElementsByClass("board-title").get(0).text();
                Document doc1 = Jsoup.connect("https://www.ptt.cc/bbs/" + num + "/index.html").get();
                System.out.println("Board:" + num);
                System.out.println("Article title" + title);
                Elements newsHeadlines = doc1.select("#main-container > div.r-list-container.action-bar-margin.bbs-screen a");
                for (Element headline : newsHeadlines) {
                    Elements items1 = doc1.getElementsByClass("r-ent");
                    for (Element item2 : items1) {
                        Document doc2 = Jsoup.connect(headline.absUrl("href")).get();
                        Elements items2 = doc2.getElementsByClass("push");
                        for (Element item3 : items2) {
                            String num2 = item3.getElementsByClass("push").get(0).getElementsByTag("span").get(2).text();
                            String num3 = item3.getElementsByClass("push").get(0).getElementsByTag("span").get(1).text();
                            System.out.println("Comment:" + num2 + num3);
                            break;
                        }
                        break;
                    }
                    break;
                }
                System.out.println("\n");
            }

        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }
}
