/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */


package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    public Button btnCustomer;
    public Button btnItem;

    public void btnCustomerOnAction(ActionEvent actionEvent) throws IOException {

        System.out.println();

        Parent root = FXMLLoader.load(this.getClass().getResource("../views/CustomerView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Stage primaryStage = (Stage) btnCustomer.getScene().getWindow();
        primaryStage.close();
    }

    public void btnItemOnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(this.getClass().getResource("../views/ItemView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Stage primaryStage = (Stage) btnItem.getScene().getWindow();
        primaryStage.close();
    }
}
