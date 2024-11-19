package implementations;

import com.microsoft.playwright.*;

public class App {
    public static void main(String[] args) {
        try(Playwright playwright=Playwright.create()){
          BrowserType.LaunchOptions launchOptions=new BrowserType.LaunchOptions();
          launchOptions.setChannel("chrome");
          launchOptions.setHeadless(false);
          Browser browser=playwright.chromium().launch(launchOptions);
          BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));

            String browserName=System.getenv("BROWSER");


     /*     if(browserName.equals("chromium")){
         browser= playwright.chromium().launch();
          }
          else if (browserName.equals("firefox")) {
              browser=playwright.firefox().launch();
          }
         else if(browserName.equals("webkit")){
             browser=playwright.webkit().launch();
            }*/
            Page page=browser.newPage();

            page.navigate("https://www.facebook.com");
            String title=page.title();
            System.out.println("Page Title is: "+title);
            String url=page.url();
            System.out.println("Page Url is: "+url);
            page.click("");


      }
    }
}