<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ja">
<!-- headここから -->
  <head>
    <body>

    <!-- Bootstrap CSS 読み込み-->
    <link rel="stylesheet" href="css/bootstrap.min.css">
      <!-- オリジナルのCSS読み込み -->
    <link rel="stylesheet" type="text/css" href="signUp.css">
 　<!-- javascriptの読み込み -->
  <!--  <script type="text/javascript" src="assets/js/bootstrap.js"></script>-->

  </head>
<!-- headここまで -->

<!-- bodyここから -->
   <!-- ナビバーここから -->
    <nav class="navbar navbar-dark bg-dark">
      <a class="navbar-brand">
        <p class="text-light bg-dark ">ユーザー新規登録</p><!--  テキストの色を明るい色に変えている（白） -->
      </a>

      <ul class="nav justify-content-end bg-dark">
        <li class="nav-text">
            <a class="nav-link" href="UserDetailServlet">
            <font color="white">${userInfo.name} さん</font>
            </a>
          </li>

          <li class="nav-item">
            <a class="nav-link disabled" href="LogoutServlet">
             <button class="btn btn-outline-danger my-2 my-sm-0" type="submit" >
              <font color="red">ログアウト</font>
             </button>
           </a>
        </li>
      </ul>

  </nav><!-- ナビバーここまで -->

  <div class="mx-auto" style="width: 200px;"><!-- 中央揃え  -->


    <h1>
    <p class="text-center">Sign Up</p>
    </h1>

        <div class="panel-body"><!-- パネルのボディここから -->
          <form  action="SignUpServlet" method="post">　<!--フォームここから-->
               <fieldset class="form-group"><!-- フォームのグールプ化ここから（範囲内を枠線で囲む） -->
                　<!-- ログインID入力エリア -->
                    <div class="form-group">
                      <label>ログインID</label>
                        <input type="text" class="form-control form-control-sm" name="name" placeholder="login Id" size="25" maxlength="8"required><br>
                    </div>
                  <!-- パスワード入力エリア -->
                    <div class="form-group">
                      <label>パスワード</label>
                      <input type="password" class="form-control form-control-sm" name="encPass" placeholder="password" size="20" maxlength="8"required><br>
                    </div>
                  <!--　パスワード確認  -->
                  　<div class="form-group">
                      <label>パスワード(確認)</label>
                      <input type="password"class="form-control form-control-sm" name="encPassConf" placeholder="password Confirm" size="25" maxlength="8" required><br>
                    </div>
                  <!-- ユーザ名入力エリア -->
                    <div class="form-group">
                      <label>ユーザ名</label>
                      <input type="text" class="form-control form-control-sm" name="name" placeholder="User Name" size="25" maxlength="8" required><br>
                    </div>
                  <!-- 生年月日入力エリア -->
                    <div class="form-group">
                      <label>生年月日</label>
                      <input type="date" class="form-control form-control-sm" placeholder="Berth Day" size = "25" maxlength="8" required><br>
                    </div>

                     <button type="submit" class="btn btn-primary pull-right">Sign in</button>
                </fieldset><!-- フォームのグールプ化ここまで -->
          　  </form><!-- フォームここまで -->
        　  </div>
      	  </div>


 </body><!-- bodyここまで -->
</html>


  <div style="margin-left:35%;margin-right:55%;">
    <a href="">戻る</a>
      <!-- 一つ前のページに戻る -->
  </div>
