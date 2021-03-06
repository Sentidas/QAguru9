package qa.guru.files;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.partialLinkText;

public class FileTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Disabled
    @Test
    @DisplayName("Загрузка файла")
    void filenameShouldDisplayedAfterUploadActionFromClasspathTest() {
        open("https://transfiles.ru");
        $("input[type='file']").uploadFromClasspath("1.txt");
        $("#up_files").shouldHave(text("1.txt"));
        String href = $("#up_link a").scrollTo().getAttribute("href");
        System.out.println(href);
    }

    @Disabled
    @Test
    @DisplayName("Скачивание текстового файла и проверка его содержимого")
    void downloadSimpleTextFileTest() throws IOException {

        open("https://www.gutenberg.org/");
        $(partialLinkText("In and About Drury Lane and Other Papers Vol. I by Dr. John Doran")).click();
        $(partialLinkText("More Files")).click();
        File download = $(partialLinkText("66788-0.txt")).download();

        String fileContent = IOUtils.toString(new FileReader(download));
        // System.out.println(fileContent);
        assertTrue(fileContent.contains("This eBook is for the use of anyone anywhere"));
    }

    @Disabled
    @Test
    @Owner("BaharevaElena")
    @Feature("Download")
    @DisplayName("Скачивание PDF файла")
    void pdfFileDownloadTest() throws IOException {
        open("https://www.raiffeisen.ru/about/investors/annualreport/?active_tab=tab-1");
        File pdf = $(byText("Годовой Отчет АО «Райффайзенбанк» за 2020 год")).closest("a").download();
        PDF parsedPdf = new PDF(pdf);
        Assertions.assertEquals(63, parsedPdf.numberOfPages);
        Assertions.assertEquals("пользователь Microsoft Office", parsedPdf.author);
        Assertions.assertEquals("Презентация PowerPoint", parsedPdf.title);
    }

    @Disabled
    @Test
    @Owner("BaharevaElena")
    @Feature("Download")
    @DisplayName("Скачивание XLS файла")
    @Severity(SeverityLevel.CRITICAL)
    void xlsFileDownloadTest() throws IOException {
        open("https://optom-knigi.ru/index.php/katalog-i-prajs-listy/22-print");
        File file = $(byText("Амрита-Русь")).scrollTo().download();

        XLS parsedXls = new XLS(file);
        System.out.println();
        boolean checkPassed = parsedXls.excel.getSheetAt(0).getRow(5).getCell(9).getStringCellValue().contains("Дата печати:");

        assertTrue(checkPassed);
    }

    @Disabled
    @Test
    @DisplayName("Парсинг CSV файлов")
    @Severity(SeverityLevel.NORMAL)
    void parseCsvFileTest() throws IOException, CsvException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream("csv.csv");
             Reader reader = new InputStreamReader(is)) {
            CSVReader csvReader = new CSVReader(reader);

            List<String[]> strings = csvReader.readAll();
            assertEquals(4, strings.size());
        }
    }

    @Disabled
    @Test
    @DisplayName("Парсинг ZIP файлов")
    void parseZipFileTest() throws IOException, CsvException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        int count = 0;
        try (InputStream is = classLoader.getResourceAsStream("zima.zip");
             ZipInputStream zis = new ZipInputStream(is)) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                count++;
                System.out.println(count + "-я картинка - " + entry.getName());
            }
        }
    }

}

