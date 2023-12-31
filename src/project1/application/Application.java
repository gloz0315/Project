package project1.application;

import project1.controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.start();
    }
}
