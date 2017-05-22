<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="<c:url value="/static/js/ckeditor/contents.css?t=H0CG"/>"/>
<link type="text/css" rel="stylesheet" href="<c:url value="/static/js/ckeditor/plugins/copyformatting/styles/copyformatting.css"/>" />
<style>
.cke_editable{cursor:text}.cke_editable img,.cke_editable input,.cke_editable textarea{cursor:default}
img.cke_flash{background-image: url("<c:url value="/static/js/ckeditor/plugins/flash/images/placeholder.png?t=H0CG"/>");background-position: center center;background-repeat: no-repeat;border: 1px solid #a9a9a9;width: 80px;height: 80px;}
.cke_editable form{border: 1px dotted #FF0000;padding: 2px;}
 
img.cke_hidden{background-image: url("<c:url value="/static/js/ckeditor/plugins/forms/images/hiddenfield.gif?t=H0CG"/>");background-position: center center;background-repeat: no-repeat;border: 1px solid #a9a9a9;width: 16px !important;height: 16px !important;}
img.cke_iframe{background-image: url("<c:url value="/static/js/ckeditor/plugins/iframe/images/placeholder.png?t=H0CG"/>");background-position: center center;background-repeat: no-repeat;border: 1px solid #a9a9a9;width: 80px;height: 80px;}
.cke_contents_ltr a.cke_anchor,.cke_contents_ltr a.cke_anchor_empty,.cke_editable.cke_contents_ltr a[name],.cke_editable.cke_contents_ltr a[data-cke-saved-name]{background:url("<c:url value="/static/js/ckeditor/plugins/link/images/anchor.png?t=H0CG"/>") no-repeat left center;border:1px dotted #00f;background-size:16px;padding-left:18px;cursor:auto;}.cke_contents_ltr img.cke_anchor{background:url("<c:url value="/static/js/ckeditor/plugins/link/images/anchor.png?t=H0CG"/>") no-repeat left center;border:1px dotted #00f;background-size:16px;width:16px;min-height:15px;height:1.15em;vertical-align:text-bottom;}.cke_contents_rtl a.cke_anchor,.cke_contents_rtl a.cke_anchor_empty,.cke_editable.cke_contents_rtl a[name],.cke_editable.cke_contents_rtl a[data-cke-saved-name]{background:url("<c:url value="/static/js/ckeditor/plugins/link/images/anchor.png?t=H0CG"/>") no-repeat right center;border:1px dotted #00f;background-size:16px;padding-right:18px;cursor:auto;}.cke_contents_rtl img.cke_anchor{background:url("<c:url value="/static/js/ckeditor/plugins/link/images/anchor.png?t=H0CG"/>") no-repeat right center;border:1px dotted #00f;background-size:16px;width:16px;min-height:15px;height:1.15em;vertical-align:text-bottom;}
div.cke_pagebreak{background:url("<c:url value="/static/js/ckeditor/plugins/pagebreak/images/pagebreak.gif?t=H0CG"/>") no-repeat center center !important;clear:both !important;width:100% !important;border-top:#999 1px dotted !important;border-bottom:#999 1px dotted !important;padding:0 !important;height:7px !important;cursor:default !important;}
.cke_show_blocks h6:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks h5:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks h4:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks h3:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks h2:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks h1:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks blockquote:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks address:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks pre:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks div:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks p:not([contenteditable=false]):not(.cke_show_blocks_off){background-repeat:no-repeat;border:1px dotted gray;padding-top:8px}.cke_show_blocks h6:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_h6.png?t=H0CG"/>")}.cke_show_blocks h5:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_h5.png?t=H0CG"/>")}.cke_show_blocks h4:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_h4.png?t=H0CG"/>")}.cke_show_blocks h3:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_h3.png?t=H0CG"/>")}.cke_show_blocks h2:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_h2.png?t=H0CG"/>")}.cke_show_blocks h1:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_h1.png?t=H0CG"/>")}.cke_show_blocks blockquote:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_blockquote.png?t=H0CG"/>")}.cke_show_blocks address:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_address.png?t=H0CG"/>")}.cke_show_blocks pre:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_pre.png?t=H0CG"/>")}.cke_show_blocks div:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_div.png?t=H0CG"/>")}.cke_show_blocks p:not([contenteditable=false]):not(.cke_show_blocks_off){background-image:url("<c:url value="/static/js/ckeditor/plugins/showblocks/images/block_p.png?t=H0CG"/>")}.cke_show_blocks.cke_contents_ltr h6:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr h5:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr h4:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr h3:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr h2:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr h1:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr blockquote:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr address:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr pre:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr div:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_ltr p:not([contenteditable=false]):not(.cke_show_blocks_off){background-position:top left;padding-left:8px}.cke_show_blocks.cke_contents_rtl h6:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl h5:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl h4:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl h3:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl h2:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl h1:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl blockquote:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl address:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl pre:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl div:not([contenteditable=false]):not(.cke_show_blocks_off),.cke_show_blocks.cke_contents_rtl p:not([contenteditable=false]):not(.cke_show_blocks_off){background-position:top right;padding-right:8px}
.cke_show_borders  table.cke_show_border,.cke_show_borders  table.cke_show_border > tr > td, .cke_show_borders  table.cke_show_border > tr > th,.cke_show_borders  table.cke_show_border > tbody > tr > td, .cke_show_borders  table.cke_show_border > tbody > tr > th,.cke_show_borders  table.cke_show_border > thead > tr > td, .cke_show_borders  table.cke_show_border > thead > tr > th,.cke_show_borders  table.cke_show_border > tfoot > tr > td, .cke_show_borders  table.cke_show_border > tfoot > tr > th{border : #d3d3d3 1px dotted}
</style>
</head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<c:url value ="/static/css/common.css"/>"/>
<title>기본 게시판^-^</title>
</head>
	
	<div id="login-header">
	
		<c:if test="${empty sessionScope._USER_}">
			 <jsp:include page="/WEB-INF/view/user/signIn.jsp"></jsp:include>	
		</c:if>
		<c:if test="${not empty sessionScope._USER_}">
			 <span> ${sessionScope._USER_.userName}님, 환영합니다.! </span>
			 <a href="<c:url value="/club/logout"/>"> 로그 아웃 </a>
		</c:if>
			
	</div>
	

<body class="cke_contents_ltr cke_show_borders">
	<jsp:include page="/WEB-INF/view/common/menu.jsp"></jsp:include>
		
	<div id="content">
		<h1>
			<c:forEach items="${currentMenu}" var="currentMenuItem" varStatus="index">
				${currentMenuItem.menuName} 
				<c:if test="${!index.last}"> 
				 	>
				</c:if>
			</c:forEach>
		</h1> 
		<table>
		
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:if test="${empty clubList}">
			<tr>
				<td colspan="5">등록된 게시글이 존재하지 않습니다 </td>
			</tr>
			</c:if>
			<c:forEach items="${clubList}" var="club">
				<tr>
					<td>${club.articleId}</td>
					<td><a href="<c:url value="/club/read/${club.menuVO.menuId}/${club.articleId}"/>">${club.subject}</a>
						(${club.repliesCount})
					</td>
					<td>${club.memberVO.nickName}</td>
					<td>${club.createdDate}</td>
					<td>${club.readCount}</td>
				</tr>
			</c:forEach>
		</table>

	<form id="searchForm">
		${pager} <br/>
		
		<%-- <select name = "searchType">
			<option value='1' ${sessionScope._SEARCH_.searchType == 1 ? 'selected' : false }>제목 + 내용</option>
			<option value='2' ${sessionScope._SEARCH_.searchType == 2 ? 'selected' : false }>제목</option>
			<option value='3' ${sessionScope._SEARCH_.searchType == 3 ? 'selected' : false }>내용</option>
		</select>
		
		<input type="text" name="searchKeyword" value="${sessionScope._SEARCH_.searchKeyword}"/>
		<input type="button" value="Search" onclick="movePage(0)"/>
		<input type="submit" value="검색 초기화" onclick="location.href='<c:url value="/club/${menuId}/init"/>';"/> --%>
	</form>
	
	</div>
	
	<div class="controls">
			<a href="<c:url value="/club/write/${menuId}"/>"> 쓰기 </a>
	</div>

</body>
</html>