package ontotest;
import java.sql.Connection; 
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet; 
import java.sql.ResultSetMetaData; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.List; 
 
import javax.sql.DataSource;

import org.apache.log4j.BasicConfigurator; 


public class DBConnectionClass {


 

    DataSource dataSource; 
    String Chemain ;
   public DBConnectionClass (String Arg){
	   Chemain=Arg;
	   
   }
 
    public DataSource getDataSource() { 
        return dataSource; 
    } 
 
    public void setDataSource(DataSource dataSource) { 
        this.dataSource = dataSource; 
    } 
 
    public void exec(String sql) throws Exception { 
        if (dataSource == null) { 
            throw new RuntimeException("No DataSource selected"); 
        } 
        Connection con = dataSource.getConnection(); 
        Statement stmt = null; 
        try { 
            stmt = con.createStatement(); 
            stmt.execute(sql); 
        } catch (Exception e) { 
            throw e; 
        } finally { 
            if (stmt != null) { 
                stmt.close(); 
            } 
        } 
    } 
 
    public ShellTable getTableInfo() {
    	//	throws Exception { 
      //  if (dataSource == null) { 
          //  throw new RuntimeException("No DataSource selected"); 
     //   } 
       // connection = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/ajmi.CL-G1GYL12/workspace/ontotest/src/Etudiant.accdb");
        Connection con;
		try {
			con = DriverManager.getConnection(Chemain);
			 DatabaseMetaData metaData = con.getMetaData(); 
		        ResultSet rs = metaData.getTables(null, null, null, null); 
		        String rs2= metaData.getUserName();
		       
		        ShellTable table = printResult(rs); 
		        System.out.println(rs2);
		       // ShellTable table2 = printResult(rs2);
		        rs.close(); 
		        return table; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		return null;
    } 
 
    public ShellTable query(String sql) throws Exception { 
        if (dataSource == null) { 
            throw new RuntimeException("No DataSource selected"); 
        } 
        Connection con = dataSource.getConnection(); 
        Statement stmt = null; 
        try { 
            stmt = con.createStatement(); 
            ResultSet rs = stmt.executeQuery(sql); 
            ShellTable table = printResult(rs); 
            rs.close(); 
            return table; 
        } catch (Exception e) { 
            throw e; 
        } finally { 
            if (stmt != null) { 
                stmt.close(); 
            } 
        } 
    } 
 
    private ShellTable printResult(ResultSet rs) throws SQLException { 
        ShellTable table = new ShellTable(); 
        ResultSetMetaData meta = rs.getMetaData(); 
        for (int c = 1; c <= meta.getColumnCount(); c++) { 
            table.header.add(meta.getColumnLabel(c)); 
        } 
        while (rs.next()) { 
            List<String> row = table.addRow(); 
            for (int c = 1; c <= meta.getColumnCount(); c++) { 
                row.add(rs.getString(c)); 
            } 
        } 
        return table; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		DBConnectionClass DBC = new DBConnectionClass("jdbc:ucanaccess://C:/Users/ajmi.CL-G1GYL12/workspace/ontotest/src/Etudiant.accdb");
		ShellTable ST=	DBC.getTableInfo();

	}

}
