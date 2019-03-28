package com.consumerPriceIndex;

import com.consumerPriceIndex.Models.StagingArea;
import com.consumerPriceIndex.Services.ConsumerPriceIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerPriceIndexApplication implements CommandLineRunner {

    @Autowired
    private ConsumerPriceIndexService _consumerPriceIndexService;

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(ConsumerPriceIndexApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        int _return = _consumerPriceIndexService.main();


        System.out.println(String.format("La Ejecucion  : %s", _return > 0 ? "Termino" : "Fallo"));

        if (_return > 0) {

            Long _count = _consumerPriceIndexService.getRecordsCount();

            System.out.println(String.format("cant  : %s", _count > 0 ? _count.toString() : "Fallo"));

            for (StagingArea item : _consumerPriceIndexService.getConsumerPriceIndxData()) {

                System.out.println(String.format("Detalle  : %s", item.getDetalle()));

            }


        }

    }
}
