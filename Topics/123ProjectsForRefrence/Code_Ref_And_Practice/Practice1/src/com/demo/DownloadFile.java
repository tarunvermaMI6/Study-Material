package com.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DownloadFile {

	public static void main(String[] args) {

		readAndWritePlayListFile();

	}
	/*
	 * public static void getURLFromFile() {
	 * 
	 * BufferedReader reader;
	 * 
	 * try { reader = new BufferedReader(new FileReader("D://process_files15.txt"));
	 * String line = reader.readLine(); int i = 0; while (line != null) { i++;
	 * downloadFile(line,i); line = reader.readLine(); }
	 * 
	 * reader.close(); } catch (IOException e) { e.printStackTrace(); } }
	 * 
	 * public static void downloadFile(String fileUrl,int index) {
	 * 
	 * fileUrl = fileUrl.replace("s3://etswb-ivs",
	 * "https://d2qcwkt44pzpsp.cloudfront.net"); fileUrl = fileUrl.replaceAll("\"",
	 * ""); String[] arr = fileUrl.split("/"); String fileName = arr[arr.length -
	 * 1];
	 * 
	 * System.out.println("fileUrl == "+fileUrl); URL url = null; try { // fileUrl =
	 * URLEncoder.encode(fileUrl, "UTF-8"); url = new URL(fileUrl); } catch
	 * (Exception e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * try (BufferedInputStream in = new BufferedInputStream(url.openStream());
	 * FileOutputStream fileOutputStream = new FileOutputStream("D://allfile/"
	 * +index+"-"+fileName)) { byte dataBuffer[] = new byte[1024]; int bytesRead;
	 * while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
	 * fileOutputStream.write(dataBuffer, 0, bytesRead); } } catch (IOException e) {
	 * e.printStackTrace(); } }
	 */

	public static void readAndWritePlayListFile() {

		File directoryPath = new File("D://allfile");
		File filesList[] = directoryPath.listFiles();
		BufferedReader reader;

		for (File file : filesList) {

			try {
				System.out.println(file.getName()+" ====>");
				reader = new BufferedReader(new FileReader(file.getAbsolutePath()));
				String line = reader.readLine();
				int i = 1;
				BufferedWriter writer = new BufferedWriter(new FileWriter("D://updatedFiles/" + file.getName(), true));

				while (line != null) {
					
					if (i > 49999) {
						break;
					}
					if(i == 49999 & line.contains("EXT")) {
						i++;
						break;
					}
					writer.write(line);
					writer.write(System.lineSeparator());
					
					i++;
					line = reader.readLine();
				}

				if (i > 49999) {
					writer.write("#EXT-X-ENDLIST");
				}
				writer.close();
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// break; // for testing
		}
	}

}
