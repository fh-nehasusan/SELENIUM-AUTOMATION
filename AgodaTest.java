import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class AgodaTest {

    public static void main(String[] args) {

        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            Actions actions = new Actions(driver);

            driver.manage().window().maximize();
            driver.get("https://www.agoda.com/");



            WebElement search = driver.findElement(
                    By.xpath("//div[@tabindex='-1']//input"));
            search.sendKeys("Lond");

            WebElement city = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//ul[@class='AutocompleteList']//li[@data-element-suggestion-label='Top destination London, United Kingdom (City)']")));
            city.click();

            WebElement fromdate = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[@data-selenium-date='2026-01-04']")));
            fromdate.click();

            WebElement todate = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[@data-selenium-date='2026-01-05']")));
            todate.click();

            Thread.sleep(2000);
            WebElement addroom = driver.findElement(By.xpath("//button[@aria-label='Add Room']"));
            addroom.click();

            WebElement increaseadult = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@aria-label='Add Adults']")));
            increaseadult.click();

            WebElement redirect = driver.findElement(By.xpath("//div[@data-selenium='roomValue']"));
            redirect.click();
            Thread.sleep(2000);


            WebElement searchresult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='SEARCH']")));
            searchresult.click();




            String currentWindow = driver.getWindowHandle();
            Set<String> windows = driver.getWindowHandles();
            for (String w : windows) {
                if (!w.equals(currentWindow)) {
                    driver.switchTo().window(w);
                }
            }

//            Thread.sleep(2000);
//            driver.findElement(
//                    By.xpath("//div[@data-element-name='language-container-selected-language']")).click();
//            List<WebElement> languages = driver.findElements(By.xpath("//p[text()=\"English\"]"));
//            WebElement language =languages.get(1);
////            WebElement language = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-element-name='language-container-selected-language']")));
////            Thread.sleep(4000);
//            language.click();

//            WebElement currency = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-element-name='currency-container-selected-currency']")));
//
//            ((JavascriptExecutor) driver)
//                    .executeScript("arguments[0].scrollIntoView(true);", currency);
//            ((JavascriptExecutor) driver)
//                    .executeScript("arguments[0].click();", currency);
//            currency.click();

            WebElement pound=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Price display (Indian Rupee)']")));
            pound.click();
            WebElement gbp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-value=\"GBP\"]")));
            gbp.click();

            Thread.sleep(2000);
            WebElement minslider=driver.findElement(By.xpath("//div[@class='rc-slider-handle rc-slider-handle-1']"));
            actions.clickAndHold(minslider)
                    .moveByOffset(30,0)
                            .release()
                                    .perform();
                Thread.sleep(2000);
            WebElement maxslider=driver.findElement(By.xpath("//div[@class='rc-slider-handle rc-slider-handle-2']"));
            actions.clickAndHold(maxslider)
                    .moveByOffset(-185,0)
                            .release()
                                    .perform();
            String minValue = driver.findElement(
                    By.xpath("//input[@aria-label='Minimum price filter']")
            ).getAttribute("value");

            String maxValue = driver.findElement(
                    By.xpath("//input[@aria-label='Maximum price filter']")
            ).getAttribute("value");

            System.out.println("Min Price: £" + minValue);
            System.out.println("Max Price: £" + maxValue);

            WebElement filter=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Top reviewed']/../..")));
            filter.click();
            WebElement family=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li//span[text()='Families with young children']")));
            family.click();
            Thread.sleep(2000);
            WebElement hotelname= driver.findElement(By.xpath("//h3[text()='Hampton by Hilton London Stansted Airport']"));
            System.out.println("Hotel Name: " + hotelname.getText());
            WebElement clicked = driver.findElement(By.xpath("//li[@data-hotelid=\"2910952\"]"));
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", clicked);

            clicked.click();
            Thread.sleep(2000);
//            WebElement deal=driver.findElement(By.xpath("(//span[@class=\"sc-bdfBwQ Typographystyled__TypographyStyled-sc-1uoovui-0 MpDRr ikQOiN\"])[1]"));
//            deal.click();
            String resultwindow=driver.getWindowHandle();
            windows=driver.getWindowHandles();
            for(String w : windows){
                if(!w.equals(resultwindow) && !w.equals(currentWindow)){
                    driver.switchTo().window(w);
                }
            }
            WebElement deal=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@data-element-name=\"jump-nav-cheapest-room-btn\"])[2]")));
            deal.click();
//            WebElement pricing=driver.findElement(By.xpath("(//div[@class=\"a5d5b-box a5d5b-fill-inherit a5d5b-text-inherit a5d5b-relative      \"])[24]"));
//            pricing.click();

           WebElement book=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ChildRoomsList-room-featurebuckets'])[1] | (//*[@data-element-name=\"mob-room-offer\"]//ul)[1]")));
            System.out.println(book.getText());




            System.out.println("Test executed successfully ✅");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        }
    }

