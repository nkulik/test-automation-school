package test.automation.school.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.automation.school.utils.WebDriverHelper;

import java.util.List;

public class SearchResultPage {
    private WebDriverWait wait;
    private WebDriver driver;

    //@FindBy(xpath = "//tr[contains(@id,'tr_') and not(contains(@id,'tr_bnr'))]")
    @FindBy(css = "[id*='tr_']:not([id*='tr_bnr_'])")
    private List<WebElement> searchResultElements;

    @FindBy(id = "page_main")
    private WebElement searchResultMainSection;

    @FindBy(xpath = "//*[text()='Цена' or text()='Cena'][ancestor::*[@id='head_line']]")
    private WebElement priceSortingButton; //task#2

    @FindBy(css = ".filter_opt_dv:nth-child(3) select")
    private WebElement dealTypeDropdown; //task#2

    @FindBy(xpath = "//*[text()='Расширенный поиск' or text()='Paplašināta meklēšana']")
    private WebElement extendedSearchLink; //task#2

//    TODO
    private static final String CHECKBOX_LIST_LOCATOR = "";

    public SearchResultPage(WebDriver driver) { //zdesj inicializirovali stranichku search results
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(searchResultMainSection));
    }

    public int getSearchResultElementCount() {
        return searchResultElements.size();
    }

    //task#2: step8
    public SearchResultPage sortByPrice() {
        wait.until(ExpectedConditions.elementToBeClickable(priceSortingButton));
        priceSortingButton.click();
        return this;
    }

    //task#2: step8; see WebDriverHelper in utils
    public SearchResultPage selectDealType(String dropdownValue) {
        WebDriverHelper.selectDropdownValueByText(dealTypeDropdown,dropdownValue);
        return this;
    }

    //task#2: step9
    public ExtendedSearchPage goToExtendedSearchPage() {
        extendedSearchLink.click();
        return new ExtendedSearchPage(driver); //perehodim na novuju stranicu Rasshirennogo poiska
    }

    //    TODO
    // task#2: step11
  //  public SearchResultPage checkCheckboxes(int checkCount) {
    //    for (int i = 0; i < checkCount; i++) {
            //this.searchResultElements.
      //  }
   // }
}
