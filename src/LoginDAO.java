import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.*;
public class LoginDAO {
	public boolean validate(LoginBean loginBean) throws Exception
	{
		DBConnection dbconnect = new DBConnection();
		Connection connection = dbconnect.connect();
		PreparedStatement preparedStatement = connection.prepareStatement("Select * from Users where mailid = ? and password = ?");
		preparedStatement.setString(1, loginBean.getmailid());
		preparedStatement.setString(2, loginBean.getPassword());
		ResultSet rs = preparedStatement.executeQuery();
		boolean isRowPresent = rs.next();
		return isRowPresent;
	}    
}
