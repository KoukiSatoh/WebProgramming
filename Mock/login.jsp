<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- JSTL coreタグの利用宣言 -->


<!DOCTYPE html>
<html lang="ja">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="css/bootstrap.min.css">

  <title>ログイン画面</title>
</head>
<body>



<p class="text-center">
 <div class="modal-dialog">

  <c:if test="${errMsg != null}" >
    <div class="alert alert-danger" role="alert">
  ${errMsg}
  </div>
 </c:if>

 <form class="form-signin" action="LoginServlet" method="post">
    <div class="modal-content">

        <div class="modal-header">
          <h1 class="text-center">Login display</h1>
        </div>

         <div class="modal-body">
            <div class="form-group">
             <input type="text" name="login_id" id="inputlogin_id" class="form-control input-lg" placeholder="Username"  required autofocus>
            </div>

        <div class="form-group">
          <input type="password" name="password" id="inputpassword" class="form-control" placeholder="password"required>
       </div>

             <input type="submit" class="btn btn-block btn-lg btn-primary" value="Login"/>
       </div>
    </div>
  </form>
</div>



</body>
</html>
