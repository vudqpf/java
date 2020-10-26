﻿<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.io.*,common.*"%>
<%
    String savePath = "";
 	String fileName = request.getParameter("t_file");   //다운로드 받을 파일명
 	String gubun 	= request.getParameter("t_gubun");	//notice를 받아 와야 함

	if(gubun.equals("notice")) {
		savePath = Common.file_dir_notice;
	} else if(gubun.equals("")){
		savePath = "";
	}	
		
    String orgfilename = fileName ;
    InputStream in = null;
    OutputStream os = null;
    File file = null;
    boolean skip = false;
    String client = "";
  
    try{
        try{
            file = new File(savePath, fileName);
            in = new FileInputStream(file);
        }catch(FileNotFoundException fe){
            skip = true;
        }
        client = request.getHeader("User-Agent");
        response.reset() ;
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Description", "JSP Generated Data");
        if(!skip){
            // IE
            if(client.indexOf("MSIE") != -1){
                response.setHeader ("Content-Disposition", "attachment; filename="+orgfilename);
            }else{
                // 한글 파일명 처리
                orgfilename = new String(orgfilename.getBytes("utf-8"),"iso-8859-1");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + orgfilename + "\"");
                response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
            } 
            response.setHeader ("Content-Length", ""+file.length() );
            os = response.getOutputStream();
            byte b[] = new byte[(int)file.length()];
            int leng = 0;
            while( (leng = in.read(b)) > 0 ){
                os.write(b,0,leng);
            }
        }else{
            response.setContentType("text/html;charset=UTF-8");
            out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
        }
        in.close();
        os.close();
    }catch(Exception e){
      e.printStackTrace();
    }
%>


