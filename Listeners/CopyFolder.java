package Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFolder 
{
	public  void FileUploads () throws IOException
	{
		
			delete();
			  File srcdir=new File("./BidsAutomation");
			  File destdir=new File("./Bids");
			 // make sure srcDir exists
			  if(!srcdir.exists())
			  {
				  System.out.println("Directory doesnot exists");
				  
			  }
			  else
			  {
				  copydir1(srcdir, destdir);
				  System.out.println("Copied successfully");
				  
			  }
		  }
		  
		  public void copydir1(File src,File dest) throws IOException
		  {
			  
			  if(src.isDirectory())
				  //if directory not exists create it
			  {
				  if (!dest.exists())
				  {
					  dest.mkdir();
					  System.out.println("Directory copied from " + src + " to " + dest);
				  }
				  
				  //list all the directory content
				  String files[]=src.list();
				  for(String filename: files)
				  {
					  File srcFile=new File (src,filename);
					  File destFile=new File(dest,filename);
					  copydir1(srcFile,destFile);
				  }
			  }
				  else
				  {
					  //if file then copy it
					  fileCopy(src,dest);
				  }
			  }
			  
		 

		private void fileCopy(File src, File dest) throws IOException 
		{
			InputStream in=null;
			OutputStream out=null;
			try
			{
				//if file ,then copy it
				in=new FileInputStream(src);
				out=new FileOutputStream(dest);
				byte[] buffer=new byte[1024];
				int length;
				while((length =in.read(buffer))>0)
				{
					out.write(buffer, 0,length);
				}
			}
			finally
			{
				if(in!= null)
				{
					in.close();
				}
				if(out!= null)
				{
					out.close();
				}
			}
			
			System.out.println("File copied from " + src + " to " + dest);
		}
		
		public  void delete()
		{ 
			File dir = new File("./Bids");
		
			
			if(dir.isDirectory() == false) {
				System.out.println("Not a directory. Do nothing");
				return;
			}
			File[] listFiles = dir.listFiles();
			for(File file : listFiles){
				System.out.println("Deleting "+file.getName());
				file.delete();
			}
			//now directory is empty, so we can delete it
			System.out.println("Deleting Directory. Success = "+dir.delete());
	}
		
}

				
		
		
		
		
		
		


