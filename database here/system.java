package com.exchange;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.InputStream;
import java.net.*;
import com.google.gson.*;
class Recv

{
	private String Ihs;
	private String Rhs;
	private String Error;
	private String Icc;
	public Recv()
	{

	}
	public String getLhs()
	{
		return Ihs;
	}
	public String getRhs()
	{
		return Rhs;
	}
}
public class Convert extends HttpServlet{

/**
* Processes requests for both HTTP GET and POST methods.
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servletspecific error occurs
* @throws IOException if an I/O error occurs
*/

protected void
processRequest(HttpServletRequest req, HttpServletResponse resp)
throws ServletException, IOException{
	String Query= "";
	String Amount="";
	String CurTo="";
	String Submit="";
	String Res="";
	HttpSession Session;
	Resp.setContentType("text/html;charset=UTP-8"); 
	PrintWriter Out= Resp.getWriter();
	/*Read request parameters*/
	Amount= Req.getParameter("amount");
	CurTo= Req.getParameter("to");
	CurFrom= Req.getParameter("from");
	/*Open a connection to google and read the result*/
	try{
		Query="http://www.google.com/ig/calculator?hI=en&q=" + amount + curFrom + "=?" +curTo;
		URL url =new URL(Query);
		InputStreamReader Stream=new
		InputStreamReader(url.openStream());

		BufferedReader in =new
		BufferedReade(stream);
		String str="";
		String temp="";
		while((temp=in.readLine())!=null){
			str= str +temp;

		}
		/*Parse the result which is in json format*/
		Gson gson=new Gson();
		Recv st= gson.fromJson(str,Recv.class);
		String Rhs=st.getRhs();
		Rhs=rhs.replaceAll("?","");
		/*we do the check in order to print the additional word(millions, billions etc)*/
		StringTokenizer strto= new
		StringTokenizer(rhs);6
		String nextToken;

		out.write(strto.nextToken());
		nextToken= strto.nextToken();

		if(nextToken.equals("million")|| nextToken.equals("billion")|| nextToken.equals("trillion"))
		{
			out.printIn("+nextToken");
		}

	} catch(NumberFormatException e) {

		out.println("The given amount is not a valid number");

	}

}
/**
* Handles the HTTP GET method.
*@param request servlet request
*@param response servlet response
*@throws ServletException if a servletspecific error occurs
*@throws IOException if an I/O error occurs
*/

@Override
protected void doGet(HttpServletRequest request,HttpSevletResponse response)

throws ServletException,IOException{
	processRequest(request, response);
}

/**
* Handles the HTTP POST method.
*@param request servlet request
*@param response servlet response
*@throws ServletException if a servletspecific error occurs
*@throws IOException if an I/O error occurs
*/
@Override
protected void doGet(HttpServletRequest request,HttpSevletResponse response)

throws ServletException,IOException{
	processRequest(request, response);
}
/**
* Returns a short description of the servlet.
*@return a String containing servlet description
*/
@Override
public String getServletlnfo(){
	return"Short description";
}

}
