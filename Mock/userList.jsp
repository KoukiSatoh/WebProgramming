<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <title>ユーザ一覧</title>
  </head>
  <body>

    <ul class="nav justify-content-end bg-dark">
        <li class="nav-text">
            <a class="nav-link" href="UserDetailServlet">
            <font color="white">${userInfo.name} さん</font>
            </a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="LogoutServlet">
            <font color="red">ログアウト</font>
            </a>
        </li>
    </ul>

    <h1>
      <p class="text-center">ユーザ一覧</p>
    </h1>


    <div style="margin-left:80%;margin-right:10%;">
      <a href="signUp.jsp">新規登録</a>
    </div>




      <div class="container">

          <div class="row">
            <div class="col-md-3">ログインID</div>
            <div class="col-md-6 col-md-offset-3"><p><input type="text" name="name" size="45"></p></div>
          </div>

          <div class="row">
            <div class="col-md-3">パスワード</div>
            <div class="col-md-6 col-md-offset-3"><p><input type="password" name="example" size="45"></div>
          </div>

          <div class="row">
            <div class="col-md-3">生年月日</div>
            <div class="col-md-2"><p><input type="date" name="name" size="20"></p></div>
            <div class="col-md-0">〜</div>
            <div class="col-md-3 col-md-offset-2"><p><input type="date" name= size="5"></p></div>
          </div>

          <div style="margin-left:70%;margin-right:10%;">
           <input type="button" style="width:50%;padding:10px;font-size:15px;" value="検索" />
         </div>

     </div>



<span class="border">
  <div class="container">
    <table class="table table-bordered">
      <thead class="thead-light">
        <tr>
          <th scope="col"></th>
          <th scope="col">ログインID</th>
          <th scope="col">ユーザ名</th>
          <th scope="col">生年月日</th>
          <th scope="col"></th>
        </tr>
      </thead>

      <tbody>
       <c:forEach var="user" items="${userList}" >
             <!--forEach；繰り返し処理をする時に使う  items；ループする配列、または、コレクション var：itemから取り出した要素を格納する変数名 -->
         <tr>
           <td></td>
           <td>${user.loginId}</td>
           <td>${user.name}</td>
           <td>${user.birthDate}</td>
            <!-- TODO 未実装；ログインボタンの表示制御を行う -->
           <td>
             <a class="btn btn-primary" href="UserDetailServlet?id=${user.id}">詳細</a>
             <a class="btn btn-success" href="UserUpdateServlet?id=${user.id}">更新</a>
             <a class="btn btn-danger" href ="UserDeleteServlet?id=${user.id}">削除</a>
           </td>
         </tr>
       </c:forEach>
     </tbody>
    </table>
  </div>
</span>

</body>
</html>
