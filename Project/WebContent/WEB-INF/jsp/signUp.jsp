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

    <title>ユーザ新規登録</title>
  </head>
  <body>

    <ul class="nav justify-content-end bg-dark">
        <li class="nav-item">
            <a class="nav-link" href="UserListServlet">
            <font color="white">ユーザ名 さん</font>
            </a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="LogoutServlet">
            <font color="red">ログアウト</font>
            </a>
        </li>
    </ul>




          <div class="mx-auto" style="width: 200px;">

            		<div class="csontainer">
            			<div class="row main">
            				<div class="panel-heading">
            	               <div class="panel-title text-center">
            	               		<h1 class="title">Sign up</h1>
            	               		<hr />
            	               	</div>
            	            </div>
            				<div class="main-login main-center">
            					<form class="form-horizontal" method="post" action="UserListServlet">

            						<div class="form-group">
            							<label for="ID" class="cols-sm-2 control-label">LoginID</label>
            							<div class="cols-sm-10">
            								<div class="input-group">
            									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
            									<input type="text" class="form-control" ID="ID" id="ID"  placeholder="Enter your ID"/>
            								</div>
            							</div>
            						</div>

            						<div class="form-group">
            							<label for="password" class="cols-sm-2 control-label">Password</label>
            							<div class="cols-sm-10">
            								<div class="input-group">
            									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
            									<input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password"/>
            								</div>
            							</div>
            						</div>

            						<div class="form-group">
            							<label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
            							<div class="cols-sm-10">
            								<div class="input-group">
            									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
            									<input type="password" class="form-control" name="passConf" id="confirm"  placeholder="Confirm your Password"/>
            								</div>
            							</div>
            						</div>


                        <div class="form-group">
                          <label for="username" class="cols-sm-2 control-label">Username</label>
                          <div class="cols-sm-10">
                            <div class="input-group">
                              <span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
                              <input type="text" class="form-control" name="name" id="username"  placeholder="Enter your Username"/>
                            </div>
                          </div>
                        </div>


                        <div class="form-group">
            							<label for="email" class="cols-sm-2 control-label">Birthday</label>
            							<div class="cols-sm-10">
            								<div class="input-group">
            									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
            									<input type="date" class="form-control" name="birthDate"   placeholder="Enter your Birthday"/>
            								</div>
            							</div>
            						</div>


            						<div class="form-group ">
                          <a href="UserListServlet">
            							<button type="button" class="btn btn-primary btn-lg btn-block login-button" onClick="UserListServlet">Register</button>
                          </a>
            						</div>
                        <div class="login-register">
                        </div>

            					</form>
            				</div>
            			</div>
            		</div>

            		<script type="text/javascript" src="assets/js/bootstrap.js"></script>
          </div>

    </body>
  </html>

  <div style="margin-left:35%;margin-right:55%;">
    <a href="javascript:history.back();">戻る</a>
  </div>
