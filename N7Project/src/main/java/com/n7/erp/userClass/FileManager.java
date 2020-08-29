package com.n7.erp.userClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.n7.erp.dao.IMemberDao;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileManager {

	@Autowired
	private IMemberDao mDao;
	// 파일 경로(다운로드/삭제에서 사용)
	String fullPath = "D:/SpringWork/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/N7Project/";

	public String fileUp(MultipartHttpServletRequest multi) {
		System.out.println("fileUp");
		// 1.이클립스의 물리적 저장경로 찾기
		String root = multi.getSession().getServletContext().getRealPath("/");
		System.out.println("root=" + root);
		String path = root + "upload/";
		// 2.폴더 생성을 꼭 할것...
		System.out.println("(fileup)PATH : " + path);
		File dir = new File(path);
		if (!dir.isDirectory()) { // upload폴더 없다면
			dir.mkdir(); // upload폴더 생성
		}

		// 3.파일을 가져오기-파일태그가 여러개 일때 이름들 반환
//		  Iterator<String> files=multi.getFileNames(); //파일태그가 2개이상일때
//		  
//		  Map<String,String> fMap=new HashMap<String, String>();
//		  fMap.put("bnum", String.valueOf(bnum));
//		  boolean f=false;
//		  while(files.hasNext()){
//			  String fileTagName=files.next();
//			  System.out.println("fileTag="+fileTagName); //파일  메모리에 저장 
//			  MultipartFile mf=multi.getFile(fileTagName); //실제파일 
//			  String oriFileName=mf.getOriginalFilename(); //a.txt 
//			  fMap.put("oriFileName", oriFileName); //4.시스템파일이름 생성 a.txt ==>112323242424.txt
//			  String sysFileName=System.currentTimeMillis()+"."
//			            +oriFileName.substring(oriFileName.lastIndexOf(".")+1);
//			  fMap.put("sysFileName", sysFileName);
//			  
//		  }

		// 3.파일을 가져오기-파일태그가 1개 일때
		List<MultipartFile> fList = multi.getFiles("m_photo");
		boolean f = false;
		for (int i = 0; i < fList.size(); i++) {
			// 파일 메모리에 저장
			MultipartFile mf = fList.get(i); // 실제파일
			String oriFileName = mf.getOriginalFilename(); // a.txt
			// 4.시스템파일이름 생성 a.txt ==>112323242424.txt
			String sysFileName = System.currentTimeMillis() + "."
					+ oriFileName.substring(oriFileName.lastIndexOf(".") + 1);
			// 5.메모리->실제 파일 업로드
			System.out.println("(fileup)SYSFILENAME : " + sysFileName);

			try {
				mf.transferTo(new File(path + sysFileName)); // 서버upload에 파일 저장
				return sysFileName;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} // while or For end
		return null;
	}

	// 파일 다운로드
	public void download(String fullPath, String oriFileName, HttpServletResponse resp) throws Exception {

		// 한글파일 깨짐 방지
		String downFile = URLEncoder.encode(oriFileName, "UTF-8");
		/* 파일명 뒤에 이상한 문자가 붙는 경우 아래코드를 해결 */
		// downFile = downFile.replaceAll("\\+", "");
		// 파일 객체 생성
		File file = new File(fullPath);

		// 다운로드 경로 파일을 읽어 들임
		InputStream is = new FileInputStream(file);
		// 반환객체설정
		//다운로드
		resp.setContentType("application/octet-stream");
		resp.setHeader("content-Disposition", "attachment; filename=\"" + downFile + "\"");
		//이미지 보여주기
		//resp.setContentType("image/jpeg");
		// 반환객체에 스트림 연결
		OutputStream os = resp.getOutputStream();

		// 파일쓰기
		byte[] buffer = new byte[1024];
		int length;
		while ((length = is.read(buffer)) != -1) {
			os.write(buffer, 0, length);
		}
		os.flush();  //출력버퍼 삭제
		os.close();
		is.close();
	}

	// 파일 삭제
	public void delete(String[] bfList) {

		for (String bf : bfList) {
			File file = new File(fullPath + "upload/" + bf);
			if (file.exists()) {
				file.delete();
				System.out.println("파일 삭제");
			} else {
				log.info("이미 삭제된 파일");
			}

		}

	}
}
