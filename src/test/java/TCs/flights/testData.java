package TCs.flights;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class testData {

    // *****************************   <!-- Flights Header Common -->   **************************
    String Accept = "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7";
    String AcceptEncoding = "gzip, deflate, br";
    String AcceptLanguage = "en-US,en;q=0.9";
    // *****************************   <!-- ___________________ -->   *****************************


    // *******************   <!-- Date & Source/Destination AutoGenerate -->   ********************
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDate = currentDate.format(formatter);
    LocalDate nextDay = currentDate.plusDays(1);
    String formattedNextDay = nextDay.format(formatter);
    String GoDate = formattedDate;
    String BackDate = formattedNextDay;
    String Origin = "RUH";
    String Destination = "JED";
    // *******************   <!-- ______________________________________ -->   ********************


    // *******************************   <!-- Common Data  -->   **************************

    String BaseUrl = "https://global.almosafer.com";

    int SuccessResponseCode = 200;
    int NotFoundResponseCode = 404;

    int temporarilyMovedResponseCode = 302;

    String notFindMessage = "We could not find flight results for your search criteria";
    String notFoundMessage = "Lost in the wilderness?";
    // *******************************   <!-- ________________ -->   *****************************



    public String generateBody(String key)
    {
        String jsonBody = "";

        if(key.equals("missingTemplate"))
        {
            jsonBody =  "{\"template\":\"\",\"country\":\"general\",\"media\":\"mobile\",\"locale\":\"en_us\"}";
        }
        else if(key.equals("missingCountry"))
        {
            jsonBody =  "{\"template\":\"top-airports-v2.json\",\"country\":\"\",\"media\":\"mobile\",\"locale\":\"en_us\"}";
        }
        else if(key.equals("missingMedia"))
        {
            jsonBody =  "{\"template\":\"top-airports-v2.json\",\"country\":\"general\",\"media\":\"\",\"locale\":\"en_us\"}";
        }
        else if(key.equals("missingLocale"))
        {
            jsonBody =  "{\"template\":\"top-airports-v2.json\",\"country\":\"general\",\"media\":\"mobile\",\"locale\":\"\"}";
        }
        else if(key.equals("missingAll"))
        {
            jsonBody =  "{\"template\":\"\",\"country\":\"\",\"media\":\"\",\"locale\":\"\"}";
        }
        else if(key.equals("HappyBody"))
        {
            jsonBody =  "{\"template\":\"top-airports-v2.json\",\"country\":\"general\",\"media\":\"mobile\",\"locale\":\"en_us\"}";
        }

        return jsonBody;
    }


    public String generatePostEndpoint(String key)
    {
        String Endpoint = "";

        if(key.equals("HappyEndpoint"))
        {
            Endpoint =  BaseUrl+"/api/cms/page";
        }
        else if(key.equals("missingPage"))
        {
            Endpoint = BaseUrl+"/api/cms";
        }
        else if(key.equals("missingPageAndCms"))
        {
            Endpoint= BaseUrl+"/api";
        }
        else if(key.equals("missingApi"))
        {
            Endpoint = BaseUrl+"/cms/page";
        }
        else if(key.equals("missingCms"))
        {
            Endpoint = BaseUrl+"/api/page";
        }


        return Endpoint;
    }




    public String generateGetEndpoint(String key)
    {

        String Endpoint = "";

        if(key.equals("HappyEndpoint"))
        {
            Endpoint = BaseUrl+"/en/flights/" + Origin + "-" + Destination + "/" + GoDate + "/" + BackDate + "/Economy/1Adult";
        }
        else if(key.equals("missingDates"))
        {
            Endpoint = BaseUrl+"/en/flights/" + Origin + "-" + Destination + "/Economy/1Adult";
        }
        else if(key.equals("missingPassengers"))
        {
            Endpoint= BaseUrl+"/en/flights/" + Origin + "-" + Destination + "/" + GoDate + "/" + BackDate + "/Economy";
        }
        else if(key.equals("ExceedPassengersNo"))
        {
            Endpoint = BaseUrl+"/en/flights/" + Origin + "-" + Destination + "/" + GoDate + "/" + BackDate + "/Economy/10Adult";
        }
        else if(key.equals("missingCountries"))
        {
            Endpoint = BaseUrl+"/en/flights/" + GoDate + "/" + BackDate + "/Economy/1Adult";
        }

        else if(key.equals("withoutAnyFilters"))
        {
            Endpoint = BaseUrl+"/en/flights";
        }

        else if(key.equals("GoDateBiggerBackDate"))
        {
            Endpoint = BaseUrl+"/en/flights/" + Origin + "-" + Destination + "/" + BackDate + "/" + GoDate + "/Economy/1Adult";

        }

        else if(key.equals("UseInvalidDate"))
        {
            Endpoint = BaseUrl+"/en/flights/" + Origin + "-" + Destination + "/" + GoDate + "/" + "2024-02-30" + "/Economy/1Adult";

        }


        return Endpoint;
    }

}
