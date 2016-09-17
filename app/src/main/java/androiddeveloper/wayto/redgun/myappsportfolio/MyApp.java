package androiddeveloper.wayto.redgun.myappsportfolio;

/**
 * Created by Ravindra on 17-09-2016.
 */
public class MyApp {
    String appName;
    String appPackageName;

    MyApp(String appName, String appPackageName) {
        this.appName = appName;
        this.appPackageName = appPackageName;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppPackageName() {
        return appPackageName;
    }

    public void setAppPackageName(String appPackageName) {
        this.appPackageName = appPackageName;
    }
}
