package com.greeting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//

//�����̶�? �ڹ� Ŭ���� �� ���� ������������ �ؼ� �� ����Ǿ��� �� �ִ� Ŭ����
/*
 * ���� ���� : ������ �����ֱ� �˾ƺ���
 * �¾�� ����? ������ ��û�� ���� �� ����� �� �� �����̳ʿ� ���� �ν��Ͻ��� �޸𸮿� �ö��
 * */



public class HelloServlet extends HttpServlet{
	
	//�� �޼���� ������ �¾ ���Ŀ�, �ʱ�ȭ �۾��� ����
	//�� �� �޼���� Tomcat�� ���� �������̳ʿ� ���� ȣ��ȴ�. �� ������ ���� �� �����ֱ� �޼���
	//�� ȣ���ڴ� �ٷ� ��Ĺ�̴�.
	public void init(ServletConfig config) throws ServletException {
		String msg=config.getInitParameter("msg");
		System.out.println("init() ȣ��� �Ѱܹ��� �Ķ���� ������"+msg);
		
		ServletContext context=config.getServletContext();
		
		
	}
	
	//������ �ϴ� ���� �� �� �ʱ�ȭ���� ��ġ�� Ŭ���̾�Ʈ�� ��û�� ó���� �غ� �Ȱ��̰�
	//Ŭ���̾�Ʈ�� ��û�� ó���ϴ� �޼��尡 �ٷ� ���� �޼����.
	//���� �޼��尡 ��û�� ó���Ϸ��� Ŭ���̾�Ʈ�� ��û ������ Ŭ���̾�Ʈ���� ���� ���������� �ʿ�� �ϱ⶧����
	//service() �޼����� �Ű������� request, response ��ü�� ���޵Ǿ�� �Ѵ�.(����̰� ��)
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ŭ���̾�Ʈ�� ������ ��û ������ �Ķ���͸� ������ ���� ����غ���
		String id = request.getParameter("id");
		
		//Ŭ���̾�Ʈ�� ����
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("����� ������ �Ķ���ʹ�"+id);
	}
	//������ �Ҹ��Ҷ�
	//������ ������ �ڿ��� �ݳ��Ҷ� ���(��Ʈ�� ,db ����)
	@Override
	public void destroy() {
	System.out.println("�� �׾��");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		out.print("Hello Servlet do!!");
	}
}
