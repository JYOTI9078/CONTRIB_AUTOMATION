package com.sogeti.automation.test.pageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class EmpMgtDemo_AddEmpPage extends PageClass {

    @FindBy(id = "iv_add_user_icon")
    private WebElement btnAddEmployee;

    @FindBy(id = "et_password_field")
    private WebElement txtPassword;

    @FindBy(id = "btn_login")
    private WebElement btnLogin;

    @FindBy(id = "tv_save_detail")
    private WebElement btnSave;

    @FindBy(id = "tv_employee_name")
    private WebElement addedEmpEntry;

    @FindBy(id="tv_sign_out")
    private WebElement btnSignOut;

    @FindAll(@FindBy(className = "android.widget.EditText"))
    private List<WebElement> empFields;

    public EmpMgtDemo_AddEmpPage(SelfHealingDriver _hdriver) {
        super(_hdriver);
        wait = new WebDriverWait(_hdriver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(_hdriver, this);
    }

    public Boolean isAddEmpButtonVisible() {
        boolean flag = false;
        try {
            wait.until(ExpectedConditions.visibilityOf(btnAddEmployee));
             flag = true;
        } catch (NoSuchElementException ne) {
            return false;
        } catch (Exception e) {
            log.error("Failed to check title of main page.\n" + e);
            return false;
        }
        return flag;
    }

    public void dataEntryforNewEmployeeAdd(List<String> data){

        btnAddEmployee.click();
        wait.until(ExpectedConditions.visibilityOf(empFields.get(0)));
        for(int i=0;i<empFields.size();i++)
        {
            WebElement field = (empFields).get(i);
            field.sendKeys(data.get(i));
        }
        btnSave.click();
    }

    public String verifyDataEntryforNewEmployeeAdd(){

        String nameCheck = addedEmpEntry.getText().trim();
        return nameCheck;
    }

    public void userSignout(){

        btnSignOut.click();
    }

}
