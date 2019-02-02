package ExcelToJson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.alibaba.fastjson.JSONObject;

public class ExcelToJson4 {
	public static void main(String args[]) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\java\\fuquanz\\newfile\\Chinese_haircare_dataset_3 轻描.tsv");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] split = line.split("\t");
			JSONObject js = new JSONObject();
			js.put("Text", split[0]);
			js.put("Annotation", split[1]);
			js.put("Target", split[2]);
			js.put("Feature", split[3]);
			js.put("Opinion", split[4]);
			js.put("Polarity", split[5]);
			js.put("First Layer", split[6]);
			js.put("Second Layer", split[7]);
			if (Integer.parseInt(split[1]) == 0) {
				list.add(js);
			}
		}
		String line1 = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter("D:\\java\\fuquanz\\Dataset-4.txt", true);
		for (JSONObject c : list) {
			str.append(c + "\t").append(line1);
		}
		fw.write(str.toString());
		fw.close();
	}
}
