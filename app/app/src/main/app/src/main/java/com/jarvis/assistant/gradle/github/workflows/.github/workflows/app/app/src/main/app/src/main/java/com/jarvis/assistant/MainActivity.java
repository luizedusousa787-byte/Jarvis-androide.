
package com.jarvis.assistant;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity {

    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setBackgroundColor(Color.rgb(3, 8, 20));
        layout.setPadding(30, 30, 30, 30);

        TextView title = new TextView(this);
        title.setText("J.A.R.V.I.S");
        title.setTextColor(Color.CYAN);
        title.setTextSize(34);
        title.setGravity(Gravity.CENTER);

        TextView reactor = new TextView(this);
        reactor.setText("◉");
        reactor.setTextColor(Color.CYAN);
        reactor.setTextSize(130);
        reactor.setGravity(Gravity.CENTER);

        status = new TextView(this);
        status.setText("SISTEMA ONLINE");
        status.setTextColor(Color.WHITE);
        status.setTextSize(18);
        status.setGravity(Gravity.CENTER);

        Button button = new Button(this);
        button.setText("ATIVAR JARVIS");
        button.setOnClickListener(v ->
            status.setText("AGUARDANDO COMANDO, SENHOR")
        );

        layout.addView(title);
        layout.addView(reactor);
        layout.addView(status);
        layout.addView(button);

        setContentView(layout);
    }
}
