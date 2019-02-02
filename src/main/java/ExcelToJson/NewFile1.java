package ExcelToJson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class NewFile1 {
	private ArrayList<JSONObject> list;
	private String path;

	public NewFile1(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		this.list = new ArrayList<JSONObject>();
		String line = null;
		while ((line = br.readLine()) != null) {
			JSONObject json = JSONObject.parseObject(line);
			list.add(json);
		}
	}

	public HashMap<String, List<JSONObject>> solve() {
		HashMap<String, List<JSONObject>> map = new HashMap<String, List<JSONObject>>();
		for (JSONObject c : list) {
			Object text = c.get("Text");
			String str = text.toString();
			if (map.containsKey(str)) {
				map.get(str).add(c);
			} else {
				ArrayList<JSONObject> list1 = new ArrayList<JSONObject>();
				list1.add(c);
				map.put(str, list1);
			}
		}
		return map;
	}

	public static HashSet<JSONObject> solve2(List<JSONObject> list) {
		HashSet<JSONObject> set = new HashSet<JSONObject>();
		for (JSONObject c : list) {
			Object polarity = c.get("Polarity");
			Object target = c.get("Target");
			Object first_layer = c.get("First Layer");
			Object second_layer = c.get("Second Layer");
			JSONObject json = new JSONObject();
			if (polarity.equals("正向")) {
				polarity = "Positive";
			}
			if (polarity.equals("负向") || polarity.equals("反向")) {
				polarity = "Negative";
			}
			json.put("sentiment", polarity);
			json.put("target_entity", target);
			json.put("first_layer", first_layer);
			json.put("second_layer", second_layer);
			set.add(json);
		}
		return set;
	}

	public static void read(String path, HashMap<String, List<JSONObject>> map) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		int id = 0;
		JSONArray array = new JSONArray();
		for (Map.Entry<String, List<JSONObject>> c : map.entrySet()) {
			id++;
			String text = c.getKey();
			List<JSONObject> value = c.getValue();
			HashSet<JSONObject> opinions = solve2(value);
			JSONObject js = new JSONObject();
			js.put("opinions", opinions);
			js.put("text", text);
			js.put("id", id);
			array.add(js);
		}
		fw.write(array.subList(0, 3148).toString());
		fw.close();
	}

	public static void read2(String path, HashMap<String, List<JSONObject>> map) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		int id = 0;
		JSONArray array = new JSONArray();
		for (Map.Entry<String, List<JSONObject>> c : map.entrySet()) {
			id++;
			String text = c.getKey();
			List<JSONObject> value = c.getValue();
			HashSet<JSONObject> opinions = solve2(value);
			JSONObject js = new JSONObject();
			js.put("opinions", opinions);
			js.put("text", text);
			js.put("id", id);
			array.add(js);
		}
		fw.write(array.subList(3148, 4047).toString());
		fw.close();
	}

	public static void read3(String path, HashMap<String, List<JSONObject>> map) throws IOException {
		String line = System.getProperty("line.separator");
		StringBuffer str = new StringBuffer();
		FileWriter fw = new FileWriter(path, false);
		int id = 0;
		JSONArray array = new JSONArray();
		for (Map.Entry<String, List<JSONObject>> c : map.entrySet()) {
			id++;
			String text = c.getKey();
			List<JSONObject> value = c.getValue();
			HashSet<JSONObject> opinions = solve2(value);
			JSONObject js = new JSONObject();
			js.put("opinions", opinions);
			js.put("text", text);
			js.put("id", id);
			array.add(js);
		}
		fw.write(array.subList(4047, 4497).toString());
		fw.close();
	}

	public static void main(String args[]) throws IOException {
		String path = "D:\\java\\fuquanz\\Dataset-4.txt";
		String path2 = "D:\\java\\fuquanz\\newFile.txt";
		String path3 = "D:\\java\\fuquanz\\newFile2.txt";
		String path4 = "D:\\java\\fuquanz\\newFile3.txt";
		NewFile1 nf = new NewFile1(path);
		HashMap<String, List<JSONObject>> map = nf.solve();
		NewFile1.read(path2, map);
		NewFile1.read2(path3, map);
		NewFile1.read3(path4, map);
	}
}
