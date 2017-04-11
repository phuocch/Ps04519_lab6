<%-- 
    Document   : index
    Created on : Sep 19, 2016, 2:42:06 PM
    Author     : phuoc
--%>

<%@page import="Model.DanhBa"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <style>
            body{
                
                
            }
            form{
                background-color:activeborder;
                margin: auto;
                width:350px;
                height:260px;
                border: 5px solid royalblue;
            }
            div{
                margin-top: 20px;
                margin-left: 20px;
         
            }
            h2
            {
               margin-top: 20px;
               margin-left: 60px;
            }
            a{
               margin-top: 20px;
               margin-left:20px;
               
            }
          
            
            
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tra Cứu Danh Bạ</title>
    </head>
    <body>
       
            <form action="SearchServlet" >
                <h2>Tra Danh Bạ Điện Thoại</h2>
                <div>Nhập Tên Thêu Bao <input type="text" name="txtHoten"></div><br>
                <div> Nhập Số Điện Thoại <input type="text" name="txtSdt"></div><br>
                <div> Nhập địa Chỉ Khách <input type="text" name="txtDiachi"></div><br>
             
                <a><input type="submit" name="submit" value="Search"></a>
                <a><input type="submit" name="submit" value="Insert"></a>
               
            </form>
    </body>
</html>
