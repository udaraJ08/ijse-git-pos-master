/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package controller;

import DB.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerController {
    public TextField txtCustomerID;
    public TextField txtCustomerName;
    public TextField txtCustomerAge;
    public TextField txtCustomerAddress;
    public Button btnCreateCustomer;
    public ImageView btnBack;

    ///DB persisting

    ///lead functions
    private void createCustomer() throws SQLException, ClassNotFoundException {

        String id = txtCustomerID.getText();
        String name = txtCustomerName.getText();
        int age = Integer.parseInt(txtCustomerAge.getText());
        String address = txtCustomerAddress.getText();

        PreparedStatement pstm = DBConnection.
                getInstance().
                getConnection().
                prepareStatement("insert into customer values(?,?,?,?)");
        pstm.setObject(1, id);
        pstm.setObject(2, name);
        pstm.setObject(3, age);
        pstm.setObject(4, address);
        if(pstm.execute()){
            new Alert(Alert.AlertType.INFORMATION, "SUCCESSFULLY ADDED").show();
        }else{
            new Alert(Alert.AlertType.ERROR, "An error occured while adding a customer").show();
        }

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

        try {
            createCustomer();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnCreateCustomerOnAction(ActionEvent actionEvent) {

        try {
            createCustomer();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
