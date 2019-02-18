package cn.tedu.mall.entity;

import java.util.Date;

public class Goods {
	
	private String id;
	private Integer category_id;
	private String item_type;
	private String title;
	private String sell_point;
	private String price;
	private Integer num;
	private String barcode;
	private String image;
	private Integer status;
	private Integer priority;
	private Date created_time;
	private Date modified_time;
	private String created_user;
	private String modified_user;
	public Goods() {
		super();
		
	}
	public Goods(String id, Integer category_id, String item_type, String title, String sell_point, String price,
			Integer num, String barcode, String image, Integer status, Integer priority, Date created_time,
			Date modified_time, String created_user, String modified_user) {
		super();
		this.id = id;
		this.category_id = category_id;
		this.item_type = item_type;
		this.title = title;
		this.sell_point = sell_point;
		this.price = price;
		this.num = num;
		this.barcode = barcode;
		this.image = image;
		this.status = status;
		this.priority = priority;
		this.created_time = created_time;
		this.modified_time = modified_time;
		this.created_user = created_user;
		this.modified_user = modified_user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goods other = (Goods) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", category_id=" + category_id + ", item_type=" + item_type + ", title=" + title
				+ ", sell_point=" + sell_point + ", price=" + price + ", num=" + num + ", barcode=" + barcode
				+ ", image=" + image + ", status=" + status + ", priority=" + priority + ", created_time="
				+ created_time + ", modified_time=" + modified_time + ", created_user=" + created_user
				+ ", modified_user=" + modified_user + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSell_point() {
		return sell_point;
	}
	public void setSell_point(String sell_point) {
		this.sell_point = sell_point;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getPriority() {
		return priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	public Date getModified_time() {
		return modified_time;
	}
	public void setModified_time(Date modified_time) {
		this.modified_time = modified_time;
	}
	public String getCreated_user() {
		return created_user;
	}
	public void setCreated_user(String created_user) {
		this.created_user = created_user;
	}
	public String getModified_user() {
		return modified_user;
	}
	public void setModified_user(String modified_user) {
		this.modified_user = modified_user;
	}
	
	
	
	
	
}
