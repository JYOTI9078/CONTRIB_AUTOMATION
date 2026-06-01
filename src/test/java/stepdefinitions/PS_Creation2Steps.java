/*
 * Creation : 7 Apr 2025
 */
package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.constants.FrameworkConstants;
import com.sogeti.automation.test.pageFactory.PageClass;

public class PS_Creation2Steps extends PageClass {

    public PS_Creation2Steps(SelfHealingDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(FrameworkConstants.MEDIUM_WAIT));
        PageFactory.initElements(driver, this);
    }

}
