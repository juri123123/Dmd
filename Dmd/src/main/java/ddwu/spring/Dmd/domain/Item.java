package ddwu.spring.Dmd.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable, Comparable<Item> {
	/* Private Fields */
	private int itemId; // (PK) String- > int
	private int unitCost;
	private String title;
	private String description;
	private int viewCount;
	private int qty;
	private String userId; // (FK)
	private int productId; // (FK)

	public Item() {
	}

	public Item(int unitCost, String title, String description, int qty, String userId, int productId) {
		this.unitCost = unitCost;
		this.title = title;
		this.description = description;
		this.qty = qty;
		this.userId = userId;
		this.productId = productId;
	}

	public Item(int itemId, int unitCost, String title, String description, int viewCount, int qty,
			String userId, int productId) {
		this.itemId = itemId;
		this.unitCost = unitCost;
		this.title = title;
		this.description = description;
		this.viewCount = viewCount;
		this.qty = qty;
		this.userId = userId;
		this.productId = productId;
	}

	/* JavaBeans Properties */
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(int unitCost) {
		this.unitCost = unitCost;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", unitCost=" + unitCost + ", title=" + title + ", description=" + description
				+ ", viewCount=" + viewCount + ", qty=" + qty + ", userId=" + userId + ", productId=" + productId + "]";
	}

	@Override
	public int compareTo(Item i) { // 조회수 기준으로 내림차순 정렬
		if (this.viewCount < i.getViewCount()) {
			return 1;
		} else if (this.viewCount > i.getViewCount()) {
			return -1;
		}
		return 0;
	}
}