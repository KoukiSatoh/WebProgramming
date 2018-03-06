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
    <link rel="stylesheet" href="css/delete.css">
    <title>ユーザ削除確認</title>
    </head>
    <body>


      <ul class="nav justify-content-end bg-dark">
          <li class="nav-item">
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
    <p class="text-center">ユーザ削除確認</p>
    </h1>



    <div class="mx-auto" style="width: 300px;">

        <!-- Block level -->
      <div class="row">
        <p class="text-center">
        <div class="col-7 text-truncate"></div>
        </p>
      </div>

      <!-- Inline level -->
      <div class="row">
        <div class="col-12 text-truncate">を本当に削除してよろしいでしょうか。</div>
      </div>


     <span style="margin-left:%;margin-right:15%;">
         <input type="button" style="width:40%;padding:10px;font-size:15px;" value="キャンセル" onClick="location.href='UserListServlet'"/>
    </span>

     <span style="margin-left:%;margin-right:15%;">
         <input type="button" style="width:40%;padding:10px;font-size:15px;" value="OK"  onClick="location.href='UserListServlet'"/>

     </span>

  </div>


</body>
  </html>
