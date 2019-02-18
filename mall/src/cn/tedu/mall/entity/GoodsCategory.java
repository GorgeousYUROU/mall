package cn.tedu.mall.entity;


import java.io.Serializable;
import java.util.Date;

public class GoodsCategory implements Serializable {
	
	private static final long serialVersionUID = 180277264128211516L;
	
	/**
	 * id '����',
  `parent_id`  '������id',
  `name` '����',
  `status` '״̬   1������   2��ɾ��',
  `sort_order` '�����',
  `is_parent`'�Ƿ��Ǹ�����   1����  0����',
  `created_time` '����ʱ��',
  `modified_time` '����޸�ʱ��',
  `created_user`  '������',
  `modified_user`'����޸���',
	 */
	private Integer id;
	private Integer parentId;
	private String name;
	private Integer status;
	private Integer sortOrders;
	private Integer isParent;
	private Date create_time;
	private Date modify_time;
	private String createUser;
	private String modifyUser;
	
	public GoodsCategory() {

	}

	

	public GoodsCategory(Integer id, Integer parentId, String name, Integer status, Integer sortOrders,
			Integer isParent, Date create_time, Date modify_time, String createUser, String modifyUser) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.name = name;
		this.status = status;
		this.sortOrders = sortOrders;
		this.isParent = isParent;
		this.create_time = create_time;
		this.modify_time = modify_time;
		this.createUser = createUser;
		this.modifyUser = modifyUser;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public Integer getIsParent() {
		return isParent;
	}



	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}



	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSortOrders() {
		return sortOrders;
	}

	public void setSortOrders(Integer sortOrders) {
		this.sortOrders = sortOrders;
	}

	public Date getCreateTime() {
		return create_time;
	}

	public void setCreateTime(Date create_time) {
		this.create_time = create_time;
	}

	public Date getModifyTime() {
		return modify_time;
	}

	public void setModifyTime(Date modify_time) {
		this.modify_time = modify_time;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

 
	@Override
	public String toString() {
		return "GoodsCategory [id=" + id + ", parentId=" + parentId + ", name=" + name + ", status=" + status
				+ ", sortOrders=" + sortOrders + ", isParent=" + isParent + ", create_time=" + create_time
				+ ", modify_time=" + modify_time + ", createUser=" + createUser + ", modifyUser=" + modifyUser + "]";
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
		GoodsCategory other = (GoodsCategory) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
