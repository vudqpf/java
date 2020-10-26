<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*"%>
<%@ page import="com.oreilly.servlet.*, java.io.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Notice_dao dao = new Notice_dao();
	
	//String file_dir ="C:/Users/JSLHRD/Desktop/jsl43_홍길동/eclipse_source/webPJT_00_homepage4/WebContent/file_room/notice/";
	String file_dir = Common.file_dir_notice;
	int sizeLimit = 1024 * 1024 * 10;
	MultipartRequest mpr = new MultipartRequest(request,file_dir,sizeLimit,"utf-8");
	
	String no 		= mpr.getParameter("t_no"); 				//타입이 파일인 건 getParameter로 못 받아옴
	String title 	= mpr.getParameter("t_title"); 
	String content 	= mpr.getParameter("t_content"); 
	String reg_name = mpr.getParameter("t_reg_name"); 
	String reg_date = mpr.getParameter("t_reg_date"); 	

	String del_attach = mpr.getParameter("t_del_attach");
	String dbAttachName = "";
	if(del_attach != null){
		File delFile = new File(file_dir, del_attach);  		//첨부파일을 삭제하려면 file을 생성해야만 함!
		delFile.delete();
	}else{
		dbAttachName = mpr.getParameter("t_ori_attach");		//체크박스에 체크안하면 파일명 그대로 넘어옴
	}
	String attach 		= mpr.getFilesystemName("t_attach");	
	if(attach != null){											//attch가 널이 아니면 첨부파일이 있다!!
		String df = mpr.getParameter("t_ori_attach");
		if(!df.equals("null")){
			File delFile = new File(file_dir, df);  		//첨부파일을 삭제하려면 file을 생성해야만 함!
			delFile.delete();
		}
		
		File oldFile = new File(file_dir, attach);				//경로, 첨부파일명
		File newFile = new File(file_dir, no+"-"+attach);	
		oldFile.renameTo(newFile);								//파일이름 바꾸기  ex)N000_파일명
		dbAttachName = newFile.getName();						//file_room에 attach파일에 no를 붙여서 저장하기 위해서
	}
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>