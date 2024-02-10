// .:: Veno Setyoaji Wiratama ::.//
// .::        311910363       ::.//
// .::        TI.19.A.2       ::.//

package com.example.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void masuk(View view) {
        Intent intent = new Intent(LoginActivity.this,ListBookActivity.class);
        startActivity(intent);
    }
}