package shop;

import java.io.Serializable;

public class ShohinBean implements Serializable {

	protected String code;		//商品コード
	protected String name;		//商品名
	protected String  vol;		//容量
	protected int price;			//価格
	protected String area;		//エリア
	protected String comment;	//コメント
	protected String image;		//画像名

	public ShohinBean() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVol() {
		return vol;
	}

	public void setVol(String vol) {
		this.vol = vol;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


}
