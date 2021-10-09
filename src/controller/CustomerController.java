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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerController {
    public TextField txtCustomerID;
    public TextField txtCustomerName;
    public TextField txtCustomerAge;
    public TextField txtCustomerAddress;
    public Button btnCreateCustomer;
    public ImageView btnBack;

    ///DB persisting

    ///lead functions
    private void createCustomer(){

        String id = txtCustomerID.getText();
        String name = txtCustomerName.getText();
        String age = txtCustomerAge.getText();
        String address = txtCustomerAddress.getText();


    }

    ///Action methods
    public void txtCustomerIDOnAction(ActionEvent actionEvent) {

        txtCustomerName.requestFocus();
    }

    public void txtCustomerNameOnAction(ActionEvent actionEvent) {

        txtCustomerAge.requestFocus();
    }

    public void txtCustomerAgeOnAction(ActionEvent actionEvent) {

        txtCustomerAddress.requestFocus();
    }

    public void txtCustomerAddressOnAction(ActionEvent actionEvent) {

        createCustomer();
    }

    public void btnCreateCustomerOnAction(ActionEvent actionEvent) {

        createCustomer();
    }

    public void btnBackOnAction(MouseEvent mouseEvent) throws IOException {

        Parent root = FXMLLoader.load(this.getClass().getResource("../views/DashboardView.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Stage primaryStage = (Stage) btnBack.getScene().getWindow();
        primaryStage.close();
    }
}
