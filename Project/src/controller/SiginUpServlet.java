package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


		//Httpsessionインスタンスの取得
		HttpSession session = request.getSession();

		//ログインセッションがある場合、ユーザ一覧画面にリダイレクト
		if(session.getAttribute("userInfo") != null) {
			 response.sendRedirect("UserListServlet");
			 return;
		}

		// login.jspにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);

		//サーブレットの動作を決める「action]の値をリクエストパラメータから取得する
		//String action = request.getParameter("action");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

		//リクエストパラメータの文字コード指定
		 request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの取得
		
		 //パスワードを暗号化する



		 //リクエストパラメータの値をDaoに渡す




		 //Daoの処理を条件に分岐(!Daoの時エラーみたいな)





	}
}
