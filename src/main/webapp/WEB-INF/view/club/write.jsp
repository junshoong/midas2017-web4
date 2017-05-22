<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = 'c' uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/static/js/jquery-3.1.1.min.js"/>"> </script>
<script src="<c:url value="/static/js/ckeditor/ckeditor.js"/>"> </script>
<script type="text/javascript">
	$().ready(function() {
		$("#saveBtn").click(function() {
			$("#writeForm").attr({
				"method" : "POST",
				"action" : "<c:url value="/club/write/${menuId}"/>"
			});
			$("#writeForm").submit();
		});
	});

</script>
<title>Insert title here</title>
</head>
<body>
	 <form id="writeForm">
	 		<input type="text" name="subject" id="subject"/>
            <textarea name="content" id="editor1" rows="10" cols="80">
                This is my textarea to be replaced with CKEditor.
            </textarea>
            <script>
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace( 'content' );
            </script>
        </form>
		<div id="uploadFiles"></div>
		<div>
			<form target="uploadFrame"
					method="post" action="<c:url value="/club/upload"/>"
					enctype="multipart/form-data" >
			<input type="file" name="file" />
			<input type="submit" value="Upload" />
			</form>
			<iframe name="uploadFrame" style="display: none;"></iframe>
		</div>
  
        
        <input type="button" id="saveBtn" value="Save" />
        <input type="button" id="cancelBtn" value="Cancel" />	
</body>
</html>