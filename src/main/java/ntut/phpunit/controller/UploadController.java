package ntut.phpunit.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import ntut.revisionctrl.GITRevisionCtrl;
import ntut.revisionctrl.SVNRevisionCtrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.tmatesoft.svn.core.SVNException;

@RestController

public class UploadController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				ZipInputStream zIn = new ZipInputStream(
						new BufferedInputStream(file.getInputStream()));
				while (true) {
					ZipEntry zipEntry = zIn.getNextEntry();
					if (zipEntry == null)
						break;
					File f = new File("test/" + zipEntry.getName());
					if(!f.getParentFile().exists()){
						f.getParentFile().mkdirs();
					}
					FileOutputStream fOut = new FileOutputStream(f);
					int byteNo1;
				    byte[] b1 = new byte[64];
				 
				    while ((byteNo1=zIn.read(b1))>0) {
				        fOut.write(b1, 0, byteNo1);
				    }
				    fOut.close();
					System.out.println(zipEntry.getName());
				}
				zIn.close();
				return "You successfully uploaded "
						+ file.getOriginalFilename();
			} catch (Exception e) {
				return "You failed to upload " + file.getOriginalFilename()
						+ " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + " because the file was empty.";
		}
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test()
	{
		try {
			SVNRevisionCtrl t = new SVNRevisionCtrl();
		} catch (SVNException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "sucess";
	}
	
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2()
	{
		GITRevisionCtrl t = new GITRevisionCtrl();
		return "sucess";
	}

	

}
