/*
* File: App.java
* Author: Nagy József
* Copyright: 2021, Nagy József 
* Date: 2021-09-11
* Licenc: MIT
* refaktoring: Vitovszkit Tamás, Date 2023.12.04
*/

import controllers.MainController;
import views.MainWindow;

public class App { public static void main(String[] args)throws Exception { 
    MainWindow mainWindow = new MainWindow();
    new MainController(mainWindow); mainWindow.setVisible(true);
}}

