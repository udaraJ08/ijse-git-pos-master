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
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemController {
    public TextField txtItemId;
    public TextField txtItemeName;
    public TextField txtItemPrice;
    public TextField txtQtyOnHand;
    public Button btnCreateItem;
    public ImageView btnBack;

    private void addItem() throws SQLException, ClassNotFoundException {
        String id = txtItemId.getText();
        String name = txtItemeName.getText();
        double price = Double.parseDouble(txtItemPrice.getText());
        int qty = Integer.parseInt(txtItemPrice.getText());

        PreparedStatement pstm = DBConnection.
                getInstance().
                getConnection().
                prepareStatement("insert into item values(?,?,?,?)");
        pstm.setObject(1, id);
        pstm.setObject(2, name);
        pstm.setObject(3, qty);
        pstm.setObject(4, price);
        if(!pstm.execute()){
            new Alert(Alert.AlertType.INFORMATION, "SUCCESSFULLY ADDED").show();
        }else{
            new Alert(Alert.AlertType.ERROR, "An error occured while adding an item").show();
        }
    }

    public void txtItemIdOnAction(ActionEvent actionEvent) {

        txtItemeName.requestFocus();
    }

    public void txtItemeNameOnAction(ActionEvent actionEvent) {

        txtItemPrice.requestFocus();
    }

    public void txtItemPriceOnAction(ActionEvent actionEvent) {

        txtQtyOnHand.requestFocus();
    }

    public void txtQtyOnHandOnAction(ActionEvent actionEvent) {

        try {
            addItem();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnCreateItemOnAction(ActionEvent actionEvent) {
        try {
            addItem();
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
