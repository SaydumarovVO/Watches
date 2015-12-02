package watches.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;

//import java.text.SimpleDateFormat;
import java.util.*;

public class Watches implements EntryPoint {

    public void onModuleLoad() {
        final Label label1 = new Label();
        final Button timerButton = new Button("Секундомер");
        final Label label2 = new Label();
        final int[] mutable = {1};
        final Stopwatch stopwatch = new Stopwatch(1);

        stopwatch.onTick(new Runnable (){
            @Override
            public void run() {
                label1.setText(String.valueOf(mutable[0]++));
            }
        } );




        timerButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (stopwatch.isRunning()) {
                    stopwatch.pause();
                } else {
                    stopwatch.go();
                }
            }
        });

        RootPanel.get("slot1").add(label1);
        RootPanel.get("slot2").add(timerButton);
        RootPanel.get("slot3").add(label2);
    }
}
