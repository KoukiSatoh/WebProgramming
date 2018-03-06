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
    <title>ユーザ情報詳細参照</title>
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
    <p class="text-center">ユーザ情報詳細参照</p>
    </h1>

<div class="container">

    <form>
      <div class="form-group row">
        <label for="staticID" class="col-md-6  col-form-label">ログインID</label>
          <div class="col-md-4 col-md-offset-3">
            <input type="text" readonly class="form-control-plaintext" id="staticID" value="${user.loginId}">
          </div>
      </div>

  <form>
    <div class="form-group row">
        <label for="staticUserName" class="col-md-6  col-form-label">ユーザ名</label>
        <div class="col-md-4 col-md-offset-3">
            <input type="text" readonly class="form-control-plaintext" id="staticUserName" value="${user.name}">
          </div>
    </div>


    <div class="form-group row">
      <label for="staticiBrthday" class="col-md-6 col-form-label">生年月日</label>
      <div class="col-md-4 col-md-offset-3">
          <input type="text" readonly class="form-control-plaintext" id="staticBrthday" value="${user.birthDate}">
        </div>
    </div>


    <div class="form-group row">
      <label for="staticRegistration" class="col-md-6  col-form-label">登録日時</label>
      <div class="col-md-4 col-md-offset-3">
          <input type="text" readonly class="form-control-plaintext" id="staticRegistration" value="${user.createDate}">
      </div>
    </div>


    <div class="form-group row">
      <label for="staticUpdate" class="col-md-6  col-form-label">更新日時</label>
      <div class="col-md-4 col-md-offset-3">
          <input type="text" readonly class="form-control-plaintext" id="staticUpdate" value="${user.updateDate}">
      </div>
    </div>
  </div>
</form>


</body>
  </html>

  <div style="margin-left:10%;margin-right:55%;">
    <a href="UserListServlet">戻る</a>
  </div>
