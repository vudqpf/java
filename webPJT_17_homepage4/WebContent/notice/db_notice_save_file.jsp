<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "dao.*, dto.*, common.*" %>
<%@ page import= "com.oreilly.servlet.*, java.io.*" %>	 
<%
	request.setCharacterEncoding("utf-8");			/*write.jsp에서 한글 넘어오기  때문에*/
	Notice_dao dao = new Notice_dao();
	
	String file_dir = Common.file_dir_notice;		/*Common.java에서 불러오는거!*/
	int sizeLimit = 1024 * 1024 * 10;				/*첨부파일 최대 사이즈 결정해주는 거 1024kbyte * 1024 * 1 =1MG*/
	MultipartRequest mpr = new MultipartRequest(request, file_dir, sizeLimit,"utf-8"); 	/*MultipartRequest는 com에 있어서 com은 cos.jar파일에 있음*/
	
	String no 			= dao.getNotiveNo();
	String title 		= mpr.getParameter("t_title");  /*MultipartRequest사용하면 request.getParameter이라곤 못씀!*/
	String content 		= mpr.getParameter("t_content");
	String reg_name 	= mpr.getParameter("t_reg_name");
	String reg_date 	= mpr.getParameter("t_reg_date");
	
	String attach 		= mpr.getFilesystemName("t_attach");	//타입이 파일인 건 getParameter로 못 받아옴
	String dbAttachName = "";
	if(attach != null){
		File oldFile = new File(file_dir, attach);			//경로, 첨부파일명
		File newFile = new File(file_dir, no+"-"+attach);	
		oldFile.renameTo(newFile);							//파일이름 바꾸기
		dbAttachName = newFile.getName();					//file_room에 attach파일에 no를 붙여서 저장하기 위해서
	}
	Notice_dto dto = new Notice_dto(no, title, content, dbAttachName, reg_name, reg_date,0);
	int result = dao.saveNotice(dto);
	String msg = "";
	if(result == 1) msg = "등록 되었습니다.";
	else msg = "등록 실패";

/*		
	String no = dao.getNotiveNo();							
	String title = request.getParameter("t_title");			//request는 보내는 form의 속성이 변했기 때문에
	String content = request.getParameter("t_content");		//사용불가!
	String attach = request.getParameter("t_attach");
	String reg_name = request.getParameter("t_reg_name");
	String reg_date = request.getParameter("t_reg_date");
*/

%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href = "notice_list.jsp"; //자바스크립트에서 페이지 넘겨줄 때 location.href
</script>
</head>
<body>

</body>
</html>