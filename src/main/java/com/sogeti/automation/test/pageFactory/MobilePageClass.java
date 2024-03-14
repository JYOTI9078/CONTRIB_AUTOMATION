package com.sogeti.automation.test.pageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.sogeti.automation.framework.utils.AndroidUtils;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.support.PageFactory;

public class MobilePageClass extends AndroidUtils {

    public MobilePageClass(SelfHealingDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        ThreadContext.pop();
        ThreadContext.push(this.getClass().getSimpleName());
    }

}
