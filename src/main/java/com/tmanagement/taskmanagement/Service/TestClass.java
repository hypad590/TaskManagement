package com.tmanagement.taskmanagement.Service;

import org.jsoup.Jsoup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) throws IOException {
        String url = "https://github.com/hypad590?tab=repositories";
        File file = new File(System.getProperty("user.dir") + "/taskmanagement/src/main/resources/static/create.html");
        String body = "\t<ul>\n" + String.join("\n",Objects.
                requireNonNull(
                        Jsoup.connect(
                                url
                        ).get().selectFirst(
                                "ul[data-filterable-for=your-repos-filter][data-filterable-type=substring]"
                        )
                )
                .select("li").stream()
                .map(
                        element -> {
                            String name = Objects.requireNonNull(element.selectFirst("a")).text();
                            return "\t\t<li>" + String.format("<a href=%s%s>%s</a>", url + "/", name, name) + "</li>";
                        }
                ).toList()
        )+ "\n\t</ul>";

        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<title>Dynamic HTML</title>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"styles0.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                body + "\n" +
                "</body>\n" +
                "</html>";

        try(FileWriter writer = new FileWriter(file)){
            writer.write(html);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

