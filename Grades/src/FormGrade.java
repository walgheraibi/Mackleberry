

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormGrade
 */
@WebServlet("/FormGrade")
public class FormGrade extends HttpServlet {
	private String Assignmet ="";
	private String Grade ="";
	private double  avg=0.0;
	private int count =0;
	private String gradeList ="";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormGrade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 gradeList ="";
		 avg=0;
		 count=0;
			  String url = "jdbc:oracle:thin:testuser/password@localhost"; 
		      
		        //properties for creating connection to Oracle database
		        Properties props = new Properties();
		        props.setProperty("user", "testdb");
		        props.setProperty("password", "password");
		      
		        //creating connection to Oracle database using JDBC
		        Connection conn = null;
		       
				try {
					conn = DriverManager.getConnection(url,props);
				
		        String sql ="select * from Grades";

		       
		        //creating PreparedStatement object to execute query
		        PreparedStatement preStatement = conn.prepareStatement(sql);
		    
		        ResultSet result = preStatement.executeQuery();
		        
		     //   System.out.println("<ul class=\"list-group\">");
		        while(result.next()){

		        	gradeList+=" <li class=\"list-group-item\"> <b>Assignment : </b>"+result.getString("ASSGINMENT") +"&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<b>Grade : </b>"+result.getString("GRADE")+"</li>";
		        avg+=   result.getDouble("GRADE");
		        count++;
		        } 
		        avg= (avg/count);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      // Set response content type
		      response.setContentType("text/html");
		     
		      // Actual logic goes here.
		      request.setAttribute("gradeList",gradeList);
		      request.setAttribute("gradeAvg",avg);
		      getServletContext().getRequestDispatcher("/input.jsp").forward(request, response);
		 }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	
			 Assignmet=request.getParameter("Assignmet");
			 Grade=request.getParameter("Grade");
			 insertGrade(Assignmet, Grade);
			 
		      // Set response content type
		      response.setContentType("text/html");
		     
		      // Actual logic goes here.
		      getServletContext().getRequestDispatcher("/output.jsp").forward(request, response);
	
		}
			
	protected void  insertGrade(String assignmet, String grade)
			{
				 try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 String url = "jdbc:oracle:thin:testuser/password@localhost"; 
			      
			        //properties for creating connection to Oracle database
			        Properties props = new Properties();
			        props.setProperty("user", "testdb");
			        props.setProperty("password", "password");
			      
			        //creating connection to Oracle database using JDBC
			        Connection conn = null;
			       
					try {
						conn = DriverManager.getConnection(url,props);
					
			        String sql ="insert into grades (ASSGINMENT, GRADE) values('"+assignmet+"',"+Double.parseDouble(grade)+")";


			       
			        //creating PreparedStatement object to execute query
			        PreparedStatement preStatement = conn.prepareStatement(sql);
			    
			        ResultSet result = preStatement.executeQuery();
			        
			     //   System.out.println("<ul class=\"list-group\">");
	
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			}
	}


