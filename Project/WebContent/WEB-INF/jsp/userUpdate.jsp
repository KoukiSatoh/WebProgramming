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
    <title>ユーザ情報更新</title>
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
          <p class="text-center">ユーザ情報更新</p>
          </h1>

      <div class="container">


	  <c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
	   ${errMsg}
	    </div>
	 </c:if>

       <form  action="UserUpdateServlet" method="post">

<input  type="hidden"  name="id" value="${user.id}" >

        <div id="errorMessage"></div>
          <div class="form-group row">
            <label for="staticID" class="col-md-6  col-form-label">ログインID</label>
              <div class="col-md-4 col-md-offset-3">
                <input type="text" readonly class="form-control-plaintext" id="staticID" value="${user.loginId}">
              </div>
          </div>


          <div class="form-group row">
            <label for="password" class="col-md-6  col-form-label">パスワード</label>
            <div class="col-md-4 col-md-offset-3">
              <p><input required type="password"  name="password" size="30" ></p>
            </div>
          </div>


            <div class="form-group row">
              <label for="passwordConfirm" class="col-md-6  col-form-label">パスワード(確認)</label>
              <div class="col-md-4 col-md-offset-3">
                <p><input required type="password"  id ="passwordConfirm" name="passConf" size="30" ></p>
              </div>
            </div>


            <div class="form-group row">
                <label for="staticUserName" class="col-md-6  col-form-label">ユーザ名</label>
                <div class="col-md-4 col-md-offset-3">
                    <p><input type="text" name="name"  size="30" value="${user.name}"></p>
                </div>
            </div>


            <div class="form-group row">
              <label for="staticiBrthday" class="col-md-6 col-form-label">生年月日</label>
              <div class="col-md-5 col-md-offset-3">
                  <p><input required type="date" id ="staticiBrthday" name = "birthdate" size="30" value = "${user.birthDate}"></p>
                </div>
            </div>


            <div style="margin-left:38%;margin-right:38%;">
             <input type="submit" style="width:90%;padding:10px;font-size:15px;" value="更新" />
           </div>

        </form>


      </div>
    </div>




    </body>
</html>


<div style="margin-left:10%;margin-right:55%;">
  <a href="javascript:history.back();">戻る</a>
</div>
