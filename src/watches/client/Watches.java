package watches.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

//import java.text.SimpleDateFormat;
import java.util.*;

public class Watches implements EntryPoint {

    public void onModuleLoad() {
        final Label label = new Label();

        if (label.getText().equals("")) {
            Timer t = new Timer() {
                public void run() {
                    Date d = new Date();
                    //SimpleDateFormat format1 = new SimpleDateFormat("hh:mm:ss");
                    label.setText(String.valueOf(d));
                }
            };
            t.scheduleRepeating(100);
        }
        RootPanel.get("slot").add(label);
    }
}
