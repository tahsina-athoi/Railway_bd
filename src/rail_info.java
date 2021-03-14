import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class rail_info {
    
     public void addUpdateDeleteTrain(char operation, String Tno, String Tname, String Seat, String Start, String Destination, String Cls, String Price) throws SQLException
     {
         Connection con = sql_connect.ConnectDB();
         PreparedStatement ps;
         
         if(operation == 'i') //insert
         {
             ps = con.prepareStatement("insert into train_info values(?,?,?,?,?,?,?);");
             ps.setString(1, Tno);
             ps.setString(2, Tname);
             ps.setString(3, Seat);
             ps.setString(4, Start);
             ps.setString(5, Destination);
             ps.setString(6, Cls);
             ps.setString(7, Price);
             
             if(ps.executeUpdate()>0){
                 JOptionPane.showMessageDialog(null, "New Train Added");
             }
         }
         
         if(operation == 'u') //update
         {
             ps = con.prepareStatement("UPDATE `train_info` SET `TrainName`= ?,`TotalSeat`= ?,`StartPlace`= ?,`Destination`= ?,`Class`= ?,`Price`= ? WHERE `TrainNo`= ?;");
             
             ps.setString(1, Tname);
             ps.setString(2, Seat);
             ps.setString(3, Start);
             ps.setString(4, Destination);
             ps.setString(5, Cls);
             ps.setString(6, Price);
             ps.setString(7, Tno);
             
             if(ps.executeUpdate()>0){
                 JOptionPane.showMessageDialog(null, "Train Information Updated");
             }
         }
         
         if(operation == 'd') //delete
         {
             ps = con.prepareStatement("DELETE FROM `train_info` WHERE `TrainNo`= ?;");
           
             ps.setString(1, Tno);
             
             if(ps.executeUpdate()>0){
                 JOptionPane.showMessageDialog(null, "Train Deleted");
             }
         }
         
     }
     
     public void fillStudentTable(JTable table, String valueToSearch)
     {
         Connection con = sql_connect.ConnectDB();
         PreparedStatement ps;
         
         try {
             ps = con.prepareStatement("");
         } catch (SQLException ex) {
             Logger.getLogger(rail_info.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}
