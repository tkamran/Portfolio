package cs3220;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DrivingTestBrowser
 */
@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ArrayList<Question> questions = new ArrayList<Question>();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrivingTestBrowser() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init( ServletConfig config ) throws ServletException
    {
        super.init( config );
        ServletContext context = getServletContext();
        String fullPath = context.getRealPath("/WEB-INF/DrivingTest.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fullPath));
            String line = reader.readLine();
            while ((line != null) && (!line.isEmpty())) {
                String desc = line;
                String ansA = reader.readLine();
                String ansB = reader.readLine();
                String ansC = reader.readLine();
                int correct = Integer.parseInt(reader.readLine());

                Question q = new Question(desc, ansA, ansB, ansC, correct);
                questions.add(q);
                reader.readLine(); 
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int questionNo = 0;
	        try {
	            questionNo = Integer.parseInt(request.getParameter("id"));
	        } catch (NumberFormatException e) {
	        }
	     
	       
	        if(questionNo >= questions.size())
	        {
	            questionNo = questionNo % questions.size();
	        }
	        Question q = questions.get(questionNo);
	     
	        response.setCharacterEncoding("UTF-8");    
	        response.setContentType("text/html");
	     
	      
	    request.setAttribute("desc", q.getDesc());
	    request.setAttribute("answerA", q.getAnsA());
	    request.setAttribute("answerB", q.getAnsB());
	    request.setAttribute("answerC", q.getAnsC());
	    request.setAttribute("correctOption", String.valueOf(q.getCorrect()));

	   
	    request.setAttribute("link", "?id="+ String.valueOf(questionNo+1));

	  
	    request.getRequestDispatcher("/DriverTestV.jsp").forward(request, response);
	    }
	}


