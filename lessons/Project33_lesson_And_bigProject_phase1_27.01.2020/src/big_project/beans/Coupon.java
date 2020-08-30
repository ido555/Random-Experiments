package big_project.beans;

import java.sql.Date;

public class Coupon {
	private int couponId, companyId, customerId;
	private int amount, price;
	private String title, description, image;
	private Date startDate, endDate;
	private CategoryType category;

	public Coupon(int couponId, int companyId, int customerId, int amount, int price, String title, String description,
			String image, Date startDate, Date endDate, CategoryType category) {
		this.couponId = couponId;
		this.companyId = companyId;
		this.customerId = customerId;
		this.amount = amount;
		this.price = price;
		this.title = title;
		this.description = description;
		this.image = image;
		this.startDate = startDate;
		this.endDate = endDate;
		this.category = category;
	}

	public Coupon(int companyId, int customerId, int amount, int price, String title, String description, String image,
			Date startDate, Date endDate, CategoryType category) {
		this.companyId = companyId;
		this.customerId = customerId;
		this.amount = amount;
		this.price = price;
		this.title = title;
		this.description = description;
		this.image = image;
		this.startDate = startDate;
		this.endDate = endDate;
		this.category = category;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getCouponId() {
		return couponId;
	}

	public CategoryType getCategory() {
		return category;
	}

	public void setCategory(CategoryType category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", companyId=" + companyId + ", customerId=" + customerId + ", amount="
				+ amount + ", price=" + price + ", title=" + title + ", description=" + description + ", image=" + image
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", category=" + category + "]";
	}

}
