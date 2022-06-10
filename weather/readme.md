Пример парсинга страницы с библиотекой Jsoup.

Класс без импортов: 
public class Weather {

    public static void main(String[] args) throws Exception{
        //вытащили всю страницу с html
        Document page = getPage();    
        
        //получаем конкретные данные по названию дивов и классов
        Element tableWeather = page.selectFirst("table[class=wt]"); 
        Elements names = tableWeather.select("tr[class=wth]");
        Elements values = tableWeather.select("tr[valign=top]");
        int index = 0;
        for(Element name: names){
            String dateString = name.select("th[id=dt]").text();
            String date = getDateFromString(dateString);
            System.out.println(date);
        } 
        //логика в отдельном методе
        printFourValues(values, index);
        
    }
    //парсер страницы
    private static Document getPage() throws IOException {
        String url = "http://www.pogoda.spb.ru/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }
    
    //шаблон для даты
    private static Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}");
    //вытаскиваем по патерну из строки дату
    private static String getDateFromString(String stringDate) throws Exception{
        Matcher matcher = pattern.matcher(stringDate);
        if(matcher.find()){
            return matcher.group();
        }
        throw new Exception("Can't extract date from string!");
    }
    
    //по индексу 0 будет печатать только первый элемент - информацию "утро"(если не ушло с сайта) 
    private static void printFourValues(Elements values,int index){
        for(int i =0; i<4; i++){
            Element valuesLine = values.get(index);
            for(Element td: valuesLine.select("td")){
                System.out.print(td.text()+"    ");
            }
            
        }
    }
}
