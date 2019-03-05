package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Student;

public class StudentDao {
    private Connection con;
    private PreparedStatement stmt1;
    private PreparedStatement stmt2;
    private PreparedStatement stmt3;
    private PreparedStatement stmt4;
            
    public StudentDao(Connection con) {
        this.con = con;
        try {
            stmt1 = con.prepareStatement("SELECT * FROM studenti WHERE cnp = ?");
            stmt2 = con.prepareStatement("INSERT INTO studenti VALUES (NULL, ?, ?, ?)");
            stmt3 = con.prepareStatement("SELECT * FROM studenti");
            stmt4 = con.prepareStatement("DELETE FROM studenti WHERE id = ?");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean existaStudent(String cnp) throws Exception {
        stmt1.setString(1, cnp);
        ResultSet rs = stmt1.executeQuery();
        return rs.next();
    }
    
    public void adaugaStudent(Student student) throws Exception {
        stmt2.setString(1, student.getNume());
        stmt2.setString(2, student.getPrenume());
        stmt2.setString(3, student.getCnp());
        
        stmt2.executeUpdate();
    }
    
    public List<Student> getStudenti() throws Exception {
        List<Student> studenti = new ArrayList<>();
        
        ResultSet rs = stmt3.executeQuery();
        
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setNume(rs.getString("nume"));
            student.setPrenume(rs.getString("prenume"));
            student.setCnp(rs.getString("cnp"));
            
            studenti.add(student);
        }
        
        return studenti;
    }
    
    public void deleteStudent(int id) throws Exception {
        stmt4.setInt(1, id);
        stmt4.executeUpdate();
    }
}
