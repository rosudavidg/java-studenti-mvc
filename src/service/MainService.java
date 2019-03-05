package service;

import dao.StudentDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collections;
import java.util.List;
import model.Student;

public class MainService {
    private Connection con;
    private final String user = "root";
    private final String pass = "";
    private final String url = "jdbc:mysql://localhost:3307/java1pexamen";
        
    private MainService() {
        try {
            this.con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static final class SingletonHolder {
        private static final MainService INSTANCE = new MainService();
    }
    
    public static MainService getInstance() {
        return SingletonHolder.INSTANCE;
    }
    
    public boolean existaStudent(String cnp) {
        StudentDao studentDao = new StudentDao(con);
        
        try {
            return studentDao.existaStudent(cnp);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void adaugaStudent(Student student) {
        StudentDao studentDao = new StudentDao(con);
        
        try {
            studentDao.adaugaStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Student> getStudenti() {
        StudentDao studentDao = new StudentDao(con);
        
        try {
            return studentDao.getStudenti();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
    
    public void deleteStudent(int id) {
        StudentDao studentDao = new StudentDao(con);
        
        try {
            studentDao.deleteStudent(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
