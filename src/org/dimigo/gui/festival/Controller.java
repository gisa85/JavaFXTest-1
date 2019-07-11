package org.dimigo.gui.festival;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {


    @FXML private Button btn_retry;
    @FXML private TextField btc_current_price;
    @FXML private TextField bit_coin_amount;
    @FXML private TextField xrp_amount;
    @FXML private TextField xrp_current_price;
    @FXML private TextField eth_amount;
    @FXML private TextField eth_current_price;
    @FXML private Label lbl_time;

@FXML void changeAll(ActionEvent event) {
    BitCoinLast(event);
    xrpLast(event);
    ethLast(event);



}
    @FXML void BitCoinLast(ActionEvent event) {
        try {
            String bit_url = "https://api.korbit.co.kr/v1/ticker?currency_pair=btc_krw";
            Document doc = Jsoup.connect(bit_url).get();
            String last = doc.toString().split("last\":\"")[1].split("\"")[0];

                int amount = Integer.parseInt(bit_coin_amount.getText());
                int worth = Integer.parseInt(last);
                String lastprint = Integer.toString(amount * worth);
                btc_current_price.setText(lastprint);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML public void xrpLast(ActionEvent event) {
        try {
            String xrp_url = "https://api.korbit.co.kr/v1/ticker?currency_pair=qtum_krw";
            Document doc = Jsoup.connect(xrp_url).get();
            String last = doc.toString().split("last\":\"")[1].split("\"")[0];
            System.out.println(last);
            int amount = Integer.parseInt(xrp_amount.getText());
            int worth = Integer.parseInt(last);
            String lastprint = Integer.toString(amount*worth);
            xrp_current_price.setText(lastprint);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML void ethLast(ActionEvent event) {
        try {
            String eth_url = "https://api.korbit.co.kr/v1/ticker?currency_pair=eth_krw";
            Document doc = Jsoup.connect(eth_url).get();
            String last = doc.toString().split("last\":\"")[1].split("\"")[0];
            int amount = Integer.parseInt(eth_amount.getText());
            int worth = Integer.parseInt(last);
            String lastprint = Integer.toString(amount*worth);
            eth_current_price.setText(lastprint);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML void news(ActionEvent event) {
    initFX();
    }

    private static void initFX() {
        JFrame frame = new JFrame("FX");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setVisible(true);




        fxPanel.setSize(new Dimension(600, 450));

        fxPanel.setLocation(new Point(0, 27));



        frame.getContentPane().setPreferredSize(new Dimension(600, 440));

        frame.pack();

        frame.setResizable(false);



        Platform.runLater(new Runnable() {

            public void run() {

                initAndLoadWebView(fxPanel);

            }

        });

    }
    private static void initFX2() {
        JFrame frame = new JFrame("FX");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setVisible(true);




        fxPanel.setSize(new Dimension(600, 850));

        fxPanel.setLocation(new Point(0, 27));



        frame.getContentPane().setPreferredSize(new Dimension(600, 840));

        frame.pack();

        frame.setResizable(false);



        Platform.runLater(new Runnable() {

            public void run() {

                initAndLoadWebView2(fxPanel);

            }

        });

    }



    private static void initAndLoadWebView(final JFXPanel fxPanel) {
        Group group = new Group();
        Scene scene = new Scene(group);
        fxPanel.setScene(scene);

        WebView webView = new WebView();
        group.getChildren().add(webView);
        webView.setMinSize(600, 450);
        webView.setMaxSize(600, 450);
        WebEngine webEngine = webView.getEngine();
        webEngine.load("http://search.naver.com/search.naver?where=news&query=%EA%B0%80%EC%83%81%ED%99%94%ED%8F%90&ie=utf8&sm=tab_she&qdt=0");

    }
    private static void initAndLoadWebView2(final JFXPanel fxPanel) {
        Group group = new Group();
        Scene scene = new Scene(group);
        fxPanel.setScene(scene);

        WebView webView = new WebView();
        group.getChildren().add(webView);
        webView.setMinSize(600, 450);
        webView.setMaxSize(600, 450);
        WebEngine webEngine = webView.getEngine();
        webEngine.load("https://www.korbit.co.kr/");

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ActionEvent event = new ActionEvent();
        BitCoinLast(event);
        ethLast(event);
        xrpLast(event);
    }
}
