package com.midas.websolution.menu.service;

import org.springframework.web.multipart.MultipartFile;

public interface MenuService {
	public void uploadFile(MultipartFile file, String file_path);
}
