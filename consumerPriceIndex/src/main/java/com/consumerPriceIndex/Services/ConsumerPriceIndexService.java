package com.consumerPriceIndex.Services;

import com.consumerPriceIndex.Models.*;
import com.consumerPriceIndex.Repositories.ConsumerPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsumerPriceIndexService {

    @Autowired
    private ConsumerPriceRepository ConsumerPriceRepository;
    private Environment env;

    public int main() {

        List<StagingArea> FinalTabStage = new ArrayList<>();

        List<Datum> ReturnList =  getConsumerPriceIndex();

        FinalTabStage = SetStaginArea(ReturnList);

        if (this.SaveData(FinalTabStage))
        {
            return 0;
        }
        else
        {
            return 1;
        }


    }

    public List<StagingArea> getConsumerPriceIndxData() {
        return ConsumerPriceRepository.findAll();
    }


    private List<StagingArea> SetStaginArea(List<Datum> returnList){

        List<StagingArea> TabStage = new ArrayList<>();

        StringBuilder a = new StringBuilder();

        for (Datum item : returnList)
        {

            StagingArea stg = new StagingArea();
            a.append("01");
            a.append("-");
            a.append(GetAbbreviatedFromFullName(item.getPeriodName()));
            a.append("-");
            a.append(item.getYear());

            //stg.setFecha(a.toString().trim());
            stg.setFecha("2019");
            stg.setGranularidad("Diario") ;
            stg.setTipo("Divisa");
            stg.setDetalle("CPI");
            stg.setUnidad("CPI");
            stg.setValor(item.getValue());
            stg.setUrl("https://api.bls.gov/publicAPI/v2/timeseries/data/");


            TabStage.add(stg);
        }

        return TabStage;


    }

    private String GetAbbreviatedFromFullName(String fullname){


      //  DateFormat fmt = new SimpleDateFormat("MMMM dd, yyyy", Locale.US)
        // Date d = fmt.parse("June 27,  2007");

        return "-";
    }

    private List<Datum> getConsumerPriceIndex() {

        List<Series> myList = new ArrayList<>();
        List<Datum> myDatumList = new ArrayList<>();

        try {


        StringBuilder payload = new StringBuilder();

        payload.append("{\"seriesid\":[\"CUUR0000SA0\"],\n");
        payload.append("\"startyear\":\"2011\",\n");
        payload.append("\"endyear\":\"2014\"}\n");

        HttpClient httpClient = HttpClientBuilder.create().build();
        //HttpPost request = new HttpPost(env.getProperty("api.timeseries.url").trim());
        HttpPost request = new HttpPost("https://api.bls.gov/publicAPI/v2/timeseries/data/");
        request.addHeader(HttpHeaders.AUTHORIZATION, "Basic");
        StringEntity entity = new StringEntity(payload.toString(), ContentType.APPLICATION_JSON);

        request.setEntity(entity);

        HttpResponse response = httpClient.execute(request);

        InputStream var = response.getEntity().getContent();

        String responseJSON = EntityUtils.toString(response.getEntity());
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        Rootobject pojo = mapper.readValue(responseJSON, Rootobject.class);

        myList = pojo.getResults().getSeries();

            for (Series item: myList) {

                myDatumList = item.getData();

            }


        } catch (Exception e) {

            System.out.println("error" + e.getMessage());

        }

        return myDatumList;

    }

    private boolean SaveData(List<StagingArea> FinalStaging) {

        boolean IsCorrect = false;

        try {


            ConsumerPriceRepository.saveAll(FinalStaging);

            IsCorrect = true;

        } catch (Exception ex) {


        }

        return IsCorrect;
    }


    public long getRecordsCount(){

        return ConsumerPriceRepository.count();
    }

}
