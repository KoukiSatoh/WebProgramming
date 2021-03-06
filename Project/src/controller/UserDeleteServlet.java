package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

		// URLからGETパラメータとしてIDを受け取る
        String id = request.getParameter("id");

        // 確認用：idをコンソールに出力
        System.out.println(id);


        // TODO  未実装：idを引数にして、idに紐づくユーザ情報を出力する
        UserDao userDao = new UserDao();
		//User user = userDao.findByDelete(id);

       // request.setAttribute("user", user);


        // TODO  未実装：ユーザ情報をリクエストスコープにセットしてjspにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userDelete.jsp");
		dispatcher.forward(request, response);



	}

}
