<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    

	<style type="text/css">
	
	.container{
		width: 792px;
	}
	.templatemo-contact-form{
	background: rgba(f,f,f,0.6);
	border-radius: 8px;
	color: rgb(197,197,197);
	max-width: 500px;
	margin: 30px auto 0 auto;
	padding: 0 30px 30px 30px;
	margin-left: 150px;
	}
	.male{
		margin-left: 50px;
	}
	.female{
		margin-left: 50px;
	}
	
	</style>
	
  </head>
  
  <body>
    <div >
      
		<div class="col-md-9">
			
			   <form class="form-horizontal templatemo-contact-form" role="form" action="#" method="post">
				   
				<div class="form-group">
					
						<h1 class="margin-bottom-15" style="color: black">基本信息</h1>
						
					
				</div>				
		        <div class="form-group">
		          		          	
		           
		            <div class="templatemo-input-icon-container">
		               <div class="col-md-3">
		             <label for="name" class="control-label" style="color: black;font-size: 13pt; padding-left: 20px" >用户名</label>
		               </div>
		               <div class="col-md-7">
		            	<input type="text" class="form-control" id="name" placeholder="" value='<s:property value="#session.doctorInUse.userName"/>'>
		               </div>		            		            		            
		          </div>              
		        </div>
		        <div class="form-group">
		          
		            
		            <div class="templatemo-input-icon-container">
		               <div class="col-md-3">
		            <label for="email" class="control-label" style="color: black;font-size: 13pt; padding-left: 15px">真实姓名</label>
		               </div>
		               <div class="col-md-7">
		            	<input type="email" class="form-control" id="email" placeholder="" value="罗亮">
		               </div>
		          </div>
		        </div>
		        <div class="form-group">
		          
		            
		            <div class="templatemo-input-icon-container">
		              <div class="col-md-3">
		            	<label for="website" class="control-label" style="color: black;font-size: 13pt; padding-left: 35px">密码</label>
		              </div>
		              <div class="col-md-7">	
		            	<input type="text" class="form-control" id="website" placeholder="" value="123456">
		              </div>
		            </div>
		          
		        </div>
		        <div class="form-group">
		          
		            
		            <div class="templatemo-input-icon-container">
		            	<div class="col-md-3">
		            	<label for="subject" class="control-label" style="color: black;font-size: 13pt; padding-left: 35px">性别</label>
		            	</div>
		            	<div class="col-md-7">
		            	  
		            	   <span class="male">
		            	    <input class="" type="radio" name="iCheck" checked>
		            	    <span  style="color: black;font-size: 15pt">男</span>
		            	   </span>
		            	 
		            	  <span class="female">
                          <input type="radio" name="iCheck" >
                          <span style="color: black;font-size: 15pt">女</span>
                          </span>
		            	
		               </div>
		            	
		            </div>
		          
		        </div>
		        <div class="form-group">
		          
		            
		            <div class="templatemo-input-icon-container">
		             <div class="col-md-3"> 
		            	<label for="subject" class="control-label" style="color: black;font-size: 13pt; padding-left: 35px">年龄 </label>
		             </div>	
		             <div class="col-md-7">
		            	<input type="text" class="form-control" id="subject" placeholder="" value="21">
		            </div>
		           </div> 
		          
		        </div>
		        <div class="form-group">
		          
		            
		            <div class="templatemo-input-icon-container">
		              <div class="col-md-3">
		            	<label for="subject" class="control-label" style="color: black;font-size: 13pt ; padding-left: 15px">联系电话</label>
		              </div>
		              <div class="col-md-8">	
		            	<input type="text" class="form-control" id="subject" placeholder="" value="15850160932">
		              </div>
		            </div>
		            
		          
		        </div>
		        <div class="form-group">
		          
		            
		            <div class="templatemo-input-icon-container">
		               <div class="col-md-3">
		            	<label for="subject" class="control-label" style="color: black;font-size: 13pt ; padding-left: 35px">地址</label>
		            	</div>
		            	<div class="col-md-8">
		            	<input type="text" class="form-control" id="subject" placeholder="" value="江苏省扬州市江都区">
		            	</div>
		            </div>
		          
		        </div>
		        
		        <div class="form-group">
		          
		            <input type="submit" value="完成修改" class="btn btn-success pull-right">
		          
		        </div>
		        	    	
		      </form>		
			</div>			
			</div>      
		
  </body>
</html>
