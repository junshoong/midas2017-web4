<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/static/js/ckeditor/contents.css?t=H0CG"/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/static/js/ckeditor/plugins/copyformatting/styles/copyformatting.css"/>" />
<style>
.cke_editable {
	cursor: text
}

.cke_editable img, .cke_editable input, .cke_editable textarea {
	cursor: default
}

img.cke_flash {
	background-image: url("<c:url value="/ static/ js/ ckeditor/ plugins/ flash/ images/
		placeholder.png ? t = H0CG "/>");
	background-position: center center;
	background-repeat: no-repeat;
	border: 1px solid #a9a9a9;
	width: 80px;
	height: 80px;
}

.cke_editable form {
	border: 1px dotted #FF0000;
	padding: 2px;
}

img.cke_hidden {
	background-image: url("<c:url value="/ static/ js/ ckeditor/ plugins/ forms/ images/
		hiddenfield.gif ? t = H0CG "/>");
	background-position: center center;
	background-repeat: no-repeat;
	border: 1px solid #a9a9a9;
	width: 16px !important;
	height: 16px !important;
}

img.cke_iframe {
	background-image: url("<c:url value="/ static/ js/ ckeditor/ plugins/ iframe/ images/
		placeholder.png ? t = H0CG "/>");
	background-position: center center;
	background-repeat: no-repeat;
	border: 1px solid #a9a9a9;
	width: 80px;
	height: 80px;
}

.cke_contents_ltr a.cke_anchor, .cke_contents_ltr a.cke_anchor_empty,
	.cke_editable.cke_contents_ltr a[name], .cke_editable.cke_contents_ltr a[data-cke-saved-name]
	{
	background: url("<c:url value="/ static/ js/ ckeditor/ plugins/ link/ images/
		anchor.png ? t = H0CG "/>") no-repeat left center;
	border: 1px dotted #00f;
	background-size: 16px;
	padding-left: 18px;
	cursor: auto;
}

.cke_contents_ltr img.cke_anchor {
	background: url("<c:url value="/ static/ js/ ckeditor/ plugins/ link/ images/
		anchor.png ? t = H0CG "/>") no-repeat left center;
	border: 1px dotted #00f;
	background-size: 16px;
	width: 16px;
	min-height: 15px;
	height: 1.15em;
	vertical-align: text-bottom;
}

.cke_contents_rtl a.cke_anchor, .cke_contents_rtl a.cke_anchor_empty,
	.cke_editable.cke_contents_rtl a[name], .cke_editable.cke_contents_rtl a[data-cke-saved-name]
	{
	background: url("<c:url value="/ static/ js/ ckeditor/ plugins/ link/ images/
		anchor.png ? t = H0CG "/>") no-repeat right center;
	border: 1px dotted #00f;
	background-size: 16px;
	padding-right: 18px;
	cursor: auto;
}

.cke_contents_rtl img.cke_anchor {
	background: url("<c:url value="/ static/ js/ ckeditor/ plugins/ link/ images/
		anchor.png ? t = H0CG "/>") no-repeat right center;
	border: 1px dotted #00f;
	background-size: 16px;
	width: 16px;
	min-height: 15px;
	height: 1.15em;
	vertical-align: text-bottom;
}

div.cke_pagebreak {
	background: url("<c:url value="/ static/ js/ ckeditor/ plugins/ pagebreak/ images/
		pagebreak.gif ? t = H0CG "/>") no-repeat center center !important;
	clear: both !important;
	width: 100% !important;
	border-top: #999 1px dotted !important;
	border-bottom: #999 1px dotted !important;
	padding: 0 !important;
	height: 7px !important;
	cursor: default !important;
}

.cke_show_blocks h6:not ([contenteditable=false] ):not (.cke_show_blocks_off
	), .cke_show_blocks h5:not ([contenteditable=false] ):not (.cke_show_blocks_off
	), .cke_show_blocks h4:not ([contenteditable=false] ):not (.cke_show_blocks_off
	), .cke_show_blocks h3:not ([contenteditable=false] ):not (.cke_show_blocks_off
	), .cke_show_blocks h2:not ([contenteditable=false] ):not (.cke_show_blocks_off
	), .cke_show_blocks h1:not ([contenteditable=false] ):not (.cke_show_blocks_off
	), .cke_show_blocks blockquote:not ([contenteditable=false] ):not (.cke_show_blocks_off
	), .cke_show_blocks address:not ([contenteditable=false] ):not (.cke_show_blocks_off
	), .cke_show_blocks pre:not ([contenteditable=false] ):not (.cke_show_blocks_off
	), .cke_show_blocks div:not ([contenteditable=false] ):not (.cke_show_blocks_off
	), .cke_show_blocks p:not ([contenteditable=false] ):not (.cke_show_blocks_off
	){
	background-repeat: no-repeat;
	border: 1px dotted gray;
	padding-top: 8px
}

.cke_show_blocks h6:not ([contenteditable=false] ):not (.cke_show_blocks_off
	){
	background-image: url("<c:url value="/ static/ js/ ckeditor/ plugins/ showblocks/ images/
		block_h6.png ? t = H0CG "/>")
}

.cke_show_blocks h5:not ([contenteditable=false] ):not (.cke_show_blocks_off
	){
	background-image: url("<c:url value="/ static/ js/ ckeditor/ plugins/ showblocks/ images/
		block_h5.png ? t = H0CG "/>")
}

.cke_show_blocks h4:not ([contenteditable=false] ):not (.cke_show_blocks_off
	){
	background-image: url("<c:url value="/ static/ js/ ckeditor/ plugins/ showblocks/ images/
		block_h4.png ? t = H0CG "/>")
}

.cke_show_blocks h3:not ([contenteditable=false] ):not (.cke_show_blocks_off
	){
	background-image: url("<c:url value="/ static/ js/ ckeditor/ plugins/ showblocks/ images/
		block_h3.png ? t = H0CG "/>")
}

.cke_show_blocks h2:not ([contenteditable=false] ):not (.cke_show_blocks_off
	){
	background-image: url("<c:url value="/ static/ js/ ckeditor/ plugins/ showblocks/ images/
		block_h2.png ? t = H0CG "/>")
}

.cke_show_blocks h1:not ([contenteditable=false] ):not (.cke_show_blocks_off
	){
	background-image: url("<c:url value="/ static/ js/ ckeditor/ plugins/ showblocks/ images/
		block_h1.png ? t = H0CG "/>")
}

.cke_show_blocks blockquote:not ([contenteditable=false] ):not (.cke_show_blocks_off
	){
	background-image: url("<c:url value="/ static/ js/ ckeditor/ plugins/ showblocks/ images/
		block_blockquote.png ? t = H0CG "/>")
}

.cke_show_blocks address:not ([contenteditable=false] ):not (.cke_show_blocks_off
	){
	background-image: url("<c:url value="/ static/ js/ ckeditor/ plugins/ showblocks/ images/
		block_address.png ? t = H0CG "/>")
}

.cke_show_blocks pre:not ([contenteditable=false] ):not (.cke_show_blocks_off
	){
	background-image: url("<c:url value="/ static/ js/ ckeditor/ plugins/ showblocks/ images/
		block_pre.png ? t = H0CG "/>")
}

.cke_show_blocks div:not ([contenteditable=false] ):not (.cke_show_blocks_off
	){
	background-image: url("<c:url value="/ static/ js/ ckeditor/ plugins/ showblocks/ images/
		block_div.png ? t = H0CG "/>")
}

.cke_show_blocks p:not ([contenteditable=false] ):not (.cke_show_blocks_off
	){
	background-image: url("<c:url value="/ static/ js/ ckeditor/ plugins/ showblocks/ images/
		block_p.png ? t = H0CG "/>")
}

.cke_show_blocks.cke_contents_ltr h6:not ([contenteditable=false] ):not
	(.cke_show_blocks_off ), .cke_show_blocks.cke_contents_ltr h5:not ([contenteditable=false]
	):not (.cke_show_blocks_off ), .cke_show_blocks.cke_contents_ltr h4:not
	([contenteditable=false] ):not (.cke_show_blocks_off ),
	.cke_show_blocks.cke_contents_ltr h3:not ([contenteditable=false] ):not
	(.cke_show_blocks_off ), .cke_show_blocks.cke_contents_ltr h2:not ([contenteditable=false]
	):not (.cke_show_blocks_off ), .cke_show_blocks.cke_contents_ltr h1:not
	([contenteditable=false] ):not (.cke_show_blocks_off ),
	.cke_show_blocks.cke_contents_ltr blockquote:not ([contenteditable=false]
	):not (.cke_show_blocks_off ), .cke_show_blocks.cke_contents_ltr address:not
	([contenteditable=false] ):not (.cke_show_blocks_off ),
	.cke_show_blocks.cke_contents_ltr pre:not ([contenteditable=false] ):not
	(.cke_show_blocks_off ), .cke_show_blocks.cke_contents_ltr div:not ([contenteditable=false]
	):not (.cke_show_blocks_off ), .cke_show_blocks.cke_contents_ltr p:not
	([contenteditable=false] ):not (.cke_show_blocks_off ){
	background-position: top left;
	padding-left: 8px
}

.cke_show_blocks.cke_contents_rtl h6:not ([contenteditable=false] ):not
	(.cke_show_blocks_off ), .cke_show_blocks.cke_contents_rtl h5:not ([contenteditable=false]
	):not (.cke_show_blocks_off ), .cke_show_blocks.cke_contents_rtl h4:not
	([contenteditable=false] ):not (.cke_show_blocks_off ),
	.cke_show_blocks.cke_contents_rtl h3:not ([contenteditable=false] ):not
	(.cke_show_blocks_off ), .cke_show_blocks.cke_contents_rtl h2:not ([contenteditable=false]
	):not (.cke_show_blocks_off ), .cke_show_blocks.cke_contents_rtl h1:not
	([contenteditable=false] ):not (.cke_show_blocks_off ),
	.cke_show_blocks.cke_contents_rtl blockquote:not ([contenteditable=false]
	):not (.cke_show_blocks_off ), .cke_show_blocks.cke_contents_rtl address:not
	([contenteditable=false] ):not (.cke_show_blocks_off ),
	.cke_show_blocks.cke_contents_rtl pre:not ([contenteditable=false] ):not
	(.cke_show_blocks_off ), .cke_show_blocks.cke_contents_rtl div:not ([contenteditable=false]
	):not (.cke_show_blocks_off ), .cke_show_blocks.cke_contents_rtl p:not
	([contenteditable=false] ):not (.cke_show_blocks_off ){
	background-position: top right;
	padding-right: 8px
}

.cke_show_borders  table.cke_show_border, .cke_show_borders  table.cke_show_border>tr>td,
	.cke_show_borders  table.cke_show_border>tr>th, .cke_show_borders  table.cke_show_border>tbody>tr>td,
	.cke_show_borders  table.cke_show_border>tbody>tr>th, .cke_show_borders  table.cke_show_border>thead>tr>td,
	.cke_show_borders  table.cke_show_border>thead>tr>th, .cke_show_borders  table.cke_show_border>tfoot>tr>td,
	.cke_show_borders  table.cke_show_border>tfoot>tr>th {
	border: #d3d3d3 1px dotted
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"> </script>
<script type="text/javascript">

$().ready(function() {
	
	
	$().on("click","#u_cbox_txt_upload_submitCmt", function() {
		
		var isCheckReReply = $(this).parent().parent().parent().parent("div").attr('class');
		var value = $(this).parent().parent().parent().parent("div").siblings('.replyinfo').children('.oneMoreReply').children('.replyId').attr('value');
		
	
		$.post("<c:url value="/club/reply/write/"/>", {
			"parentReplyId" : value,
			"articleId" : $("#articleId").val() ,
			"content" : $("#comment_text").val()
			
		}, function(response) {
			if(response.SUCCESS == "YES") {
				location.reload();
			}
			
			else{
				alert("FAIL");
			}
				
		});
		
	});
	
 	
	$("#reply").find("a").click(function() {
		
		var thisReplyForm = $(this).closest("div").parent().parent('div').children("div");
		var table = $(".cminput").html();
		
		if(thisReplyForm.attr('value') != 'true')
		{
			thisReplyForm.attr("value","true");
			thisReplyForm.append(table);
		}
		
		else {
			thisReplyForm.attr("value","false");
			thisReplyForm.empty();
		}
	}); 
	
	
	$(".ReReply").find(".replyLikeCount").click(function() {
		
		var replyId = $(this).siblings('.oneMoreReply').children('.replyId').attr('value');
		
		alert(replyId);
		
		$.post("<c:url value="/club/reply/count/"/>" + replyId, {

		}, function(response) {
			if(response.SUCCESS == "YES") {
				location.reload();
			}
			
			else{
				alert("FAIL");
			}
		});
	});
	
	
});

</script>

</head>
<body class="cke_contents_ltr cke_show_borders">

	<jsp:include page="/WEB-INF/view/common/menu.jsp"></jsp:include>


	<h1>
		<c:forEach items="${currentMenu}" var="currentMenuItem"
			varStatus="index">
				${currentMenuItem.menuName} 
				<c:if test="${!index.last}"> 
				 	>
				</c:if>
		</c:forEach>
	</h1>

	<div class="detail">

		<h1>${club.subject}</h1>

		<hr />
		<div class="club">
			<span>${club.createdDate}</span> / <span>${club.readCount}</span>
		</div>
		<br />
		<p>${club.content}</p>
		<hr />


		<hr />

		<div id="reply">
			<c:set var="depth" value="0" />
			<input id="articleId" type = "hidden" value="${club.articleId}"/>
			<ul>
				<c:forEach items="${club.replyVO}" var="reply">
					<c:if test="${reply.level < prevLevel}">
						<c:forEach var="i" begin="0" end="${(prevLevel- reply.level) -1 }"
							step="1">
							<c:set var="depth" value="${depth - 1}" />
			</ul>
			</c:forEach>
			</c:if>
			<c:if test="${reply.level > prevLevel}">
				<c:set var="depth" value="${depth + 1}" />
				<ul>
			</c:if>
			
			<div class="ReReply">
				<li class="filter-30 board-box-line-dashed" style="border-bottom-width: 1px; border-bottom-style: dotted;"></li>
				<li class="replyinfo">${reply.memberId}  ${reply.createdDate} 
					좋아요 <span class="replyLikeCount"> ${reply.recommendCount} </span>
					<div class="oneMoreReply">
						<input class="replyId" type="hidden" value="${reply.replyId}"/>
						<input class="parentReplyId" type="hidden" value="${reply.parentReplyId}"/>
						<a class="oneMoreReply"> 답글  </a> 
					</div> 
				</li>   
				<li>${reply.content}</li>
				<li class="filter-30 board-box-line-dashed" style="border-bottom-width: 1px; border-bottom-style: dotted;"></li>
				<div class="ReReplyAppend"></div>
			</div>
			
			<c:set var="prevLevel" value="${reply.level}" />
			</c:forEach>
			</ul>
			<c:if test="${depth > 0}">
				<c:forEach var="i" begin="0" end="${depth}" step="1">
					</ul>
				</c:forEach>
			</c:if>
		</div>
		
		
		<table cellspacing="0" id="replyInput" class="cminput">
				<tbody>
				<tr>
					<td class="i1">
					<div class="reply-write-ico" id="refCmt_emoticon">
  						<img src="http://itemimgs.naver.net/personacon/7/21/1202107.gif" style="cursor:pointer;" width="19" height="19" alt="" class="myemoticon">
					</div>																																	
					<span style="display:none;"></span>						
					</td>
					<td class="i2">
						<div class="comm_write_wrap border-sub skin-bgcolor">
							<textarea id="comment_text" cols="50" rows="2" class="textarea m-tcol-c" maxlength="6000" style="overflow: hidden; line-height: 14px; height: 41px;" title="댓글입력"></textarea>
							
 							<div class="u_cbox_upload_image" style="display:none"></div>
						</div>
					</td>
					<td class="i3">
						
						
						<input type="button" id="u_cbox_txt_upload_submitCmt" value="등록">
						
					</td>
				</tr>
				<tr>
					<td colspan="3"></td>
				</tr>
				</tbody>
		</table>

<script type="text/javascript"> 
function borderBoxModel(elements, value) { 
     var element, cs, s, width, height; 
     // cicle through all DOM elements 
     for (var i=0, max=elements.length; i < max; i++) { 
             element = elements[i]; 
             s = element.style; 
             cs = element.currentStyle; 
             // check if box-sizing is specified and is equal to border-box 
             if(s.boxSizing == value || s["box-sizing"] == value 
                     || cs.boxSizing == value || cs["box-sizing"] == value) { 
                     // change width and height 
                     try { 
                     apply(); 
                     } catch(e) {} 
             } 
     } 
     function apply() { 
             width = parseInt(cs.width, 10) || parseInt(s.width, 10); 
             height = parseInt(cs.height, 10) || parseInt(s.height, 10); 
             // if width is declared (and not 'auto','',...) 
             if(width) { 
                     var // border value could be 'medium' so parseInt returns NaN 
                     borderLeft = parseInt(cs.borderLeftWidth || s.borderLeftWidth, 10) || 0, 
                     borderRight = parseInt(cs.borderRightWidth || s.borderRightWidth, 10) || 0, 
                     paddingLeft = parseInt(cs.paddingLeft || s.paddingLeft, 10), 
                     paddingRight = parseInt(cs.paddingRight || s.paddingRight, 10), 
                     horizSum = borderLeft + paddingLeft + paddingRight + borderRight; 

                     // remove from width padding and border two times if != 0 
                     if(horizSum) { 
                     s.width = width - horizSum; //width ? width - horizSum * 2 : styleWidth - horizSum; 
                     } 
             } 
             // if height is declared (and not 'auto','',...) 
             if(height) { 
                     var // border value could be 'medium' so parseInt returns NaN 
                     borderTop = parseInt(cs.borderTopWidth || s.borderTopWidth, 10) || 0, 
                     borderBottom = parseInt(cs.borderBottomWidth || s.borderBottomWidth, 10) || 0, 
                     paddingTop = parseInt(cs.paddingTop || s.paddingTop, 10), 
                     paddingBottom = parseInt(cs.paddingBottom || s.paddingBottom, 10), 
                     vertSum = borderTop + paddingTop + paddingBottom + borderBottom; 

                     // remove from height padding and border two times if != 0 
                     if(vertSum) { 
                     s.height = height - vertSum; //height ? height - vertSum * 2 : styleHeight - vertSum; 
                     } 
             } 
     } 
}

try{
	
	if(typeof document.documentMode !== 'undefined' && document.documentMode < 8 && document.documentMode > 5){ 
	borderBoxModel(cssquery(".line_tooltip,.se2_line_sticker_set,.se2_naver_line_link_layer,.se2_naver_line_box1,.se2_naver_line_box2 input"), 'border-box');
	} 
}catch(e){}

</script>
				
		
		
		<div class="controls">
			<a href="<c:url value="/club/modify/${board.boardId}"/>">수정 </a> | <a
				href="<c:url value="/club/delete/${board.boardId}"/>">삭제 </a> | <a
				href="<c:url value="/club/${menuId}"/>"> 목록보기 </a>
		</div>
	</div>

</body>
</html>