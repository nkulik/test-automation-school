package test.automation.school.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.automation.school.utils.WebDriverHelper;

/**
 * Created by nataly.kulikova on 5/26/2017.
 */
public class ExtendedSearchPage extends SearchPage {
    //asssume that location is not dynamic
    @FindBy(name = "sid")
    private WebElement dealTypeDropdown;

    @FindBy(name = "topt[8][min]")
    private WebElement minPriceInput;

    @FindBy(name = "topt[8][max]")
    private WebElement maxPriceInput;

    public ExtendedSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ExtendedSearchPage selectDealType(String division) {
        WebDriverHelper.selectDropdownValueByText(dealTypeDropdown, division);
        return this;
    }

    //task#2: step10a
    public ExtendedSearchPage setPriceBoundaries(String minPrice, String maxPrice) {
        setMinPrice(minPrice);
        setMaxPrice(maxPrice);
        return this;
    }

    //task#2: step10b
    public ExtendedSearchPage setMinPrice(String minPrice) {
        minPriceInput.sendKeys(minPrice);
        return this;
    }

    //task#2: step10c
    public ExtendedSearchPage setMaxPrice(String maxPrice) {
        minPriceInput.sendKeys(maxPrice);
        return this;
    }
}
