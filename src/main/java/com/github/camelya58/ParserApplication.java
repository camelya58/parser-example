package com.github.camelya58;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParserApplication {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://en.wikipedia.org/wiki/Java_virtual_machine").get();
        System.out.println(document.title());
        System.out.println(document.location());
        System.out.println(document.charset());
        System.out.println(document.outerHtml());
        Elements elements = document.select("#JVM_specification");

        for (Element element : elements){
            System.out.println(element.ownText());
        }
        Document doc = Jsoup.connect("https://www.gismeteo.ru/weather-moscow-4368/").get();

        Elements elements1 = doc.select("body > section > div.content_wrap > div > div.main > div > div.__frame_sm > div.forecast_frame.hw_wrap > div.tabs._center > a:nth-child(1) > div > div.tab-content > div.tab-weather > div.js_meas_container.temperature.tab-weather__value > span.unit.unit_temperature_c > span");

        for (Element element : elements1){
            System.out.println("Сейчас погода в Москве: " + element.ownText() + " С");
        }

    }
}
