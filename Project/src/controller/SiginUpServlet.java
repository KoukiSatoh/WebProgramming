package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SiginUpServlet
 */
@WebServlet("/SiginUpServlet")
public class SiginUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiginUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * @ユーザ新規登録
	 * @ログインID
	 * @パスワード
	 * @パスワード確認
	 * @ユーザ名
	 * @生年月日
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		
		//サーブレットの動作を決める「action]の値をリクエストパラメータから取得する
		String action = request.getParameter("action");

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		//リクエストパラメータの文字コード指定
		 request.setCharacterEncoding("UTF-8");
		 
		//リクエストパラメータの取得
		 String loginId = request.getParameter("loginId");
		 String password = request.getParameter("password");
		 String passConf = request.getParameter("passConf");
		 String name = request.getParameter("name");
		 String birthDate = request.getParameter("birthDate");
		 
		 
		 

	}
}
