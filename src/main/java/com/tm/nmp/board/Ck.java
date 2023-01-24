package com.tm.nmp.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Ck {

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value = "upload.do") public void
	 * communityImageUpload(HttpServletRequest req, HttpServletResponse resp,
	 * MultipartHttpServletRequest multiFile) throws Exception { JsonObject
	 * jsonObject = new JsonObject(); PrintWriter printWriter = null; OutputStream
	 * out = null; MultipartFile file = multiFile.getFile("upload");
	 * 
	 * if (file != null) { if (file.getSize() > 0 &&
	 * StringUtils.isNotBlank(file.getName())) { if
	 * (file.getContentType().toLowerCase().startsWith("image/")) { try {
	 * 
	 * String fileName = file.getOriginalFilename(); byte[] bytes = file.getBytes();
	 * 
	 * String uploadPath = req.getSession().getServletContext()
	 * .getRealPath("/resources/ckeditor/fileUpload"); // 저장경로
	 * System.out.println("uploadPath:" + uploadPath);
	 * 
	 * File uploadFile = new File(uploadPath); if (!uploadFile.exists()) {
	 * uploadFile.mkdir(); } String fileName2 = UUID.randomUUID().toString();
	 * uploadPath = uploadPath + "/" + fileName2 + fileName;
	 * 
	 * out = new FileOutputStream(new File(uploadPath)); out.write(bytes);
	 * 
	 * printWriter = resp.getWriter(); String fileUrl = req.getContextPath() +
	 * "/resources/ckeditor/fileUpload/" + fileName2 + fileName; // url경로
	 * System.out.println("fileUrl :" + fileUrl); JsonObject json = new
	 * JsonObject(); json.addProperty("uploaded", 1); json.addProperty("fileName",
	 * fileName); json.addProperty("url", fileUrl); printWriter.print(json);
	 * System.out.println(json);
	 * 
	 * } catch (IOException e) { e.printStackTrace(); } finally { if (out != null) {
	 * out.close(); } if (printWriter != null) { printWriter.close(); } } }
	 * 
	 * }
	 * 
	 * } }
	 */
	@RequestMapping(value = "upload.do")
	public ModelAndView image(@RequestParam Map<String, Object> map, MultipartHttpServletRequest request) {

		ModelAndView mv = new ModelAndView("jsonView");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String imageServerPath = null; // 서버경로
		String savePath = null; // 저장경로
		String originalImagename = null; // 원본이름
		String imageName = null; // 저장본이름
		String extension = null; // 확장자

		List<MultipartFile> imageList = request.getFiles("upload");
		for (MultipartFile mf : imageList) {
			if (imageList.get(0).getSize() > 0) {
				originalImagename = mf.getOriginalFilename(); // 원본 파일명
				extension = FilenameUtils.getExtension(originalImagename);
				imageName = "img_" + UUID.randomUUID() + "." + extension;

				savePath = "http://localhost:80/resources/files";
				System.out.println(savePath);

				File imageUpload = new File(savePath + imageName);
				try {
					mf.transferTo(imageUpload);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}
		}
		return mv;
	}
}
