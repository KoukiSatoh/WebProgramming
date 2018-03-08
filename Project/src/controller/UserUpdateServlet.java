package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

		//HttpSessionインスタンスの取得
		HttpSession session = request.getSession();
		//セッションが空の場合、ユーザ画面に遷移
		if(session.getAttribute("userInfo") == null) {
		    //LoginServletにリダイレクト
			response.sendRedirect("LoginServlet");
			return;
		}


		// URLからGETパラメータとしてIDを受け取る
        String id = request.getParameter("id");

        // 確認用：idをコンソールに出力
        System.out.println(id);


        // TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
        UserDao userDao = new UserDao();
		User user = userDao.findByDetail(id);

        request.setAttribute("user", user);


        // TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード
     // userUpdate.jspへフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
		dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		//リクエストパラメータの文字コード指定
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの取得（フォームに入力された内容）
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String passConf = request.getParameter("passConf");
		String name = request.getParameter("name");
		String birthdate = request.getParameter("birthdate");

		//ユーザ情報保持するために新しくインスタンスを作る
	

		//暗号化されたパスワードとパスワード（確認）を生成



		//ユーザ名と生年月日に未入力があるかで分岐
		if(name.equals("") || birthdate.equals("") ) {
			request.setAttribute("errMsg", "入力された内容は正しくありません。");//未入力があったらエラーメッセージが表示される
			//jspにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// パスワードとパスワード確認が同じであるか、もし同じ時にパスワードは未入力であるかで分岐させる
		if(!password.equals(passConf)) {//passwordとpassConfが一致しないとエラーを出すよ
			request.setAttribute("errMsg", "パスワードが一致しません。");
			//jspにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if(password.equals("") && passConf.equals("")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
			dispatcher.forward(request, response);
		}


		UserDao userDao = new UserDao();
		userDao.findByUpdate(password,name,birthdate,id);

		response.sendRedirect("UserListServlet");

	}
}
