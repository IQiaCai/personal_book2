package com.itdou;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavafxApplication extends Application {

    private static ApplicationContext applicationContext;

    private static FXMLLoader loaderFxml(String fxmlPath){
        FXMLLoader fxmlLoader=new FXMLLoader();
        fxmlLoader.setLocation(JavafxApplication.class.getResource(fxmlPath));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        return fxmlLoader;
    }

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(JavafxApplication.class, args);
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("个人通讯录");
        primaryStage.setScene(new Scene(loaderFxml("/hello.fxml").load()));
        primaryStage.show();
    }
}
