<%-- 
    Document   : showTraCuu
    Created on : Sep 22, 2016, 2:06:44 PM
    Author     : phuoc
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.DanhBa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            table{
                margin: auto;
            }
            h1{
               text-align: center;
               
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Danh Sách Tra Cứu</h1>
       <table border=1 cellPadding=1 cellSpacing=1>
           
           <tr><th>STT</th><th>Tên Thêu Bao</th><th>Số Điện Thoại</th><th>Địa Chỉ</th></tr></br>
           <%
          ArrayList<DanhBa> list=(ArrayList)request.getAttribute("tenthuebao");
           for(int i=0;i<list.size();i++){   
           out.println("<tr><th>"+(i+1)+"</th><th>"+list.get(i).tentheubao+"</th><th>"+list.get(i).sdt+"</th><th>"+list.get(i).diachi+"</th></tr></br>");
           }
           %>
         
       </table>
    </body>
</html>
