package qa.guru.files;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FIleProxyTest {

    @Disabled
    @Test
    @DisplayName("Скачивание текстового файла и проверка его содержимого через прокси")
    void downloadSimpleTextFileTestWithProxy() throws IOException {

        Configuration.fileDownload = FileDownloadMode.PROXY;
        Configuration.proxyEnabled = true;

        open("https://transfiles.ru/j3rzx");

        File download = $("input[value='Скачать все']").scrollTo().download();
        String fileContent = IOUtils.toString(new FileReader(download));
        System.out.println(fileContent);
        assertTrue(fileContent.contains("The snow is falling"));
    }
}
