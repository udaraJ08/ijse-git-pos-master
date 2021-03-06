/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) Microsoft Corporation. All rights reserved.
 *  *  Licensed under the MIT License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posMaster", "root", "root");
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {

        if (null == dbConnection)
            dbConnection = new DBConnection();

        return dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
