package androiddeveloper.wayto.redgun.myappsportfolio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView portfolio_lv;
    ArrayList<MyApp> appsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appsList = new ArrayList<>();
        appsList.add(new MyApp(getResources().getString(R.string.app1_name), getResources().getString(R.string.app1_package_name)));
        appsList.add(new MyApp(getResources().getString(R.string.app2_name), getResources().getString(R.string.app2_package_name)));
        appsList.add(new MyApp(getResources().getString(R.string.app3_name), getResources().getString(R.string.app3_package_name)));
        appsList.add(new MyApp(getResources().getString(R.string.app4_name), getResources().getString(R.string.app4_package_name)));
        appsList.add(new MyApp(getResources().getString(R.string.app5_name), getResources().getString(R.string.app5_package_name)));
        appsList.add(new MyApp(getResources().getString(R.string.app6_name), getResources().getString(R.string.app6_package_name)));
        portfolio_lv = (ListView) findViewById(R.id.portfolio_lv);
        portfolio_lv.setAdapter(new MyAppsAdapter(this, appsList));
        portfolio_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                MyApp clickedApp = appsList.get(position);
                if (clickedApp != null && !(clickedApp.getAppPackageName() == null || clickedApp.getAppPackageName().equals(""))) {
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + clickedApp.getAppPackageName())));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + clickedApp.getAppPackageName())));
                    }
                } else {
                    showToast("This button will launch my " + clickedApp.getAppName() + " app!");
                }
            }
        });
    }

    /**
     * Method to display Toast message
     */
    private void showToast(String value) {
        if (value != null)
            Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();
    }
}
