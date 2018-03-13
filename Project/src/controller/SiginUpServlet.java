package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Cryption;
import dao.UserDao;

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


    /*
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * ユーザ新規登録
	 * ログインID
	 * パスワード
	 * パスワード確認
	 * ユーザ名
	 * 生年月日
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {


		//Httpsessionインスタンスの取得
		HttpSession session = request.getSession();

		//ログインセッションがない場合、ログイン画面にリダイレクト（ログアウト）
		if(session.getAttribute("userInfo") == null) {
			 response.sendRedirect("LoginServlet");
			 return;
		}


		//
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

		//リクエストパラメータの文字コード指定、セッション情報の文字化け対策
		 request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの取得
		 String loginId  = request.getParameter("login_id");
		 String password = request.getParameter("password");
		 String passConf = request.getParameter("passConf");
		 String 	  name   = request.getParameter("name");
		 String birthDate = request.getParameter("birth_date");

		 //パスワードを暗号化する
		 String encPass = Cryption.encryption(password);
		 String encPassConf = Cryption.encryption(passConf);


		 //ちゃんと値を受け取れているかチェックする
		 System.out.println(loginId);
		 System.out.println(encPass);
		 System.out.println(encPassConf);
		 System.out.println(name);
		 System.out.println(birthDate);

		 //リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
		 UserDao userdao = new UserDao();
		 boolean sigin = userdao.siginCheck(loginId,encPass,encPassConf,name,birthDate);

	     //更新に失敗した場合は入力画面に戻り、成功した場合はユーザ一覧ページにリダイレクトする

		 if(!sigin) {// 変数siginと違ったらエラーをだす
			 request.setAttribute("errMsg","入力された内容は正しくありません");

			 //入力フォームに入力された値を保持する
			 request.setAttribute("loginId", loginId);
			 request.setAttribute("name", name);
		    	 request.setAttribute("birthDate", birthDate);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp");
			dispatcher.forward(request, response);

		 }else {
			 //未入力やパスワードの不一致がなければ、UserListServletにリダイレクトさせる
			  response.sendRedirect("UserListServlet");

		}
	}
}
