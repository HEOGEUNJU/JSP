package kr.or.ddit.mvc.multipart;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

public class StandardServletMultipartFile implements MultipartFile{

	public Part adaptee;
	
	public StandardServletMultipartFile(Part adaptee) {
		super();
		this.adaptee = adaptee;
	}

	@Override
	public byte[] getBytes() throws IOException{
//		ByteArrayOutputStream os = new ByteArrayOutputStream();
//		InputStream is = getInputStream();
//		byte[]  os.toByteArray();
		return IOUtils.toByteArray(getInputStream());
	}

	@Override
	public String getContentType() {
		return adaptee.getContentType();
	}

	@Override
	public InputStream getInputStream() throws IOException{
		// TODO Auto-generated method stub
		return adaptee.getInputStream();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return adaptee.getName();
	}

	@Override
	public String getOriginalFilename() {
		// TODO Auto-generated method stub
		return adaptee.getSubmittedFileName();
	}

	@Override
	public long getSize() {
		// TODO Auto-generated method stub
		return adaptee.getSize();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return StringUtils.isBlank(getOriginalFilename());
	}

	@Override
	public void transferTo(File dest) throws IOException{
		// TODO Auto-generated method stub
		adaptee.write(dest.getCanonicalPath());
	}

}
