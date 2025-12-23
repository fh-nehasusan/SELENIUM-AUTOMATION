import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AmazonTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        WebElement searchbar=driver.findElement(By.xpath("//div[@class='nav-search-field ']//input"));
        searchbar.sendKeys("Shoes");
        searchbar.submit();
        WebElement Shoe= driver.findElement(By.xpath("//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal']//h2//span[1]"));
        Shoe.getText();
        System.out.println("Shoe text: "+Shoe.getText());
        Shoe.click();
        List<WebElement> productList = driver.findElements(
                By.xpath("//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal']")
        );
        ArrayList<String> products = new ArrayList<>();


        for(WebElement p : productList) {
            products.add(p.getAttribute("href"));
        }


        System.out.println("Total products: " + products.size());

        Set<String> name=driver.getWindowHandles();
        String currentWindow = driver.getWindowHandle();
        for(String w : name){
            if(!w.equals(currentWindow)){
                driver.switchTo().window(w);
            }
        }
        WebElement cart=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        cart.click();
        WebElement cartpage= driver.findElement(By.xpath("//span[@class='a-button-inner']//a[@class='a-button-text']"));
        cartpage.click();

    }
}
