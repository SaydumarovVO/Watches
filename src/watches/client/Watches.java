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

        Timer t = new Timer() {
            public void run() {
                Date d = new Date();
                DateTimeFormat fmt = DateTimeFormat.getFormat("HH:mm:ss");
                label1.setText(String.valueOf(fmt.format(d)));
            }
        };
        t.scheduleRepeating(1000);

        timerButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (label2.getText().equals("")) {
                    Timer t = new Timer() {
                        final Date date = new Date();

                        public void run() {
                            Date d = new Date();
                            DateTimeFormat fmt = DateTimeFormat.getFormat("HH:mm:ss:SS");
                            long k = d.getTime() - date.getTime() - 3 * 1000 * 60 * 60;
                            Date n = new Date();
                            n.setTime(k);
                            label2.setText(String.valueOf(fmt.format(n)));

                        }
                    };
                    t.scheduleRepeating(10);
                }
                else{
                    //label2.fireEvent(event);
                    label2.setText("");
                }
            }
        });

        RootPanel.get("slot1").add(label1);
        RootPanel.get("slot2").add(timerButton);
        RootPanel.get("slot3").add(label2);
    }
}
