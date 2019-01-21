package com.sixe;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;

public class Note {
	private JSONObject json;
	private String uid;
	private Integer cmtct;
	private Integer retct;
	private String extra;
	private String type;
	private String rowkey_str;
	private String url;
	private String content;
	private String sentiment;
	private String retid;
	private String vstct;
	private Date pub_time;
	private String source;
	private String pname;
	private String brand;
	private Integer likct;
	private String word_pos;
	private String pid_str;

	public Note(JSONObject json) {
		this.json = json;
		this.uid = json.getString("uid");
		this.cmtct = json.getInteger("cmtct");
		this.retct = json.getInteger("retct");
		this.extra = json.getString("extra");
		this.type = json.getString("type");
		this.rowkey_str = json.getString("rowkey_str");
		this.url = json.getString("url");
		this.content = json.getString("content");
		this.sentiment = json.getString("sentiment");
		this.retid = json.getString("retid");
		this.vstct = json.getString("vstct");
		this.source = json.getString("source");
		this.pname = json.getString("pname");
		this.brand = json.getString("brand");
		this.likct = json.getInteger("likct");
		this.word_pos = json.getString("word_pos");
		this.pid_str = json.getString("pid_str");
		this.pub_time = json.getDate("pub_time");
	}

	public String getPub_time() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(pub_time);
	}

	public String getUid() {
		return uid;
	}

	public Integer getCmtct() {
		return cmtct;
	}

	public Integer getRetct() {
		return retct;
	}

	public String getExtra() {
		return extra;
	}

	public String getType() {
		return type;
	}

	public String getRowkey_str() {
		return rowkey_str;
	}

	public String getUrl() {
		return url;
	}

	public String getContent() {
		return content;
	}

	public String getSentiment() {
		return sentiment;
	}

	public String getRetid() {
		return retid;
	}

	public String getVstct() {
		return vstct;
	}

	public String getSource() {
		return source;
	}

	public String getPname() {
		return pname;
	}

	public String getBrand() {
		return brand;
	}

	public Integer getLikct() {
		return likct;
	}

	public String getWord_pos() {
		return word_pos;
	}

	public String getPid_str() {
		return pid_str;
	}
}
