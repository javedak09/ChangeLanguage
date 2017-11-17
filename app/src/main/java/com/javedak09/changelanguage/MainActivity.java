package com.javedak09.changelanguage;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {

    private final String TAG = "";
    @BindView(R.id.lang)
    Spinner lang;
    @BindView(R.id.q1)
    TextView q1;
    @BindView(R.id.q2)
    TextView q2;
    @BindView(R.id.btn)
    Button btn;
    private int mLanguageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /*ArrayList<String> arr = new ArrayList<>();
        arr.add("English");
        arr.add("Urdu");
        arr.add("Pushto");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lang.setAdapter(adapter);*/

        LocaleUtility.initialize(this, LocaleUtility.ENGLISH);
        setupUi();

        getLocale();
    }


    @OnClick(R.id.btn)
    void changeLocale() {
        if (++mLanguageIndex >= LocaleUtility.LocaleDef.SUPPORTED_LOCALES.length) {
            mLanguageIndex = 0;
        }

        LocaleUtility.setLocale(this, mLanguageIndex);
        setupUi();
    }


    private void getLocale() {
        final Locale[] availableLocales = Locale.getAvailableLocales();
        for (final Locale locale : availableLocales)
            Log.d("Applog", ":" + locale.getDisplayName() + ":" + locale.getLanguage() + ":"
                    + locale.getCountry() + ":values-" + locale.toString().replace("_", "-r"));
    }


    private void setupUi() {
        q1.setText(R.string.q1);
        q2.setText(R.string.q2);
    }

}