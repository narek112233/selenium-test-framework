package com.automation.utils;

import org.openqa.selenium.WebElement;

public class Checkbox {
    WebElement checkBoxElement;

    private Checkbox(WebElement checkBoxElement){
       this.checkBoxElement = checkBoxElement;
    }

    public static Checkbox getInstance(WebElement checkBoxElement)  {
        return new Checkbox(checkBoxElement);
    }

    public void check(){
        if(!this.checkBoxElement.isSelected()){
            checkBoxElement.click();
        }
    }

    public void unCheck(WebElement checkBoxElement){
        if(checkBoxElement.isSelected()){
            checkBoxElement.click();
        }
    }

}
