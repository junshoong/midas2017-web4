package com.midas.websolution.common;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DownloadController implements ApplicationContextAware {

	private WebApplicationContext context = null;

	@RequestMapping("/board/download/{fileFiled}")
	public ModelAndView download(@PathVariable String fileField, HttpServletResponse response) throws IOException {

		File downloadFile = getFile(fileField);
		
		System.out.println("test");
		
		if (downloadFile == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}

		return new ModelAndView("download", "downloadFile", downloadFile);
	}
	
	private File getFile(String fileField) {
		/*
		 * 원래는 DB에 접속해서 FileName 으로 FilePath 전체를 가져와야 함.
		 * fileFiled 즉, @PathVariable 에는 "." 이 포함될 수 없으므로
		 * DB에 저장할 때 "."을 다른 특수문자로 치환해주어야 한다.
		 */
		if(fileField.equals("1")) {
			return new File("c:\\logFile1.log");
		}

		return null;
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.context = (WebApplicationContext) applicationContext;
	}
}
