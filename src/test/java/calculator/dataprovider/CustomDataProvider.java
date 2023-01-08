package calculator.dataprovider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
    @DataProvider(name = "Operator")
    public Object[][] operator(){
        Object[][] data = {{"+"},{"-"},{"x"},{"/"}};
        return data;
    }
}
