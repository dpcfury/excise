<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>社区居民健康管理系统医生端</title>
  </head>
  
  <body>
  
    <form class="form-horizontal">
    <fieldset>
      <div id="legend" class="">
        <legend class="">社区居民健康管理系统</legend>
      </div>
    <div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">用户名：</label>
          <div class="controls">
            <input type="text" placeholder="用户名" class="input-xlarge">
            <p class="help-block">输入您的用户名</p>
          </div>
        </div>

    <div class="control-group">

          <!-- Search input-->
          <label class="control-label">口令：</label>
          <div class="controls">
            <input type="text" placeholder="口令" class="input-xlarge search-query">
            <p class="help-block">输入您的密码</p>
          </div>

        </div>

    

    <div class="control-group">
          <label class="control-label"></label>

          <!-- Button -->
          <div class="controls">
            <button class="btn btn-success">确认</button>
          </div>
        </div>

    <div class="control-group">
          <label class="control-label"></label>

          <!-- Button -->
          <div class="controls">
            <button class="btn btn-warning">取消</button>
          </div>
        </div>

    </fieldset>
  </form>
  
  
  </body>
</html>
