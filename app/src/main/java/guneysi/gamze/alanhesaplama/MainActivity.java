package guneysi.gamze.alanhesaplama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etGen,etYuksek,etYcap;
    Spinner spSekil;
    TextView txtSonuc;
    Double genislik=0.0;
    Double yukseklik=0.0;
    Double yaricap=0.0;
    Double sonuc=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGen=(EditText)findViewById(R.id.etGen);
        etYuksek=(EditText)findViewById(R.id.etYuk);
        etYcap=(EditText)findViewById(R.id.etYcap);
        spSekil=(Spinner)findViewById(R.id.spinner);
        txtSonuc=(TextView)findViewById(R.id.tvSon);

        List<String> sekiller=new ArrayList<String>();
        sekiller.add("Bir şekil seçiniz!");
        sekiller.add("Daire");
        sekiller.add("Kare");
        sekiller.add("Dikdörtgen");
        sekiller.add("Küre");
        sekiller.add("Küp");

        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sekiller);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spSekil.setAdapter(dataAdapter);

        spSekil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String secilen=parent.getItemAtPosition(position).toString();
                yukseklik=Double.parseDouble(etYuksek.getText().toString());
                genislik=Double.parseDouble(etGen.getText().toString());
                yaricap=Double.parseDouble(etYcap.getText().toString());

                if (secilen.equals("Bir şekil seçiniz!")){
                    Toast.makeText(MainActivity.this,"Bir şekil seçiniz!",Toast.LENGTH_SHORT).show();
                }
                else if (secilen.equals("Daire")){
                    sonuc=3.14*yaricap*yaricap;
                    txtSonuc.setText("Seçilen şeklin alanı: "+sonuc);
                }
                else if (secilen.equals("Kare")){
                    sonuc=genislik*genislik;
                    txtSonuc.setText("Seçilen şeklin alanı: "+sonuc);
                }
                else if (secilen.equals("Dikdörtgen")){
                    sonuc=genislik*yukseklik;
                    txtSonuc.setText("Seçilen şeklin alanı: "+sonuc);
                }
                else if (secilen.equals("Küre")){
                    sonuc=4*3.14*yaricap*yaricap;
                    txtSonuc.setText("Seçilen şeklin alanı: "+sonuc);
                }
                else if (secilen.equals("Küp")){
                    sonuc=6*genislik*genislik;
                    txtSonuc.setText("Seçilen şeklin alanı: "+sonuc);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
